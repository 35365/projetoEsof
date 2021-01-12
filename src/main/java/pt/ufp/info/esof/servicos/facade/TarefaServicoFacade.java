package pt.ufp.info.esof.servicos.facade;

import org.springframework.stereotype.Service;
import pt.ufp.info.esof.modelos.Empregado;
import pt.ufp.info.esof.modelos.Tarefa;
import pt.ufp.info.esof.servicos.TarefaServico;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaServicoFacade implements TarefaServico {

    private final CriarTarefaUseCase criarTarefaUseCase;
    private final AdicionarEmpregadoUseCase adicionarEmpregadoUseCase;
    private final ListarTodosUseCase listarTodosUseCase;

    public TarefaServicoFacade(CriarTarefaUseCase criarTarefaUseCase, AdicionarEmpregadoUseCase adicionarEmpregadoUseCase, ListarTodosUseCase listarTodosUseCase) {
        this.criarTarefaUseCase = criarTarefaUseCase;
        this.adicionarEmpregadoUseCase = adicionarEmpregadoUseCase;
        this.listarTodosUseCase = listarTodosUseCase;
    }

    @Override
    public Optional<Tarefa> criarTarefa(Tarefa tarefa){ return criarTarefaUseCase.criarTarefa(tarefa); }

    @Override
    public Optional<Tarefa> adicionarEmpregado(Long tarefaId, Empregado empregado) {
        return adicionarEmpregadoUseCase.adicionarEmpregado(tarefaId,empregado);
    }

    @Override
    public List<Tarefa> findAll() {
        return listarTodosUseCase.findAll();
    }
}
