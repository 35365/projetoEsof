package pt.ufp.info.esof.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.modelos.Tarefa;

import java.util.Optional;

@Repository
public interface TarefaRepositorio extends CrudRepository<Tarefa,Long> {
    Optional<Tarefa> findByNome(String nome);
}
