package pl.krysiukm.milionarequiz.model.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import pl.krysiukm.milionarequiz.model.HistoryEntry;
import pl.krysiukm.milionarequiz.model.Prize;
import pl.krysiukm.milionarequiz.model.User;

import java.io.IOException;
import java.util.Date;

public class HistoryEntryDeserializer extends StdDeserializer<HistoryEntry> {
    public HistoryEntryDeserializer() {
        this(null);
    }

    public HistoryEntryDeserializer(Class<Prize> t) {
        super(t);
    }

    @Override
    public HistoryEntry deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        String username = node.get("username").asText();
        int prize = (Integer) node.get("prize").numberValue();


        HistoryEntry entry = new HistoryEntry();
        User user = new User();
        user.setUsername(username);
        entry.setUser(user);
        entry.setDate(new Date());

        entry.setPrize(Prize.fromInteger(prize));
        return entry;
    }


}
