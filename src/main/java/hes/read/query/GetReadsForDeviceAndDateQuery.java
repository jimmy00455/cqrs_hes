package hes.read.query;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class GetReadsForDeviceAndDateQuery {

    public GetReadsForDeviceAndDateQuery(String deviceSerialNumber, String readDate) {
        this.deviceSerialNumber = deviceSerialNumber;
        this.readDate = LocalDate.parse(readDate);
    }

    private final String deviceSerialNumber;
    private final LocalDate readDate;

}
