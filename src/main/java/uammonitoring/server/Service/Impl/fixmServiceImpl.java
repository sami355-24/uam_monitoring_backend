package uammonitoring.server.Service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import uammonitoring.server.DTO.fixmDTO;
import uammonitoring.server.Entity.fixm;
import uammonitoring.server.Repository.fixmRepository;
import uammonitoring.server.Service.fixmService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class fixmServiceImpl implements fixmService {

    private final ConversionService conversionService;
    private final fixmRepository repository;

    public void saveFixm(fixmDTO DTO) {
        log.info("saveFixm : {}", DTO.toString());
        fixm convertDTO = conversionService.convert(DTO, fixm.class);
        List convertRoute = conversionService.convert(DTO, List.class);

        convertDTO.setRoutes(convertRoute);
        repository.save(convertDTO);
    }

    public fixmDTO findFixm(String uamIdentification) {
        fixm data = repository.findByUamIdentification(uamIdentification);
        return conversionService.convert(data, fixmDTO.class);
    }
}
