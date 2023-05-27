package uammonitoring.server.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uammonitoring.server.Service.uamService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class uamController {

    private final uamService service;

    @GetMapping("/uamList")
    public List<String> getUamList(){
        return service.getUamList();
    }
}
