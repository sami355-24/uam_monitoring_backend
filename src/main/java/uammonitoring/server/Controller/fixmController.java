package uammonitoring.server.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import uammonitoring.server.DTO.fixmDTO;
import uammonitoring.server.Service.fixmService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class fixmController {

    private final fixmService service;

    @PostMapping("/saveFixm")
    public void saveFixm(@RequestBody fixmDTO DTO) {
        service.saveFixm(DTO);
        log.info("saveFixm : {}", DTO.toString());
    }

    @GetMapping("/findFixm")
    public fixmDTO findFixm(@RequestParam String UAMIdentification) {
        return service.findFixm(UAMIdentification);
    }
}
