package pt.ufp.info.esof.servicos.facade;

import org.springframework.stereotype.Service;
import pt.ufp.info.esof.Models.Tarefa;
import pt.ufp.info.esof.Repositorio.TarefaRepositorio;
import pt.ufp.info.esof.servicos.TarefaServico;

import java.util.Optional;

@Service
public class TarefaServicoFacade implements TarefaServico {

    private final CriarTarefaUseCase criarTarefaUseCase;

    public TarefaServicoFacade(CriarTarefaUseCase criarTarefaUseCase) {
        this.criarTarefaUseCase = criarTarefaUseCase;
    }
    @Override
    public Optional<Tarefa> criarTarefa(Tarefa tarefa){ return criarTarefaUseCase.criarTarefa(tarefa); }
}
