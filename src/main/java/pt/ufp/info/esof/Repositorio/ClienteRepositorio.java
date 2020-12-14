package pt.ufp.info.esof.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.Models.Cliente;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente,Long> {
}
