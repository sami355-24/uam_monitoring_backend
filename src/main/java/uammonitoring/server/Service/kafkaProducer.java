package uammonitoring.server.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import uammonitoring.server.Entity.flightData;

@Service
@RequiredArgsConstructor
public class kafkaProducer {

    private static final String TOPIC = "test-topic";
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(flightData fd) {
        kafkaTemplate.send(TOPIC, fd);
    }
}
