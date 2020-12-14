package pt.ufp.info.esof.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpregadoTest {

    @Test
    void valorHora() {
        Empregado empregado=new Empregado();

        empregado.setCargo(Cargo.DesenvolvedorJunior);
        assertEquals(10,empregado.valorHora());

        empregado.setCargo(Cargo.AnalistaJunior);
        assertEquals(20,empregado.valorHora());

        empregado.setCargo(Cargo.DesenvolvedorSenior);
        assertEquals(40,empregado.valorHora());

        empregado.setCargo(Cargo.AnalistaSenior);
        assertEquals(80,empregado.valorHora());

    }
}