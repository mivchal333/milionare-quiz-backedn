package pl.krysiukm.milionarequiz.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class User implements Serializable {
    @Id
    private String username;
    private String password;
    private String nick;
}

