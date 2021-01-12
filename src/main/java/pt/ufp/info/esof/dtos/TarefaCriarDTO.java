package pt.ufp.info.esof.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pt.ufp.info.esof.Models.Tarefa;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TarefaCriarDTO implements CriarDTO<Tarefa> {
    private String nome;


    @Override
    public Tarefa converter() {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome(this.nome);
        return tarefa;
    }
}
