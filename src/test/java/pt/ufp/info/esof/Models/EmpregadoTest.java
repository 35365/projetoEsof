package pt.ufp.info.esof.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpregadoTest {

    @Test
    void valorHora() {
        Empregado empregado=new Empregado();

        empregado.setCargo("DesenvolvedorJunior");
        assertEquals(10,empregado.valorHora());

        empregado.setCargo("AnalistaJunior");
        assertEquals(20,empregado.valorHora());

        empregado.setCargo("DesenvolvedorSenior");
        assertEquals(40,empregado.valorHora());

        empregado.setCargo("AnalistaSenior");
        assertEquals(80,empregado.valorHora());
    }

    @Test
    void adicionarTarefa() {
        Empregado empregado=new Empregado();

        assertEquals(0,empregado.getTarefas().size());

        Tarefa tarefa1 = new Tarefa();
        empregado.adicionarTarefa(tarefa1);
        assertEquals(1,empregado.getTarefas().size());

        empregado.adicionarTarefa(tarefa1);
        assertEquals(1,empregado.getTarefas().size());

        Tarefa tarefa2 = new Tarefa();
        empregado.adicionarTarefa(tarefa2);
        assertEquals(2,empregado.getTarefas().size());


    }
}