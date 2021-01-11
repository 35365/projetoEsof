package pt.ufp.info.esof.servicos.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ufp.info.esof.Models.Tarefa;
import pt.ufp.info.esof.Repositorio.TarefaRepositorio;

import java.util.Optional;

@Service
public class CriarTarefaUseCase {
    private final TarefaRepositorio tarefaRepositorio;

    @Autowired
    public CriarTarefaUseCase(TarefaRepositorio tarefaRepositorio) {
        this.tarefaRepositorio = tarefaRepositorio;
    }

    public Optional<Tarefa> criarTarefa(Tarefa tarefa){
        Optional<Tarefa> optionalTarefa=tarefaRepositorio.findByNome(tarefa.getNome());
        if(optionalTarefa.isEmpty()){
            return Optional.of(tarefaRepositorio.save(tarefa));
        }
        return Optional.empty();
    }
}
