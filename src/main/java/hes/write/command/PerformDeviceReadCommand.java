package hes.write.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerformDeviceReadCommand {

    private String deviceSerialNumber;
    private String readFor;

}
