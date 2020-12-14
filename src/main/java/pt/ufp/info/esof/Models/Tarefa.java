package pt.ufp.info.esof.Models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Projeto projeto;
    @ManyToOne
    private Empregado empregado;
    private boolean efetiva;

    public int horasEstimadas(){
        return empregado.getHorasTarefa();
    }

    public int custo(){
        if(empregado.getCargo().compareTo(Cargo.DesenvolvedorJunior)==0){
            return (10*empregado.getHorasTarefa());
        }
        else if(empregado.getCargo().compareTo(Cargo.AnalistaJunior)==0){
            return (20*empregado.getHorasTarefa());
        }
        else if(empregado.getCargo().compareTo(Cargo.DesenvolvedorSenior)==0){
            return (40*empregado.getHorasTarefa());
        }
        else if(empregado.getCargo().compareTo(Cargo.AnalistaSenior)==0){
            return (80*empregado.getHorasTarefa());
        }
        return 0;
    }
}
