package hes.write.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Read {

    private final String type;
    private final Integer value;

}
