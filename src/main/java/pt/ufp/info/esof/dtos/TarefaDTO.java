package pt.ufp.info.esof.dtos;

import lombok.Data;

@Data
public class TarefaDTO {
    private ProjetoDTO projeto;
    private EmpregadoDTO empregado;
}
