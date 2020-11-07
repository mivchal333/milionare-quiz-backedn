package pl.krysiukm.milionarequiz.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import pl.krysiukm.milionarequiz.model.serialization.HistoryEntryDeserializer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@JsonDeserialize(using = HistoryEntryDeserializer.class)
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
