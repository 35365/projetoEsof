package pt.ufp.info.esof.dtos.conversores;

import org.springframework.stereotype.Component;
import pt.ufp.info.esof.Models.Empregado;
import pt.ufp.info.esof.Models.Tarefa;
import pt.ufp.info.esof.dtos.EmpregadoDTO;
import pt.ufp.info.esof.dtos.TarefaCriarDTO;
import pt.ufp.info.esof.dtos.TarefaDTO;

import java.util.stream.Collectors;

@Component
public class ConverterEmpregadoParaDTO implements Conversor<EmpregadoDTO, Empregado> {
    @Override
    public EmpregadoDTO converter(Empregado empregado) {
        EmpregadoDTO empregadoDTO = new EmpregadoDTO();
        empregadoDTO.setUsername(empregado.getUsername());
        empregadoDTO.setTarefas(empregado.getTarefas().stream().map(tarefa ->{
            TarefaCriarDTO tarefaDTO = new TarefaCriarDTO();
            /*.......*/
            return tarefaDTO;
        }).collect(Collectors.toList()));
        return empregadoDTO;
    }
}
