package pt.ufp.info.esof.controladores;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pt.ufp.info.esof.Models.Empregado;
import pt.ufp.info.esof.servicos.EmpregadoServico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmpregadoControlador.class)
class EmpregadoControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpregadoServico empregadoServico;


    @Test
    void getAllEmpregado() throws Exception {

        List<Empregado> empregados=new ArrayList<>();
        empregados.add(new Empregado());

        when(empregadoServico.findAll()).thenReturn(empregados);

        String responseJson = mockMvc.perform(
                get("/empregado")
        ).andExpect( status().isOk()
        ).andDo( print()
        ).andReturn().getResponse().getContentAsString();

        System.out.println(responseJson);
    }

    @Test
    void getEmpregadoById() throws Exception {
        when(empregadoServico.findById(1L)).thenReturn(Optional.of(new Empregado()));

        mockMvc.perform(get("/empregado/1")).andExpect(status().isOk());

        mockMvc.perform(get("/empregado/10")).andExpect(status().isNotFound());

    }

    @Test
    void criarEmpregado() throws Exception {

        Empregado empregado = new Empregado();
        empregado.setUsername("mm");
        empregado.setCargo("AnalistaJunior");

        when(this.empregadoServico.criarEmpregado(empregado)).thenReturn(Optional.of(empregado));

        String empregadoJson= new ObjectMapper().writeValueAsString(empregado);

        mockMvc.perform(post("/empregado").content(empregadoJson).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        /*Empregado empregadoExistente = new Empregado();
        empregadoExistente.setUsername("maria");
        empregadoExistente.setCargo("AnalistaJunior");

        String empregadoExistenteJson= new ObjectMapper().writeValueAsString(empregadoExistente);

        mockMvc.perform(post("/empregado").content(empregadoExistenteJson).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest());*/
    }
}