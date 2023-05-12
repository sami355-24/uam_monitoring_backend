package uammonitoring.server.Service;

import uammonitoring.server.DTO.adsbDTO;

import java.io.IOException;
import java.util.List;

public interface adsbService {

    void saveAdsb(adsbDTO DTO);

    List<adsbDTO> findAllAdsb();

    void sendAdsb(adsbDTO DTO) throws IOException;

    void completeFlight(String uamIdentification);

}
