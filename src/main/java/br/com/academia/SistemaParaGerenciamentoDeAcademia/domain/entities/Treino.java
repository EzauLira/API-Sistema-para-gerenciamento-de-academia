package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe para representar um treino na academia.
 * Esta classe é usada para armazenar as informações de um treino.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Treino {

    private int id;
    private String nome;
    private String descricao;

}
