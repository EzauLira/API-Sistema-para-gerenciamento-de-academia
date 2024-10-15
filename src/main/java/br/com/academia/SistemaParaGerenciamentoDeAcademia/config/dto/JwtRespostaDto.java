package br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.TipoUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtRespostaDto {

    private int id;
    private String cpf;
    private TipoUsuarioEnum tipoUsuario;
}
