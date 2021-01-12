package pt.ufp.info.esof.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ufp.info.esof.Models.Projeto;
import pt.ufp.info.esof.Models.Tarefa;
import pt.ufp.info.esof.Repositorio.ProjetoRepositorio;

import java.util.Optional;

@Service
public class ProjetoServicoImpl  implements ProjetoServico{
    private final ProjetoRepositorio projetoRepositorio;

    @Autowired
    public ProjetoServicoImpl(ProjetoRepositorio projetoRepositorio) {
        this.projetoRepositorio = projetoRepositorio;
    }

    @Override
    public Optional<Projeto> criarProjeto(Projeto projeto) {
        Optional<Projeto> optionalProjeto =projetoRepositorio.findByNome(projeto.getNome());
        if(optionalProjeto.isEmpty()){
            return Optional.of(projetoRepositorio.save(projeto));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Projeto> adicionarTarefa(Long projetoId, Tarefa tarefa) {
        Optional<Projeto> optionalProjeto= projetoRepositorio.findById(projetoId);
        if(optionalProjeto.isPresent()){
            Projeto projeto=optionalProjeto.get();
            int sizeTarefasAntes= projeto.getTarefas().size();

            projeto.adicionarTarefa(tarefa);

            int sizeTarefasDepois= projeto.getTarefas().size();

            if(sizeTarefasAntes != sizeTarefasDepois){
                return Optional.of(projeto);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Projeto> findById(long id) {
        return projetoRepositorio.findById(id);
    }
}
