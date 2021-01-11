package pt.ufp.info.esof.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@MappedSuperclass
public class Utilizador {

    private String username;
    private String password;
    private String nome;
}
