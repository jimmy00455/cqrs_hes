package hes.write.api;

import hes.write.command.CreateDeviceCommand;
import hes.write.command.PerformDeviceReadCommand;
import hes.write.command.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/write")
@RequiredArgsConstructor
public class WriteController {

    private final CommandHandler commandHandler;

    @PostMapping("/device")
    public ResponseEntity<Object> createDevice(CreateDeviceCommand createDeviceCommand) {
        commandHandler.handleCreateDeviceCommand(createDeviceCommand);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("device/read")
    public ResponseEntity<Object> createReadOrder(PerformDeviceReadCommand performDeviceReadCommand) {
        commandHandler.handleCreateReadOrderCommand(performDeviceReadCommand);
        return ResponseEntity.accepted().build();
    }

}
