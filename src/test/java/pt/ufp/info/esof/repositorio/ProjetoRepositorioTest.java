package pt.ufp.info.esof.repositorio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pt.ufp.info.esof.modelos.Cliente;
import pt.ufp.info.esof.modelos.Projeto;
import pt.ufp.info.esof.modelos.Tarefa;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ProjetoRepositorioTest {
    @Autowired
    private ProjetoRepositorio projetoRepositorio;
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Autowired
    private TarefaRepositorio tarefaRepositorio;

    @Test
    public void testeCriacaoProjeto(){

        Projeto projeto = new Projeto();
        projeto.setPercentual(0);

        Cliente cliente = new Cliente();
        cliente.setNome("cliente1");

        projeto.setCliente(cliente);

        Tarefa tarefa = new Tarefa();
        tarefa.setProjeto(projeto);

        projeto.adicionarTarefa(tarefa);

        assertNull(cliente.getId());
        clienteRepositorio.save(cliente);
        assertNotNull(cliente.getId());

        assertEquals(0,tarefaRepositorio.count());
        assertEquals(0,projetoRepositorio.count());

        assertNull(tarefa.getId());
        assertNull(projeto.getId());
        projetoRepositorio.save(projeto);
        assertNotNull(projeto.getId());

        assertEquals(1,projetoRepositorio.count());


    }
}