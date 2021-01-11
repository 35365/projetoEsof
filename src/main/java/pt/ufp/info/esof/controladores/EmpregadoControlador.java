package pt.ufp.info.esof.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pt.ufp.info.esof.Models.Empregado;
import pt.ufp.info.esof.dtos.EmpregadoCriarDTO;
import pt.ufp.info.esof.dtos.EmpregadoDTO;
import pt.ufp.info.esof.dtos.conversores.ConverterEmpregadoParaDTO;
import pt.ufp.info.esof.servicos.EmpregadoServico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/empregado")
public class EmpregadoControlador {
    private final EmpregadoServico empregadoServico;
    private final ConverterEmpregadoParaDTO converterEmpregadoParaDTO = new ConverterEmpregadoParaDTO();

    public EmpregadoControlador(EmpregadoServico empregadoServico) {
        this.empregadoServico = empregadoServico;
    }

    @GetMapping()
    public ResponseEntity<Iterable<EmpregadoDTO>> getAllEmpregado(){
        List<EmpregadoDTO> empregadoDTOS = new ArrayList<>();
        empregadoServico.findAll().forEach(empregado -> empregadoDTOS.add(converterEmpregadoParaDTO.converter(empregado)));
        return ResponseEntity.ok(empregadoDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpregadoDTO> getEmpregadoById(@PathVariable Long id){

        Optional<Empregado> optionalEmpregado=empregadoServico.findById(id);
        return optionalEmpregado.map(empregado -> {
            EmpregadoDTO empregadoDTO= converterEmpregadoParaDTO.converter(empregado);
            return ResponseEntity.ok(empregadoDTO);
        }).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmpregadoDTO> criarEmpregado(@RequestBody EmpregadoCriarDTO empregado){

        Optional<Empregado> optionalEmpregado=empregadoServico.criarEmpregado(empregado.converter());
        return optionalEmpregado.map(empregado1 -> ResponseEntity.ok(converterEmpregadoParaDTO.converter(empregado1))).orElseGet(()-> ResponseEntity.badRequest().build());
    }
}
