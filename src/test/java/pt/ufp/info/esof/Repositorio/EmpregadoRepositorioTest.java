package pt.ufp.info.esof.Repositorio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pt.ufp.info.esof.Models.Empregado;
import pt.ufp.info.esof.Models.Tarefa;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmpregadoRepositorioTest {
    @Autowired
    private EmpregadoRepositorio empregadoRepositorio;
    @Autowired
    private TarefaRepositorio tarefaRepositorio;

    @Test
    public void testeCriacaoEmpregado(){
        Empregado empregado = new Empregado();

        empregado.setHorasTarefa(10);
        empregado.setNome("empregado");
        empregado.setCargo("DesenvolvedorJunior");
        empregado.setUsername("empregado");

        Tarefa tarefa = new Tarefa();
        tarefa.setEmpregado(empregado);

        empregado.adicionarTarefa(tarefa);

        assertEquals(0,empregadoRepositorio.count());
        assertEquals(0,tarefaRepositorio.count());
        empregadoRepositorio.save(empregado);
        assertEquals(1,empregadoRepositorio.count());
        assertEquals(1,tarefaRepositorio.count());

        assertTrue(empregadoRepositorio.findByUsername(empregado.getUsername()).isPresent());
    }

}