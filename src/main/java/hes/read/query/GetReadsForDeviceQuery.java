package hes.read.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetReadsForDeviceQuery {
    private final String deviceSerialNumber;
}
