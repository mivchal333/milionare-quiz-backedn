package pl.krysiukm.milionarequiz.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class HistoryEntry implements Serializable {
    @Id
    private long id;
    @ManyToOne
    private User user;
    private Date date;
    private Prize prize;
}
