package pt.ufp.info.esof.repositorio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pt.ufp.info.esof.modelos.Empregado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
class EmpregadoRepositorioTest {
    @Autowired
    private EmpregadoRepositorio empregadoRepositorio;

    @Test
    public void testeCriacaoEmpregado(){
        Empregado empregado = new Empregado();

        empregado.setHorasTarefa(10);
        empregado.setNome("empregado");
        empregado.setCargo("DesenvolvedorJunior");
        empregado.setUsername("empregado");


        assertEquals(0,empregadoRepositorio.count());
        empregadoRepositorio.save(empregado);
        assertEquals(1,empregadoRepositorio.count());

        assertTrue(empregadoRepositorio.findByUsername(empregado.getUsername()).isPresent());
    }

}