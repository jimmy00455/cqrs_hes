package hes.write.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
class Sim {

    private final String ipAddress;
    private final String serialNumber;
}
