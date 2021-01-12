package pt.ufp.info.esof.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pt.ufp.info.esof.modelos.Empregado;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpregadoCriarDTO implements CriarDTO<Empregado> {
    private String username;

    @Override
    public Empregado converter() {
        Empregado empregado= new Empregado();
        empregado.setUsername(this.username);
        return empregado;
    }
}
