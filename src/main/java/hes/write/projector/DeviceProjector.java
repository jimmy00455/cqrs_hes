package hes.write.projector;

import hes.read.domain.Read;
import hes.read.repository.ReadRepository;
import hes.write.domain.Device;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DeviceProjector {

    private final ReadRepository readRepository;

    public void project(Device device) {
        List<Read> projectedReads = new ArrayList<>();

        device.getReadOrders()
                .forEach(order -> {
                    order.getReadValues()
                            .forEach(read -> projectedReads.add(
                                    Read.createOf(
                                            device.getSerialNumber(),
                                            device.getProducer(),
                                            device.getModel(),
                                            order.getReadFor(),
                                            read.getType(),
                                            read.getValue())
                            ));
                });

        readRepository.saveReads(projectedReads);
    }

}
