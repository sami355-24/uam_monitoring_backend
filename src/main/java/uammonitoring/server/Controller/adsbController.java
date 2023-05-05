package uammonitoring.server.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uammonitoring.server.DTO.adsbDTO;
import uammonitoring.server.Service.adsbService;
import java.io.IOException;
import java.util.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class adsbController {

    public final String TOPIC = "test-topic";
    public final String GROUP_ID = "group-id";
    public final adsbService service;
    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void receiveKafkaMessage(adsbDTO DTO) throws IOException {
        service.saveAdsb(DTO);
        service.sendAdsb(DTO);
    }

    @GetMapping("/findAllAdsb")
    public List<adsbDTO> findAdsb() {
        List<adsbDTO> allAdsb = service.findAllAdsb();
        return allAdsb;
    }


}
