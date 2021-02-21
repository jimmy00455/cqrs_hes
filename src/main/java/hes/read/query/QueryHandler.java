package hes.read.query;

import hes.read.domain.Read;
import hes.read.repository.ReadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class QueryHandler {

    private final ReadRepository repository;

    public List<Read> handleGetAllReadsQuery(GetAllReadsQuery query) {
        return repository.getAllReads();
    }

    public List<Read> handleGetAllReadsForDeviceQuery(GetReadsForDeviceQuery query) {
        return repository.getAllBySerialNumber(query.getDeviceSerialNumber());
    }

    public List<Read> handleGetAllReadsForDeviceAndDateQuery(GetReadsForDeviceAndDateQuery query) {
        return repository.getAllBySerialNumberAndDate(query.getDeviceSerialNumber(), query.getReadDate());
    }

}
