package pt.ufp.info.esof.servicos.facade;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pt.ufp.info.esof.Models.Tarefa;
import pt.ufp.info.esof.servicos.TarefaServico;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = TarefaServicoFacade.class)
class TarefaServicoFacadeTest {

    @Autowired
    private TarefaServico tarefaServico;

    @MockBean
    private CriarTarefaUseCase criarTarefaUseCase;

    @Test
    void criarTarefa() {
        String nomeTarefa="tarefaExistente";

        Tarefa tarefa = new Tarefa();
        tarefa.setNome(nomeTarefa);

        when(criarTarefaUseCase.criarTarefa(tarefa)).thenReturn(Optional.of(tarefa));

        assertTrue(tarefaServico.criarTarefa(tarefa).isPresent());

    }
}