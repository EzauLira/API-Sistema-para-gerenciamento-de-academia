package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;

public interface ISegurancaConfig {

    String criptografarSenha(String senha);

    //------------------------------------------------------------------------------------------------------------------------------------//

    boolean compararSenhaHash(String senha, String senhaHash);

    //------------------------------------------------------------------------------------------------------------------------------------//

    int buscarIdToken(String token);

    //------------------------------------------------------------------------------------------------------------------------------------//

    String gerarToken(Cliente cliente);

    //------------------------------------------------------------------------------------------------------------------------------------//


}
