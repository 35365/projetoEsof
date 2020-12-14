package pt.ufp.info.esof.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.Models.Tarefa;

@Repository
public interface TarefaRepositorio extends CrudRepository<Tarefa,Long> {
}
