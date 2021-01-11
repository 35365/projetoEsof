package pt.ufp.info.esof.dtos;

import lombok.Data;
import pt.ufp.info.esof.Models.Tarefa;

@Data
public class TarefaCriarDTO implements CriarDTO<Tarefa> {
    private ProjetoCriarDTO projeto;
    private EmpregadoCriarDTO empregado;


    @Override
    public Tarefa converter() {
        Tarefa tarefa = new Tarefa();
        tarefa.setEmpregado(empregado.converter());
        tarefa.setProjeto(projeto.converter());
        return tarefa;
    }
}
