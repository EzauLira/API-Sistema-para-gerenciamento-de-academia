package br.com.academia.SistemaParaGerenciamentoDeAcademia.utils;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.JwtResponseDto;
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
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);;

    public static String gerarToken(Cliente cliente) {
        return Jwts.builder()
                .setSubject(cliente.getEmail())
                .claim("id", cliente.getIdCliente())
                .claim("email", cliente.getEmail())
                .claim("tipoUsuario", cliente.getTipoUsuario().name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static JwtResponseDto decodificarToken(String token) {
        Jws<Claims> jws = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token);
        Claims claims = jws.getBody();

        JwtResponseDto jwtResponseDTO = new JwtResponseDto();
        jwtResponseDTO.setId(claims.get("id", Integer.class));
        jwtResponseDTO.setEmail(claims.get("email", String.class));
        jwtResponseDTO.setTipoUsuario(TipoUsuarioEnum.valueOf(claims.get("tipoUsuario", String.class)));

        return jwtResponseDTO;
    }
}