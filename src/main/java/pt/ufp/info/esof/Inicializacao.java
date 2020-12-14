package pt.ufp.info.esof;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pt.ufp.info.esof.Repositorio.*;

@Component
public class Inicializacao implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Autowired
    private EmpregadoRepositorio empregadoRepositorio;
    @Autowired
    private ProjetoRepositorio projetoRepositorio;
    @Autowired
    private TarefaRepositorio tarefaRepositorio;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    }
}
