package pl.krysiukm.milionarequiz.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.krysiukm.milionarequiz.model.Prize;

import java.io.IOException;

public class PrizeSerializer extends StdSerializer<Prize> {
    public PrizeSerializer() {
        this(null);
    }

    public PrizeSerializer(Class<Prize> t) {
        super(t);
    }

    @Override
    public void serialize(Prize prize, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(prize.getValue());
    }
}
