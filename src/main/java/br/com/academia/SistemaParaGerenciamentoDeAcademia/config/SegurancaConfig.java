package br.com.academia.SistemaParaGerenciamentoDeAcademia.config;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.ISegurancaConfig;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SegurancaConfig implements ISegurancaConfig {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public String criptografarSenha(String senha) {
        return passwordEncoder.encode(senha);
    }

    @Override
    public boolean compararSenhaHash(String senha, String senhaHash) {
        return passwordEncoder.matches(senha, senhaHash);
    }

    @Override
    public int buscarIdToken(String token) {
        return JwtUtil.decodificarToken(token.replace("Bearer ", "")).getId();
    }

    @Override
    public String gerarToken(Cliente cliente) {
        return JwtUtil.gerarToken(cliente);
    }
}
