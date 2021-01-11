package pt.ufp.info.esof.dtos;

import lombok.Data;
import pt.ufp.info.esof.Models.Tarefa;

@Data
public class TarefaCriarDTO implements CriarDTO<Tarefa> {
    private String nome;


    @Override
    public Tarefa converter() {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome(this.nome);
        return tarefa;
    }
}
