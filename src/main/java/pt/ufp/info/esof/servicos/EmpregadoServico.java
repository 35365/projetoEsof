package pt.ufp.info.esof.servicos;

import pt.ufp.info.esof.modelos.Empregado;

import java.util.List;
import java.util.Optional;

public interface EmpregadoServico {

    List<Empregado> findAll();

    Optional<Empregado> findById(Long id);

    Optional<Empregado> criarEmpregado(Empregado empregado);

}
