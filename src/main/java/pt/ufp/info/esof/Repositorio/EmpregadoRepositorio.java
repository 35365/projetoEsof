package pt.ufp.info.esof.Repositorio;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.Models.Empregado;

@Repository
public interface EmpregadoRepositorio extends CrudRepository<Empregado,Long> {
}
