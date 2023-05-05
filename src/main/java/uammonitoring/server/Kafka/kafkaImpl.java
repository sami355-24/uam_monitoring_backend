package uammonitoring.server.Kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import uammonitoring.server.DTO.adsbDTO;

@Component
@RequiredArgsConstructor
public class kafkaImpl implements kafkaComponent {

    private final String TOPIC = "test-topic";
    private final KafkaTemplate<String, Object> kafkaTemplate;
    @Override
    public void sendKafkaMessage(adsbDTO DTO) {
        kafkaTemplate.send(TOPIC, DTO);
    }
}
