package pt.ufp.info.esof.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProjetoDTO {
    private List<TarefaCriarDTO> tarefas = new ArrayList<>();
    private Long clienteId;

}
