package pt.ufp.info.esof.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.Models.Projeto;

@Repository
public interface ProjetoRepositorio extends CrudRepository<Projeto,Long> {
}
