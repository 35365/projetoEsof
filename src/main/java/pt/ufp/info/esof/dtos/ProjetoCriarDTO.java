package pt.ufp.info.esof.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pt.ufp.info.esof.Models.Cliente;
import pt.ufp.info.esof.Models.Projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoCriarDTO implements CriarDTO<Projeto> {
    private String nome;

    @Override
    public Projeto converter() {
        Projeto projeto = new Projeto();
        projeto.setNome(nome);
        return projeto;
    }
}
