package hes.write.command;

import hes.write.domain.Device;
import hes.write.repository.DeviceRepository;
import hes.write.infrastructure.DeviceValuesReader;
import hes.write.projector.DeviceProjector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CommandHandler {

    private final DeviceRepository repository;
    private final DeviceValuesReader deviceValuesReader;
    private final DeviceProjector deviceReadProjector;

    public void handleCreateDeviceCommand(CreateDeviceCommand command) {
        repository.save(Device.createOf(command));
    }

    public void handleCreateReadOrderCommand(PerformDeviceReadCommand performDeviceReadCommand) {
        String deviceSerialNumber = performDeviceReadCommand.getDeviceSerialNumber();
        LocalDate readFor = LocalDate.parse(performDeviceReadCommand.getReadFor());

        Device foundDevice = repository.findBySerialNumber(deviceSerialNumber);

        List<DeviceValuesReader.ReadDto> readValues = deviceValuesReader.readDevice(deviceSerialNumber, readFor);
        foundDevice.addDeviceRead(readFor, readValues);

        Device savedDevice = repository.save(foundDevice);

        deviceReadProjector.project(savedDevice);
    }

}
