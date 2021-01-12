package pt.ufp.info.esof.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pt.ufp.info.esof.Models.Tarefa;
import pt.ufp.info.esof.dtos.DTOStaticFactory;
import pt.ufp.info.esof.dtos.EmpregadoCriarDTO;
import pt.ufp.info.esof.dtos.TarefaCriarDTO;
import pt.ufp.info.esof.dtos.TarefaDTO;
import pt.ufp.info.esof.servicos.TarefaServico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tarefa")
public class TarefaControlador {

    private final TarefaServico tarefaServico;
    private final DTOStaticFactory dtoStaticFactory = DTOStaticFactory.getInstance();

    public TarefaControlador(TarefaServico tarefaServico) {
        this.tarefaServico = tarefaServico;
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaCriarDTO tarefa){
        Optional<Tarefa> optionalTarefa = tarefaServico.criarTarefa(tarefa.converter());
        return optionalTarefa.map(tarefa1 -> ResponseEntity.ok(dtoStaticFactory.tarefaDTO(tarefa1))).orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @PatchMapping("/{tarefaId}")
    public ResponseEntity<TarefaDTO> adicionarEmpregado(@PathVariable Long tarefaId, @RequestBody EmpregadoCriarDTO empregado){
        Optional<Tarefa> optionalTarefa = tarefaServico.adicionarEmpregado(tarefaId,empregado.converter());
        return optionalTarefa.map(tarefa -> ResponseEntity.ok(dtoStaticFactory.tarefaDTO(tarefa)))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @GetMapping()
    public ResponseEntity<Iterable<TarefaDTO>> getAllTarefas(){
        List<TarefaDTO> tarefaDTOS = new ArrayList<>();
        tarefaServico.findAll().forEach(tarefa -> tarefaDTOS.add(dtoStaticFactory.tarefaDTO(tarefa)));
        return ResponseEntity.ok(tarefaDTOS);
    }
}
