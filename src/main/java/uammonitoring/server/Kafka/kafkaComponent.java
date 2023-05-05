package uammonitoring.server.Kafka;

import uammonitoring.server.DTO.adsbDTO;

public interface kafkaComponent {

    void sendKafkaMessage(adsbDTO DTO);
}
