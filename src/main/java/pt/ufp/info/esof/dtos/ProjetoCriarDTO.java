package pt.ufp.info.esof.dtos;

import lombok.Data;
import pt.ufp.info.esof.Models.Cliente;
import pt.ufp.info.esof.Models.Projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProjetoCriarDTO implements CriarDTO<Projeto> {
    private List<TarefaCriarDTO> tarefas = new ArrayList<>();
    private Long clienteId;

    @Override
    public Projeto converter() {
        Projeto projeto = new Projeto();
        Cliente  cliente=new Cliente();
        cliente.setId(clienteId);
        projeto.setCliente(cliente);

        projeto.setTarefas(tarefas.stream().map(TarefaCriarDTO::converter).collect(Collectors.toList()));
        return projeto;
    }
}
