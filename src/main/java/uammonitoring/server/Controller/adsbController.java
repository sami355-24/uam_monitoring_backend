package uammonitoring.server.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;
import uammonitoring.server.DTO.UamIdentification;
import uammonitoring.server.DTO.adsbDTO;
import uammonitoring.server.Service.adsbService;

import java.io.IOException;
import java.util.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class adsbController {

    public final String TOPIC = "uam-topic";
    public final String GROUP_ID = "group-id";
    public final adsbService service;

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void receiveKafkaMessage(@Payload(required = false) ConsumerRecord<String, String> record) throws IOException {
        service.receiveKafkaMessage(record.value());
        log.info("DB 저장 완료, 소켓 송신 완료 || receiveKafkaMessage : {}", record.value());
    }

    @GetMapping("/findAllAdsb")
    public List<adsbDTO> findAdsb() {
        List<adsbDTO> allAdsb = service.findAllAdsb();
        return allAdsb;
    }

    @PostMapping("/completeFlight")
    public void completeFlight(@RequestBody UamIdentification data) {
        log.info("completeFlight : {}", data.toString());
        log.info("completeFlight : {}", data.getUamIdentification());
        service.completeFlight(data.getUamIdentification());
    }

    @GetMapping("/status")
    public Map<String, Boolean> adsbStatus(@RequestParam String uamIdentification) {
        return service.existsByUamIdentification(uamIdentification);
    }
}
