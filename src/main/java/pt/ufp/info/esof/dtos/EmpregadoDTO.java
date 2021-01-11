package pt.ufp.info.esof.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class EmpregadoDTO {
    private String username;
}
