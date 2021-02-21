package hes.write.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class ReadOrder {

    private final LocalDateTime orderedOn;
    private final LocalDate readFor;
    private final List<Read> readValues = new ArrayList<>();

    static ReadOrder createOf(LocalDate readFor) {
        return ReadOrder.builder()
                .orderedOn(LocalDateTime.now())
                .readFor(readFor)
                .build();
    }

    void addRead(String type, Integer value) {
        Read build = Read.builder()
                .type(type)
                .value(value)
                .build();
        readValues.add(build);
    }

}
