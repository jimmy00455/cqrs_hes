package hes.write.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDeviceCommand {

    private String deviceSerialNumber;
    private String deviceProducer;
    private String deviceModel;
    private String simIpAddress;
    private String simSerialNumber;

}
