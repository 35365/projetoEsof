package pt.ufp.info.esof.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class Utilizador {

    private String username;
    private String password;
    private String nome;
}
