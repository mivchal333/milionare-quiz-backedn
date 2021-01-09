package pl.krysiukm.milionarequiz.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class HistoryEntry implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private User user;
    private Date date;
    @NonNull
    private Prize prize;
}
