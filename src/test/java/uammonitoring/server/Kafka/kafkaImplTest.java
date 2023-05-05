package uammonitoring.server.Kafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uammonitoring.server.DTO.Common.FlightIdentifier;
import uammonitoring.server.DTO.PartOfAdsbDTO.currentPosition;
import uammonitoring.server.DTO.PartOfAdsbDTO.currentTime;
import uammonitoring.server.DTO.adsbDTO;

@SpringBootTest
class kafkaImplTest {

    @Autowired
    kafkaComponent kafka;

    @Test
    public void sendKafkaMessageTest() throws Exception{
        //given
        FlightIdentifier flightIdentifier = new FlightIdentifier("UAL123");
        currentTime time = new currentTime("2023-05-15", "14:12:35", "UTC");
        currentPosition position = new currentPosition("400", "126.9525465", "37.5453577");

        adsbDTO DTO = adsbDTO.builder()
                .flightIdentifier(flightIdentifier)
                .currentTime(time)
                .currentPosition(position)
                .build();

        //when
        kafka.sendKafkaMessage(DTO);

        //then
    }

}