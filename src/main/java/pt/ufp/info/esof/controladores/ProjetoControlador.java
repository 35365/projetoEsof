package pt.ufp.info.esof.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pt.ufp.info.esof.modelos.Projeto;
import pt.ufp.info.esof.dtos.DTOStaticFactory;
import pt.ufp.info.esof.dtos.ProjetoDTO;
import pt.ufp.info.esof.dtos.ProjetoCriarDTO;
import pt.ufp.info.esof.dtos.TarefaCriarDTO;
import pt.ufp.info.esof.dtos.ProjetoValorDTO;
import pt.ufp.info.esof.dtos.ProjetoTempoDTO;
import pt.ufp.info.esof.servicos.ProjetoServico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/projeto")
public class ProjetoControlador {

    private final ProjetoServico projetoServico;
    private final DTOStaticFactory dtoStaticFactory = DTOStaticFactory.getInstance();

    public ProjetoControlador(ProjetoServico projetoServico) {
        this.projetoServico = projetoServico;
    }

    @PostMapping
    public ResponseEntity<ProjetoDTO> criarProjeto(@RequestBody ProjetoCriarDTO projeto){

        Optional<Projeto> optionalProjeto= projetoServico.criarProjeto(projeto.converter());
        return optionalProjeto.map(projeto1 -> ResponseEntity.ok(dtoStaticFactory.projetoDTO(projeto1)))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @PatchMapping("/{projetoId}")
    public ResponseEntity<ProjetoDTO> adicionarTarefa(@PathVariable Long projetoId, @RequestBody TarefaCriarDTO tarefa){
        Optional<Projeto> optionalProjeto=projetoServico.adicionarTarefa(projetoId,tarefa.converter());
        return optionalProjeto.map(projeto -> ResponseEntity.ok(dtoStaticFactory.projetoDTO(projeto)))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDTO> getProjetoById(@PathVariable Long id){
        Optional<Projeto> optionalProjeto=projetoServico.findById(id);
        return optionalProjeto.map(projeto -> {
            ProjetoDTO projetoDTO=dtoStaticFactory.projetoDTO(projeto);
            return ResponseEntity.ok(projetoDTO);
        }).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/valor")
    public ResponseEntity<ProjetoValorDTO> getValorProjetoById(@PathVariable Long id){
        Optional<Projeto> optionalProjeto=projetoServico.findById(id);
        return optionalProjeto.map(projeto -> {
            ProjetoValorDTO projetoValorDTO=dtoStaticFactory.projetoValorDTO(projeto);
            return ResponseEntity.ok(projetoValorDTO);
        }).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/tempo")
    public ResponseEntity<ProjetoTempoDTO> getTempoProjetoById(@PathVariable Long id){
        Optional<Projeto> optionalProjeto=projetoServico.findById(id);
        return optionalProjeto.map(projeto -> {
            ProjetoTempoDTO projetoTempoDTO=dtoStaticFactory.projetoTempoDTO(projeto);
            return ResponseEntity.ok(projetoTempoDTO);
        }).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<Iterable<ProjetoDTO>> getAllProjeto(){
        List<ProjetoDTO> projetoDTOS = new ArrayList<>();
        projetoServico.findAll().forEach(projeto -> projetoDTOS.add(dtoStaticFactory.projetoDTO(projeto)));
        return ResponseEntity.ok(projetoDTOS);
    }

}
