package pt.ufp.info.esof.servicos;

import pt.ufp.info.esof.Models.Empregado;
import pt.ufp.info.esof.Models.Tarefa;

import java.util.List;
import java.util.Optional;

public interface TarefaServico {
    Optional<Tarefa> criarTarefa(Tarefa tarefa);
    Optional<Tarefa> adicionarEmpregado(Long tarefaId, Empregado empregado);
    List<Tarefa> findAll();
}
