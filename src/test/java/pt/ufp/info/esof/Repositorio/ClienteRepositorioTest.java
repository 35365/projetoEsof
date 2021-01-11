package pt.ufp.info.esof.Repositorio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pt.ufp.info.esof.Models.Cliente;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClienteRepositorioTest {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    public void testeCriacaoCliente(){
        Cliente cliente = new Cliente();

        cliente.setNome("cliente1");

        assertEquals(0,clienteRepositorio.count());
        clienteRepositorio.save(cliente);
        assertEquals(1,clienteRepositorio.count());

    }


}