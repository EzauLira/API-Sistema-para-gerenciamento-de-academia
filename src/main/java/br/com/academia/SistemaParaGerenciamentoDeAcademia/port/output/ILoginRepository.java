package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;

public interface ILoginRepository {

    //------------------------------------------------------------------------------------------------------------------------------------//

    Cliente existePessoa(String cpf);

    //------------------------------------------------------------------------------------------------------------------------------------//

}
