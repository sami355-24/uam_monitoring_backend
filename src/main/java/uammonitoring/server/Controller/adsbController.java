package uammonitoring.server.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uammonitoring.server.DTO.adsbDTO;
import uammonitoring.server.Entity.adsb;
import uammonitoring.server.Service.adsbService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class adsbController {

    public final String TOPIC = "test-topic";
    public final String GROUP_ID = "group-id";
    public final adsbService service;
    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void receiveKafkaMessage(adsbDTO DTO){
        service.saveAdsb(DTO);
    }

    @GetMapping("/findAllAdsb")
    public List<adsbDTO> findAllAdsb(){
        List<adsbDTO> result = service.findAllAdsb();
        for (adsbDTO adsbDTO : result) {
            log.info("findAllAdsb : {}", adsbDTO.toString());
        }
        return result;
    }

}
