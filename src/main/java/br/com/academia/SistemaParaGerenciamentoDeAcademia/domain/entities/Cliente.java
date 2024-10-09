package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.TipoUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private int idCliente;
    private String nome;
    private int idade;
    private String cpf;
    private int genero;
    private String telefone;
    private String email;
    private int idPlano;
    private String senha;
    private TipoUsuarioEnum tipoUsuario;
}
