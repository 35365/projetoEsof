package pt.ufp.info.esof.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TarefaTest {

    @Test
    void horasEstimadas() {
        Tarefa tarefa = new Tarefa();

        Empregado empregadoDJ = new Empregado();
        empregadoDJ.setCargo("DesenvolvedorJunior");
        empregadoDJ.setHorasTarefa(20);

        tarefa.setEmpregado(empregadoDJ);

        assertEquals(20,tarefa.horasEstimadas());


    }

    @Test
    void custo() {
        Tarefa tarefa = new Tarefa();

        Empregado empregadoDJ = new Empregado();
        empregadoDJ.setCargo("DesenvolvedorJunior");
        empregadoDJ.setHorasTarefa(20);

        tarefa.setEmpregado(empregadoDJ);

        assertEquals(200,tarefa.custo());

        Empregado empregadoAJ = new Empregado();
        empregadoAJ.setCargo("AnalistaJunior");
        empregadoAJ.setHorasTarefa(2);

        tarefa.setEmpregado(empregadoAJ);

        assertEquals(40,tarefa.custo());

        Empregado empregadoDS = new Empregado();
        empregadoDS.setCargo("DesenvolvedorSenior");
        empregadoDS.setHorasTarefa(2);

        tarefa.setEmpregado(empregadoDS);

        assertEquals(80,tarefa.custo());

        Empregado empregadoAS = new Empregado();
        empregadoAS.setCargo("AnalistaSenior");
        empregadoAS.setHorasTarefa(1);

        tarefa.setEmpregado(empregadoAS);

        assertEquals(80,tarefa.custo());


    }
}