package uammonitoring.server.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uammonitoring.server.domain.Adsb.currentPosition;
import uammonitoring.server.domain.Adsb.currentTime;
import uammonitoring.server.Entity.flightData;
import uammonitoring.server.domain.Adsb.flightIdentifier;

@SpringBootTest
class kafkaProducerTest {

    @Autowired
    kafkaProducer kp;

    @Test
    public void sendTest() throws Exception{
        //given
        flightIdentifier fi = new flightIdentifier("UAL123");
        currentPosition cp = new currentPosition("400", "126.9525465", "37.5453577");
        currentTime ct = new currentTime("111", "222", "333");
        flightData dummyData = new flightData(fi, ct, cp);

        //when
        kp.sendMessage(dummyData);

        //then
    }
}