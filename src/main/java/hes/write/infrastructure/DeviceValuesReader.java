package hes.write.infrastructure;

import lombok.Value;

import java.time.LocalDate;
import java.util.List;

public interface DeviceValuesReader {

    List<ReadDto> readDevice(String deviceSerialNumber, LocalDate readDate);

    @Value(staticConstructor = "of")
    class ReadDto {
        String type;
        Integer value;
    }

}
