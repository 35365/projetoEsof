package pt.ufp.info.esof.servicos;

import org.springframework.stereotype.Service;
import pt.ufp.info.esof.Models.Projeto;
import pt.ufp.info.esof.Repositorio.ProjetoRepositorio;

import java.util.Optional;

@Service
public class ProjetoServicoImpl  implements ProjetoServico{
    private final ProjetoRepositorio projetoRepositorio;

    public ProjetoServicoImpl(ProjetoRepositorio projetoRepositorio) {
        this.projetoRepositorio = projetoRepositorio;
    }

    @Override
    public Optional<Projeto> createProjeto(Projeto projeto) {
        return Optional.empty();
    }
}
