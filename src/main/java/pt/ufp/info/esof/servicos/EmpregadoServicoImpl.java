package pt.ufp.info.esof.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pt.ufp.info.esof.Models.Empregado;
import pt.ufp.info.esof.Repositorio.EmpregadoRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoServicoImpl implements EmpregadoServico{
    private final EmpregadoRepositorio empregadoRepositorio;

    @Autowired
    public EmpregadoServicoImpl(EmpregadoRepositorio empregadoRepositorio) {
        this.empregadoRepositorio = empregadoRepositorio;
    }

    @Override
    public List<Empregado> findAll() {
        List<Empregado> empregados=new ArrayList<>();
        empregadoRepositorio.findAll().forEach(empregados::add);
        return empregados;
    }

    @Override
    public Optional<Empregado> findById(Long id) {
        return empregadoRepositorio.findById(id);
    }

    @Override
    public Optional<Empregado> criarEmpregado(Empregado empregado) {
        Optional<Empregado> optionalEmpregado=empregadoRepositorio.findByUsername(empregado.getUsername());
        if(optionalEmpregado.isEmpty()){
            return Optional.of(empregadoRepositorio.save(empregado));
        }
        return Optional.empty();
    }
}
