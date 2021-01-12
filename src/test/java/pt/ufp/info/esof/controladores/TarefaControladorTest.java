package pt.ufp.info.esof.controladores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pt.ufp.info.esof.Models.Tarefa;
import pt.ufp.info.esof.dtos.EmpregadoCriarDTO;
import pt.ufp.info.esof.servicos.TarefaServico;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TarefaControlador.class)
class TarefaControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TarefaServico tarefaServico;

    @Test
    void criarTarefa() throws Exception {
        Tarefa tarefa =new Tarefa();
        tarefa.setNome("NovaTarefa");

        when(tarefaServico.criarTarefa(tarefa)).thenReturn(Optional.of(tarefa));

        String tarefaJson= new ObjectMapper().writeValueAsString(tarefa);

        mockMvc.perform(post("/tarefa").content(tarefaJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Tarefa tarefaExistente = new Tarefa();
        tarefaExistente.setNome("tarefa1");

        String tarefaExistenteJson = new ObjectMapper().writeValueAsString(tarefaExistente);

        mockMvc.perform(post("/tarefa").content(tarefaExistenteJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void adicionarEmpregado() throws Exception {
        Tarefa tarefa=new Tarefa();
        tarefa.setNome("tarefaEmpregado");

        EmpregadoCriarDTO empregado=new EmpregadoCriarDTO();
        empregado.setUsername("novo");

        String empregadoJson = new ObjectMapper().writeValueAsString(empregado);

        when(tarefaServico.adicionarEmpregado(1L,empregado.converter())).thenReturn(Optional.of(tarefa));

        mockMvc.perform(
                patch("/tarefa/1")
                        .content(empregadoJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(
                patch("/tarefa/5")
                        .content(empregadoJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}