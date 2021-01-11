package pt.ufp.info.esof.Repositorio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pt.ufp.info.esof.Models.Tarefa;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class TarefaRepositorioTest {
    @Autowired
    private TarefaRepositorio tarefaRepositorio;


    @Test
    public void testeCriacaoTarefa(){
        Tarefa tarefa = new Tarefa();

        assertEquals(0,tarefaRepositorio.count());
        tarefaRepositorio.save(tarefa);
        assertEquals(1,tarefaRepositorio.count());


    }
}