package pt.ufp.info.esof.servicos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pt.ufp.info.esof.modelos.Empregado;
import pt.ufp.info.esof.repositorio.EmpregadoRepositorio;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = EmpregadoServicoImpl.class)
class EmpregadoServicoImplTest {

    @Autowired
    private EmpregadoServico empregadoServico;
    @MockBean
    private EmpregadoRepositorio empregadoRepositorio;

    @Test
    void findAll() {
        when(empregadoRepositorio.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(empregadoServico.findAll());
    }

    @Test
    void findById() {
        when(empregadoRepositorio.findById(1L)).thenReturn(Optional.of(new Empregado()));
        assertTrue(empregadoServico.findById(1L).isPresent());
        assertTrue(empregadoServico.findById(5L).isEmpty());
    }

    @Test
    void criarEmpregado() {
        String username ="username";

        Empregado empregado = new Empregado();
        empregado.setUsername(username);

        when(empregadoRepositorio.save(empregado)).thenReturn(empregado);

        assertTrue(empregadoServico.criarEmpregado(empregado).isPresent());

        when(empregadoRepositorio.findByUsername(username)).thenReturn(Optional.of(empregado));
        assertTrue(empregadoServico.criarEmpregado(empregado).isEmpty());

    }
}