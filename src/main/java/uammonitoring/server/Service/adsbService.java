package uammonitoring.server.Service;

import uammonitoring.server.DTO.adsbDTO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface adsbService {

    void saveAdsb(adsbDTO DTO);

    List<adsbDTO> findAllAdsb();

    void sendAdsb(adsbDTO DTO) throws IOException;

    void completeFlight(String UamIdentification);

    Map<String, Boolean> existsByUamIdentification(String uamIdentification);

    adsbDTO stringToDTO(String data);

    void receiveKafkaMessage(String data) throws IOException;
}
