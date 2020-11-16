package pl.krysiukm.milionarequiz.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import pl.krysiukm.milionarequiz.model.serialization.PrizeSerializer;

@JsonSerialize(using = PrizeSerializer.class)
public enum Prize {
    P_0(0),
    P_500(1_000),
    P_2_000(2_000),
    P_5_000(5_000),
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


    public static Prize fromInteger(int x) {
        switch (x) {
            case 1_000:
                return P_500;
            case 2_000:
                return P_2_000;
            case 5_000:
                return P_5_000;
            case 10_000:
                return P_10_000;
            case 20_000:
                return P_20_000;
            case 40_000:
                return P_40_000;
            case 75_000:
                return P_75_000;
            case 125_000:
                return P_125_000;
            case 250_000:
                return P_250_000;
            case 500_000:
                return P_500_000;
            case 1_000_000:
                return P_1_000_000;
        }
        return P_0;
    }
}
