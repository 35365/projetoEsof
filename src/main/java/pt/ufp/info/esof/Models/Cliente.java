package pt.ufp.info.esof.Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Utilizador{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cliente")
    private List<Projeto> projetos = new ArrayList<Projeto>();

    public void adicionarProjeto(Projeto projeto){
        if(!projetos.contains(projeto)){
            this.projetos.add(projeto);
        }
    }
}
