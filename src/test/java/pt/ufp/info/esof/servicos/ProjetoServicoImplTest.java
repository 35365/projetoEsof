package pt.ufp.info.esof.servicos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pt.ufp.info.esof.Models.Projeto;
import pt.ufp.info.esof.Repositorio.ProjetoRepositorio;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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
}