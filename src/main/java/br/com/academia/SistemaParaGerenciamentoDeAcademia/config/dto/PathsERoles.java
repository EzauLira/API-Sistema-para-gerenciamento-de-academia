package br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.TipoUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PathsERoles {

    private String path;
    private List<TipoUsuarioEnum> roles;
}
