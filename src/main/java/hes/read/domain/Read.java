package hes.read.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder(access = AccessLevel.PRIVATE)
@Getter
public class Read {

    private final String deviceSerialNumber;
    private final String deviceProducer;
    private final String deviceModel;
    private final LocalDate readDate;
    private final String readType;
    private final Integer readValue;

    public static Read createOf(String deviceSerialNumber, String deviceProducer, String deviceModel, LocalDate readDate, String readType, Integer readValue) {
        return Read.builder()
                .deviceModel(deviceModel)
                .deviceProducer(deviceProducer)
                .readType(readType)
                .readValue(readValue)
                .readDate(readDate)
                .deviceSerialNumber(deviceSerialNumber)
                .build();
    }

}
