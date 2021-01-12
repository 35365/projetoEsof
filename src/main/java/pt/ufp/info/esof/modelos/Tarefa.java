package pt.ufp.info.esof.modelos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
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
