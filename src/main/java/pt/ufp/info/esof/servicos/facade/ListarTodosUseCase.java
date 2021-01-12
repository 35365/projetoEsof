package pt.ufp.info.esof.servicos.facade;

import org.springframework.stereotype.Service;
import pt.ufp.info.esof.modelos.Tarefa;
import pt.ufp.info.esof.repositorio.TarefaRepositorio;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListarTodosUseCase {

    private final TarefaRepositorio tarefaRepositorio;

    public ListarTodosUseCase(TarefaRepositorio tarefaRepositorio) {
        this.tarefaRepositorio = tarefaRepositorio;
    }

    public List<Tarefa> findAll() {
        List<Tarefa> tarefas=new ArrayList<>();
        tarefaRepositorio.findAll().forEach(tarefas::add);
        return tarefas;
    }
}
