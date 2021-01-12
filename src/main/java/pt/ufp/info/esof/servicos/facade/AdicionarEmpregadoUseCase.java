package pt.ufp.info.esof.servicos.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ufp.info.esof.modelos.Empregado;
import pt.ufp.info.esof.modelos.Tarefa;
import pt.ufp.info.esof.repositorio.TarefaRepositorio;

import java.util.Optional;

@Service
public class AdicionarEmpregadoUseCase {

    private final TarefaRepositorio tarefaRepositorio;

    @Autowired
    public AdicionarEmpregadoUseCase(TarefaRepositorio tarefaRepositorio) {
        this.tarefaRepositorio = tarefaRepositorio;
    }

    public Optional<Tarefa> adicionarEmpregado(Long tarefaId, Empregado empregado) {
        Optional<Tarefa> optionalTarefa=tarefaRepositorio.findById(tarefaId);
        if(optionalTarefa.isPresent()){
            Tarefa tarefa=optionalTarefa.get();
            tarefa.setEmpregado(empregado);
            return Optional.of(tarefa);
        }
        return Optional.empty();
    }
}
