package pt.ufp.info.esof.modelos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ProjetoTest {

    @Test
    void adicionarTarefa() {
        Projeto projeto = new Projeto();

        Tarefa tarefa = new Tarefa();

        assertEquals(0,projeto.getTarefas().size());

        projeto.adicionarTarefa(tarefa);
        assertEquals(1,projeto.getTarefas().size());

        projeto.adicionarTarefa(tarefa);
        assertEquals(1,projeto.getTarefas().size());
    }

    @Test
    void tempoEstimado() {
        Projeto projeto = new Projeto();

        Tarefa tarefa1 = new Tarefa();
        Empregado empregadoDJ = new Empregado();
        empregadoDJ.setCargo("DesenvolvedorJunior");
        empregadoDJ.setHorasTarefa(20);
        tarefa1.setEmpregado(empregadoDJ);

        Tarefa tarefa2 = new Tarefa();
        Empregado empregadoAJ = new Empregado();
        empregadoAJ.setCargo("AnalistaJunior");
        empregadoAJ.setHorasTarefa(2);
        tarefa2.setEmpregado(empregadoAJ);

        projeto.adicionarTarefa(tarefa1);
        projeto.adicionarTarefa(tarefa2);

        assertEquals(22,projeto.tempoEstimado());
    }

    @Test
    void valorEstimado() {
        Projeto projeto = new Projeto();

        Tarefa tarefa1 = new Tarefa();
        Empregado empregadoDJ = new Empregado();
        empregadoDJ.setCargo("DesenvolvedorJunior");
        empregadoDJ.setHorasTarefa(20);
        tarefa1.setEmpregado(empregadoDJ);

        Tarefa tarefa2 = new Tarefa();
        Empregado empregadoAJ = new Empregado();
        empregadoAJ.setCargo("AnalistaJunior");
        empregadoAJ.setHorasTarefa(2);
        tarefa2.setEmpregado(empregadoAJ);

        projeto.adicionarTarefa(tarefa1);
        projeto.adicionarTarefa(tarefa2);

        assertEquals(240,projeto.valorEstimado());
    }
}