package hes.write.repository;

import hes.write.domain.Device;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DeviceRepository {

    private final Map<String, Device> artificialStorage = new HashMap<>();

    public Device save(Device device) {
        artificialStorage.put(device.getSerialNumber(), device);
        return artificialStorage.get(device.getSerialNumber());
    }

    public Device findBySerialNumber(String serialNumber) {
        return artificialStorage.get(serialNumber);
    }

}
