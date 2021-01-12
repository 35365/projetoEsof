package pt.ufp.info.esof.controladores;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pt.ufp.info.esof.Models.Projeto;
import pt.ufp.info.esof.dtos.TarefaCriarDTO;
import pt.ufp.info.esof.servicos.ProjetoServico;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProjetoControlador.class)
class ProjetoControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjetoServico projetoServico;

    @Test
    void criarProjeto() throws Exception {
        Projeto projeto=new Projeto();
        projeto.setNome("NovoProjeto");

        when(projetoServico.criarProjeto(projeto)).thenReturn(Optional.of(projeto));

        String projetoJson = new ObjectMapper().writeValueAsString(projeto);

        mockMvc.perform(post("/projeto").content(projetoJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void adicionarTarefa() throws Exception {
        Projeto projeto=new Projeto();
        projeto.setNome("projetoExistente");

        TarefaCriarDTO tarefa = new TarefaCriarDTO();
        tarefa.setNome("addTarefa");

        String tarefaJson = new ObjectMapper().writeValueAsString(tarefa);

        when(projetoServico.adicionarTarefa(1L,tarefa.converter())).thenReturn(Optional.of(projeto));

        mockMvc.perform(
                patch("/projeto/1")
                .content(tarefaJson).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        mockMvc.perform(
                patch("/projeto/5")
                        .content(tarefaJson).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest());
    }

    @Test
    void getValorProjetoById() {
    }

    @Test
    void getProjetoById() throws Exception {
        when(projetoServico.findById(1L)).thenReturn(Optional.of(new Projeto()));

        mockMvc.perform(
                get("/projeto/1")
        ).andExpect(status().isOk());

        mockMvc.perform(
                get("/projeto/3")
        ).andExpect(status().isNotFound());
    }

    @Test
    void getTempoProjetoById() {
    }
}