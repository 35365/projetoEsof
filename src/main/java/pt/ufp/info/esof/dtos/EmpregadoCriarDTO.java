package pt.ufp.info.esof.dtos;

import lombok.Data;
import pt.ufp.info.esof.Models.Empregado;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class EmpregadoCriarDTO implements CriarDTO<Empregado> {
    private String username;
    private List<TarefaCriarDTO> tarefas= new ArrayList<>();

    @Override
    public Empregado converter() {
        Empregado empregado= new Empregado();
        empregado.setUsername(this.username);
        empregado.setTarefas(tarefas.stream().map(TarefaCriarDTO::converter)
        .collect(Collectors.toList()));
        return null;
    }
}
