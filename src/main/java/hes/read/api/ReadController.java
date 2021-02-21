package hes.read.api;

import hes.read.domain.Read;
import hes.read.query.GetAllReadsQuery;
import hes.read.query.GetReadsForDeviceAndDateQuery;
import hes.read.query.GetReadsForDeviceQuery;
import hes.read.query.QueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/read")
@AllArgsConstructor
public class ReadController {

    private final QueryHandler queryHandler;

    @GetMapping("device")
    public ResponseEntity<List<Read>> getAllReads() {
        return ResponseEntity.ok(queryHandler.handleGetAllReadsQuery(new GetAllReadsQuery()));
    }

    @GetMapping("device/sn")
    public ResponseEntity<List<Read>> getAllReadsForDevice(@RequestParam String deviceSerialNumber) {
        return ResponseEntity.ok(queryHandler.handleGetAllReadsForDeviceQuery(new GetReadsForDeviceQuery(deviceSerialNumber)));
    }

    @GetMapping("device/sndate")
    public ResponseEntity<List<Read>> getAllReadsForDeviceAndDate(@RequestParam String deviceSerialNumber, @RequestParam String readDate) {
        return ResponseEntity.ok(queryHandler.handleGetAllReadsForDeviceAndDateQuery(new GetReadsForDeviceAndDateQuery(deviceSerialNumber, readDate)));
    }

}
