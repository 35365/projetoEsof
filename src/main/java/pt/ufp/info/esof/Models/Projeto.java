package pt.ufp.info.esof.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int percentual;
    private String nome;

    @OneToMany(mappedBy = "projeto")
    private List<Tarefa> tarefas = new ArrayList<Tarefa>();
    @ManyToOne
    private Cliente cliente;

    public void adicionarTarefa(Tarefa tarefa){
        if(!this.tarefas.contains(tarefa)){
            this.tarefas.add(tarefa);
        }
    }

    public int tempoEstimado(){
        int tempo=0;
        for(Tarefa tarefa : this.tarefas){
            tempo+=tarefa.horasEstimadas();
        }
        return tempo;
    }

    public int valorEstimado(){
        int valor=0;
        for(Tarefa tarefa : this.tarefas){
            valor+=tarefa.custo();
        }
        return valor;
    }

    /**
     * Devolve o estado com base em estimativas iniciais e tarefas efetivas
     */
    public void getEstado(){
        System.out.println("Tempo estimado:"+tempoEstimado()+"Percentual do projeto:"+percentual+"\n");
    }
}
