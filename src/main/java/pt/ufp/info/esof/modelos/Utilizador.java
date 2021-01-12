package pt.ufp.info.esof.modelos;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class Utilizador {

    private String username;
    private String password;
    private String nome;
}
