package br.com.academia.SistemaParaGerenciamentoDeAcademia.config.seguranca;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.ErroAutenticacaoRespostaDTO;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.JwtRespostaDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.ErroBancoDadosEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.TipoUsuarioEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.ErroResposta;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.JwtUtil;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.RotasUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class SistemaControleFiltro extends OncePerRequestFilter {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(SistemaControleFiltro.class);
    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    protected void doFilterInternal(HttpServletRequest requisicao, HttpServletResponse resposta, FilterChain filterChain)
            throws ServletException, IOException {
        LOGGER.info("Início do método doFilterInternal");


        if (!checarPathExistente(requisicao)) {
            resposta.sendError(HttpStatus.NOT_FOUND.value());
            return;
        }

        if (checarRoleExistente(requisicao)) {
            if (!checarHeadersExistente(requisicao)) {
                envioBadRequestResposta(resposta, requisicao);
                return;
            } else {
                try {
                    String token = requisicao.getHeader("Authorization").replace("Bearer ", "");
                    JwtRespostaDto jwtRespostaDTO = JwtUtil.decodificarToken(token);
                    TipoUsuarioEnum tipoUsuarioEnum = jwtRespostaDTO.getTipoUsuario();

                    if (!ehRoleAutorizado(requisicao, tipoUsuarioEnum)) {
                        envioErroAcessoARotaResposta(resposta, requisicao);
                        return;
                    }

                } catch (Exception e) {
                    LOGGER.error("Erro ao decodificar o token JWT: {}", e.getMessage());
                    envioTokenInvalidoResposta(resposta, requisicao);
                    return;
                }
            }
        }
        filterChain.doFilter(requisicao, resposta);
    }

    private boolean checarPathExistente(HttpServletRequest requisicao) {
        String rota = requisicao.getServletPath();
        if (rota.contains("/swagger")) {
            return true;
        }
        return RotasUtil.pegarRotas(resourceLoader).containsKey(rota);
    }

    private boolean checarHeadersExistente(HttpServletRequest requisicao) {
        return requisicao.getHeader("Authorization") != null && !requisicao.getHeader("Authorization").isBlank();
    }

    private boolean checarRoleExistente(HttpServletRequest requisicao) {
        List<TipoUsuarioEnum> roles = RotasUtil.pegarRotas(resourceLoader).get(requisicao.getServletPath());

        if (roles == null || roles.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean ehRoleAutorizado(HttpServletRequest requisicao, TipoUsuarioEnum tipoUsuario) {
        try {
            return RotasUtil.pegarRotas(resourceLoader).get(requisicao.getServletPath()).contains(tipoUsuario);
        } catch (Exception e) {
            return false;
        }
    }

    private void envioBadRequestResposta(HttpServletResponse resposta, HttpServletRequest requisicao) throws IOException {
        resposta.setStatus(HttpStatus.BAD_REQUEST.value());
        resposta.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ErroAutenticacaoRespostaDTO erroResposta
                = ErroResposta
                .criarRespostaErro(ErroBancoDadosEnum.DESC_BAD_REQUEST_HEADERS.getMensagemCustom(), requisicao.getServletPath(), HttpStatus.BAD_REQUEST.value());
        resposta.getWriter().write(objectMapper.writeValueAsString(erroResposta));
    }

    private void envioErroAcessoARotaResposta(HttpServletResponse resposta, HttpServletRequest requisicao) throws IOException {
        resposta.setStatus(HttpStatus.FORBIDDEN.value());
        resposta.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ErroAutenticacaoRespostaDTO erroResposta = ErroResposta
                .criarRespostaErro(
                        ErroBancoDadosEnum.DESC_ROLE_SEM_PERMISSAO.getMensagemCustom(),
                        requisicao.getServletPath(),
                        HttpStatus.FORBIDDEN.value()
                );
        resposta.getWriter().write(objectMapper.writeValueAsString(erroResposta));
    }

    private void envioTokenInvalidoResposta(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ErroAutenticacaoRespostaDTO erroResposta
                = ErroResposta.criarRespostaErro(
                ErroBancoDadosEnum.DESC_TOKEN_INVALIDO.getMensagemCustom(), request.getServletPath(), HttpStatus.BAD_REQUEST.value());
        response.getWriter().write(objectMapper.writeValueAsString(erroResposta));
    }
}
