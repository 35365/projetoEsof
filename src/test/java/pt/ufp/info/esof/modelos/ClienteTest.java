package pt.ufp.info.esof.modelos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ClienteTest {

    @Test
    void adicionarProjeto() {
        Cliente cliente = new Cliente();

        Projeto projeto = new Projeto();

        assertEquals(0,cliente.getProjetos().size());

        cliente.adicionarProjeto(projeto);
        assertEquals(1,cliente.getProjetos().size());

        cliente.adicionarProjeto(projeto);
        assertEquals(1,cliente.getProjetos().size());
    }
}