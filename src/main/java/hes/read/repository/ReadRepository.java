package hes.read.repository;

import hes.read.domain.Read;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ReadRepository {

    @Value
    @EqualsAndHashCode
    private static class SnDateKey {
        String serialNumber;
        LocalDate readDate;
    }

    private final Map<String, List<Read>> readsBySn = new HashMap<>();
    private final Map<SnDateKey, List<Read>> readsBySnAndDate = new HashMap<>();

    public List<Read> getAllReads() {
        List<Read> result = new ArrayList<>();
        readsBySn.forEach((key, reads) -> result.addAll(reads));
        return result;
    }

    public List<Read> getAllBySerialNumber(String serialNumber) {
        return readsBySn.get(serialNumber);
    }

    public List<Read> getAllBySerialNumberAndDate(String serialNumber, LocalDate readDate) {
        return readsBySnAndDate.get(new SnDateKey(serialNumber, readDate));
    }

    public void saveReads(List<Read> projectedReads) {
        Map<String, List<Read>> bySn = projectedReads.stream()
                .collect(Collectors.groupingBy(Read::getDeviceSerialNumber));

        bySn.forEach((key, read) -> readsBySn.computeIfAbsent(key, values -> new ArrayList<>()).addAll(read));

        Map<SnDateKey, List<Read>> byKey = projectedReads.stream()
                .collect(Collectors.groupingBy(read -> new SnDateKey(read.getDeviceSerialNumber(), read.getReadDate())));

        byKey.forEach((key, read) -> readsBySnAndDate.computeIfAbsent(key, values -> new ArrayList<>()).addAll(read));
    }

}
