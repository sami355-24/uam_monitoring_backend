package uammonitoring.server.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uammonitoring.server.DTO.vertiportDTO;
import uammonitoring.server.Entity.vertiport;
import uammonitoring.server.Repository.vertiportRepository;
import uammonitoring.server.Service.vertiportService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class vertiportServiceImpl implements vertiportService {

    private final vertiportRepository repository;

    @Override
    public List<vertiportDTO> findAll() {
        List<vertiport> vertiports = repository.findAll();
        List<vertiportDTO> result = new ArrayList<>();
        for (vertiport vertiport : vertiports) {
            vertiportDTO dto = new vertiportDTO();
            dto.setLatitude(vertiport.getLatitude());
            dto.setLongitude(vertiport.getLongitude());
            result.add(dto);
        }
        return result;
    }
}
