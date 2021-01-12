package pt.ufp.info.esof.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.modelos.Projeto;

import java.util.Optional;

@Repository
public interface ProjetoRepositorio extends CrudRepository<Projeto,Long> {
    Optional<Projeto> findByNome(String nome);
}
