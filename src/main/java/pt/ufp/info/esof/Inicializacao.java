package pt.ufp.info.esof;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pt.ufp.info.esof.Models.*;
import pt.ufp.info.esof.Repositorio.*;

@Component
public class Inicializacao implements ApplicationListener<ContextRefreshedEvent> {

    private final ClienteRepositorio clienteRepositorio;
    private final EmpregadoRepositorio empregadoRepositorio;
    private final ProjetoRepositorio projetoRepositorio;

    @Autowired
    public Inicializacao(ClienteRepositorio clienteRepositorio, EmpregadoRepositorio empregadoRepositorio, ProjetoRepositorio projetoRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
        this.empregadoRepositorio = empregadoRepositorio;
        this.projetoRepositorio = projetoRepositorio;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("\n\n\nInicializou\n\n\n");

        Empregado empregado1=new Empregado();
        empregado1.setNome("Patrícia");
        empregado1.setCargo("DesenvolvedorJunior");
        empregado1.setHorasTarefa(2);
        empregado1.setUsername("patricia");

        Tarefa tarefa1= new Tarefa();
        tarefa1.setNome("tarefa1");
        tarefa1.setEfetiva(false);
        tarefa1.setEmpregado(empregado1);
        empregado1.adicionarTarefa(tarefa1);

        Empregado empregado2=new Empregado();
        empregado2.setNome("Maria");
        empregado2.setCargo("AnalistaJunior");
        empregado2.setHorasTarefa(5);
        empregado2.setUsername("maria");

        Tarefa tarefa2= new Tarefa();
        tarefa2.setNome("tarefa2");
        tarefa2.setEfetiva(false);
        tarefa2.setEmpregado(empregado2);
        empregado2.adicionarTarefa(tarefa2);
        this.empregadoRepositorio.save(empregado2);

        Empregado empregado3=new Empregado();
        empregado3.setNome("Pedro");
        empregado3.setCargo("DesenvolvedorSenior");
        empregado3.setHorasTarefa(3);
        empregado3.setUsername("pedro");

        Tarefa tarefa3= new Tarefa();
        tarefa3.setNome("tarefa3");
        tarefa3.setEfetiva(false);
        tarefa3.setEmpregado(empregado3);
        empregado3.adicionarTarefa(tarefa3);
        this.empregadoRepositorio.save(empregado3);

        Projeto projeto1= new Projeto();
        projeto1.setNome("projeto1");
        projeto1.adicionarTarefa(tarefa1);
        tarefa1.setProjeto(projeto1);
        projeto1.adicionarTarefa(tarefa2);
        tarefa2.setProjeto(projeto1);
        projeto1.adicionarTarefa(tarefa3);
        tarefa3.setProjeto(projeto1);

        Cliente cliente = new Cliente();
        cliente.setNome("Empresa");
        cliente.adicionarProjeto(projeto1);
        projeto1.setCliente(cliente);
        this.clienteRepositorio.save(cliente);

        this.projetoRepositorio.save(projeto1);

        this.empregadoRepositorio.save(empregado1);
        this.empregadoRepositorio.save(empregado2);
        this.empregadoRepositorio.save(empregado3);
    }
}
