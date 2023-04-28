package uammonitoring.server.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import uammonitoring.server.domain.Adsb.flightData;

@Service
@Slf4j
public class kafkaConsumer {

    @KafkaListener(topics = "test-topic", groupId = "group_id")
    public void consume(@Payload flightData data) {
        log.info("Consumed message: " + data.toString());
    }

}
