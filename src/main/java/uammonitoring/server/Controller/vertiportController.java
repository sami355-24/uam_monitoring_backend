package uammonitoring.server.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uammonitoring.server.DTO.vertiportDTO;
import uammonitoring.server.Service.vertiportService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class vertiportController {

    private final vertiportService service;

    @GetMapping("/vertiports")
    public List<vertiportDTO> findAll() {
        return service.findAll();
    }
}
