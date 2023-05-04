package uammonitoring.server.Service;

import uammonitoring.server.DTO.fixmDTO;
import uammonitoring.server.Entity.fixm;

public interface fixmService {

    void saveFixm(fixmDTO DTO);

    public fixmDTO findFixm(String uamIdentification);
}
