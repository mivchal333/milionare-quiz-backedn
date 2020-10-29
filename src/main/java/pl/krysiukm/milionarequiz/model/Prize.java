package pl.krysiukm.milionarequiz.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import pl.krysiukm.milionarequiz.model.serializer.PrizeSerializer;

@JsonSerialize(using = PrizeSerializer.class)
public enum Prize {
    P_500(500),
    P_2000(2_000),
    P_5000(5_000),
    P_10_000(10_000),
    P_20_000(20_000),
    P_40_000(40_000),
    P_75_000(75_000),
    P_125_000(125_000),
    P_250_000(250_000),
    P_500_000(500_000),
    P_1_000_000(1_000_000);

    @Getter
    private final int value;

    Prize(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
