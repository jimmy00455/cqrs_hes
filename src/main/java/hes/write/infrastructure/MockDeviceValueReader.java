package hes.write.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MockDeviceValueReader implements DeviceValuesReader {

    private static final List<String> MOCK_READ_TYPES = Arrays.asList(
            "LOAD_PROFILE_1",
            "LOAD_PROFILE_2",
            "LOAD_PROFILE_3"
    );

    @Override
    public List<ReadDto> readDevice(String deviceSerialNumber, LocalDate readDate) {
        return MOCK_READ_TYPES.stream()
                .map(this::mockValue)
                .collect(Collectors.toList());
    }

    private ReadDto mockValue(String type) {
        Random random = new Random();
        return ReadDto.of(type, random.nextInt(300));
    }

}
