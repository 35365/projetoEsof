package pt.ufp.info.esof.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.modelos.Cliente;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente,Long> {
}
