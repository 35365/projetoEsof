package pt.ufp.info.esof.servicos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pt.ufp.info.esof.modelos.Projeto;
import pt.ufp.info.esof.modelos.Tarefa;
import pt.ufp.info.esof.repositorio.ProjetoRepositorio;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ProjetoServicoImpl.class)
class ProjetoServicoImplTest {

    @Autowired
    private ProjetoServico projetoServico;
    @MockBean
    private ProjetoRepositorio projetoRepositorio;

    @Test
    void criarProjeto() {
        String nome ="nome";

        Projeto projeto = new Projeto();
        projeto.setNome(nome);

        when(projetoRepositorio.save(projeto)).thenReturn(projeto);

        assertTrue(projetoServico.criarProjeto(projeto).isPresent());

        when(projetoRepositorio.findByNome(nome)).thenReturn(Optional.of(projeto));
        assertTrue(projetoServico.criarProjeto(projeto).isEmpty());
    }

    @Test
    void adicionarTarefa() {
        Projeto projeto = new Projeto();
        Tarefa tarefa = new Tarefa();
        when(projetoServico.adicionarTarefa(1L,tarefa)).thenReturn(Optional.of(projeto));
        assertTrue(projetoServico.adicionarTarefa(1L,tarefa).isPresent());
        assertTrue(projetoServico.adicionarTarefa(5L,tarefa).isEmpty());
    }

    @Test
    void findById() {
        when(projetoRepositorio.findById(1L)).thenReturn(Optional.of(new Projeto()));
        assertTrue(projetoServico.findById(1L).isPresent());
        assertTrue(projetoServico.findById(5L).isEmpty());
    }

    @Test
    void findAll() {
        when(projetoRepositorio.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(projetoServico.findAll());
    }
}