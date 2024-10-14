package br.com.academia.SistemaParaGerenciamentoDeAcademia.utils;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.JwtRespostaDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.TipoUsuarioEnum;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final Key SenhaSecreta = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String gerarToken(Cliente cliente) {
        return Jwts.builder()
                .setSubject(cliente.getCpf())
                .claim("id", cliente.getIdCliente())
                .claim("cpf", cliente.getCpf())
                .claim("tipoUsuario", cliente.getTipoUsuario().name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS256, SenhaSecreta)
                .compact();
    }

    public static JwtRespostaDto decodificarToken(String token) {
        Jws<Claims> jws = Jwts.parserBuilder()
                .setSigningKey(SenhaSecreta)
                .build()
                .parseClaimsJws(token);
        Claims claims = jws.getBody();

        JwtRespostaDto jwtRespostaDTO = new JwtRespostaDto();
        jwtRespostaDTO.setId(claims.get("id", Integer.class));
        jwtRespostaDTO.setCpf(claims.get("cpf", String.class));
        jwtRespostaDTO.setTipoUsuario(TipoUsuarioEnum.valueOf(claims.get("tipoUsuario", String.class)));

        return jwtRespostaDTO;
    }
}