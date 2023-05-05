package uammonitoring.server.Service;

import uammonitoring.server.DTO.adsbDTO;
import java.util.List;

public interface adsbService {

    void saveAdsb(adsbDTO DTO);

    List<adsbDTO> findAllAdsb();

}
