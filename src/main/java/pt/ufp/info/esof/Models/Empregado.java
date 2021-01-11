package pt.ufp.info.esof.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

enum Cargo{
    DesenvolvedorJunior,
    AnalistaJunior,
    DesenvolvedorSenior,
    AnalistaSenior,
}

@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = true)
public class Empregado extends Utilizador{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Cargo cargo;
    private int horasTarefa;
    @JsonIgnore
    @OneToMany(mappedBy = "empregado",cascade = CascadeType.ALL)
    private List<Tarefa> tarefas = new ArrayList<Tarefa>();

    public int valorHora(){
        if(cargo==Cargo.DesenvolvedorJunior){
            return 10;
        }
        else if(cargo==Cargo.AnalistaJunior){
            return 20;
        }
        else if(cargo==Cargo.DesenvolvedorSenior){
            return 40;
        }
        else if(cargo==Cargo.AnalistaSenior){
            return 80;
        }
        return 0;
    }

    public void setCargo(String s) {
        if(s.compareTo("DesenvolvedorJunior")==0){
            cargo=Cargo.DesenvolvedorJunior;
        }
        else if(s.compareTo("AnalistaJunior")==0){
            cargo=Cargo.AnalistaJunior;
        }
        else if(s.compareTo("DesenvolvedorSenior")==0){
            cargo=Cargo.DesenvolvedorSenior;
        }
        else if(s.compareTo("AnalistaSenior")==0){
            cargo=Cargo.AnalistaSenior;
        }
    }

    public void adicionarTarefa(Tarefa tarefa){
        if(!this.tarefas.contains(tarefa)){
            this.tarefas.add(tarefa);
        }
    }

    @Override
    public String toString() {
        return "Empregado{" +
                "id=" + id +
                ", cargo=" + cargo +
                ", horasTarefa=" + horasTarefa +
                '}';
    }
}
