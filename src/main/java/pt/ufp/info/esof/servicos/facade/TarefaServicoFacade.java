package pt.ufp.info.esof.servicos.facade;

import org.springframework.stereotype.Service;
import pt.ufp.info.esof.Models.Empregado;
import pt.ufp.info.esof.Models.Tarefa;
import pt.ufp.info.esof.servicos.TarefaServico;

import java.util.Optional;

@Service
public class TarefaServicoFacade implements TarefaServico {

    private final CriarTarefaUseCase criarTarefaUseCase;
    private final AdicionarEmpregadoUseCase adicionarEmpregadoUseCase;

    public TarefaServicoFacade(CriarTarefaUseCase criarTarefaUseCase, AdicionarEmpregadoUseCase adicionarEmpregadoUseCase) {
        this.criarTarefaUseCase = criarTarefaUseCase;
        this.adicionarEmpregadoUseCase = adicionarEmpregadoUseCase;
    }

    @Override
    public Optional<Tarefa> criarTarefa(Tarefa tarefa){ return criarTarefaUseCase.criarTarefa(tarefa); }

    @Override
    public Optional<Tarefa> adicionarEmpregado(Long tarefaId, Empregado empregado) {
        return adicionarEmpregadoUseCase.adicionarEmpregado(tarefaId,empregado);
    }
}
