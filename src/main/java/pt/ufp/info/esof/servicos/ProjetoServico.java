package pt.ufp.info.esof.servicos;

import pt.ufp.info.esof.modelos.Projeto;
import pt.ufp.info.esof.modelos.Tarefa;

import java.util.List;
import java.util.Optional;

public interface ProjetoServico {

    Optional<Projeto> criarProjeto(Projeto projeto);
    Optional<Projeto> adicionarTarefa(Long projetoId, Tarefa tarefa);
    Optional<Projeto> findById(long id);
    List<Projeto> findAll();
}
