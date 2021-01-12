package pt.ufp.info.esof.repositorio;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.modelos.Empregado;

import java.util.Optional;

@Repository
public interface EmpregadoRepositorio extends CrudRepository<Empregado,Long> {
    Optional<Empregado> findByUsername(String username);
}
