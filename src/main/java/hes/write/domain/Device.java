package hes.write.domain;

import hes.write.command.CreateDeviceCommand;
import hes.write.infrastructure.DeviceValuesReader;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class Device {

    private final String serialNumber;
    private final String producer;
    private final String model;
    private final LocalDateTime createDate;
    private final Sim sim;
    private final List<ReadOrder> readOrders = new ArrayList<>();

    public static Device createOf(CreateDeviceCommand command) {
        return Device.builder()
                .createDate(LocalDateTime.now())
                .model(command.getDeviceModel())
                .producer(command.getDeviceProducer())
                .serialNumber(command.getDeviceSerialNumber())
                .sim(Sim.builder()
                        .ipAddress(command.getSimIpAddress())
                        .serialNumber(command.getSimSerialNumber())
                        .build())
                .build();
    }

    public void addDeviceRead(LocalDate readFor, List<DeviceValuesReader.ReadDto> readValues) {
        ReadOrder order = ReadOrder.createOf(readFor);
        readValues.forEach(read -> order.addRead(read.getType(), read.getValue()));
        readOrders.add(order);
    }

}
