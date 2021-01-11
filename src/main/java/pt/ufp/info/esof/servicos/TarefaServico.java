package pt.ufp.info.esof.servicos;

import pt.ufp.info.esof.Models.Tarefa;

import java.util.Optional;

public interface TarefaServico {
    Optional<Tarefa> criarTarefa(Tarefa tarefa);
}
