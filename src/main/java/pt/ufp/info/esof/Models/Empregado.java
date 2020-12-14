package pt.ufp.info.esof.Models;

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
public class Empregado extends Utilizador{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Cargo cargo;
    private int horasTarefa;
    @OneToMany(mappedBy = "empregado")
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

}
