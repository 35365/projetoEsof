package pt.ufp.info.esof.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pt.ufp.info.esof.Models.Empregado;
import pt.ufp.info.esof.dtos.DTOStaticFactory;
import pt.ufp.info.esof.dtos.EmpregadoCriarDTO;
import pt.ufp.info.esof.dtos.EmpregadoDTO;
import pt.ufp.info.esof.servicos.EmpregadoServico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/empregado")
public class EmpregadoControlador {
    private final EmpregadoServico empregadoServico;
    private final DTOStaticFactory dtoStaticFactory = DTOStaticFactory.getInstance();

    public EmpregadoControlador(EmpregadoServico empregadoServico) {
        this.empregadoServico = empregadoServico;
    }

    @GetMapping()
    public ResponseEntity<Iterable<EmpregadoDTO>> getAllEmpregado(){
        List<EmpregadoDTO> empregadoDTOS = new ArrayList<>();
        empregadoServico.findAll().forEach(empregado -> empregadoDTOS.add(dtoStaticFactory.empregadoDTO(empregado)));
        return ResponseEntity.ok(empregadoDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpregadoDTO> getEmpregadoById(@PathVariable Long id){

        Optional<Empregado> optionalEmpregado=empregadoServico.findById(id);
        return optionalEmpregado.map(empregado -> {
            EmpregadoDTO empregadoDTO= dtoStaticFactory.empregadoDTO(empregado);
            return ResponseEntity.ok(empregadoDTO);
        }).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmpregadoDTO> criarEmpregado(@RequestBody EmpregadoCriarDTO empregado){

        Optional<Empregado> optionalEmpregado=empregadoServico.criarEmpregado(empregado.converter());
        return optionalEmpregado.map(empregado1 -> ResponseEntity.ok(dtoStaticFactory.empregadoDTO(empregado1)))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }
}
