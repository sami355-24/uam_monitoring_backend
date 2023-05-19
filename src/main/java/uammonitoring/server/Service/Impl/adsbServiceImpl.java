package uammonitoring.server.Service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import uammonitoring.server.Compnent.adsbHandler;
import uammonitoring.server.DTO.adsbDTO;
import uammonitoring.server.Entity.adsb;
import uammonitoring.server.Repository.adsbRepository;
import uammonitoring.server.Service.adsbService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class adsbServiceImpl implements adsbService {

    private final adsbRepository repository;
    private final ConversionService conversionService;
    public final adsbHandler handler;

    @Override
    public void saveAdsb(adsbDTO DTO) {
        adsb entity = conversionService.convert(DTO, adsb.class);
        log.info("saveAdsb : {}", DTO.toString());
        repository.save(entity);
    }

    @Override
    public List<adsbDTO> findAllAdsb() {
        List<adsb> adsbList = repository.findAll();
        return conversionService.convert(adsbList, List.class);
    }

    @Override
    public void sendAdsb(adsbDTO DTO) throws IOException {
        List<WebSocketSession> list = handler.getList();
        log.info("list.length : {}", list.size());
        for (WebSocketSession session : list) {
            session.sendMessage(new TextMessage(DTO.toString()));
        }
    }

    @Override
    public void completeFlight(String UamIdentification) {
        repository.deleteByuamIdentification(UamIdentification);
    }

    @Override
    public Map<String, Boolean> existsByUamIdentification(String uamIdentification) {
        boolean status = repository.existsByUamIdentification(uamIdentification);
        HashMap<String, Boolean> result = new HashMap<>();
        result.put("status", status);
        return result;
    }

    @Override
    public adsbDTO stringToDTO(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        adsbDTO dto;
        try {
            dto = objectMapper.readValue(json, adsbDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }

    @Override
    public void receiveKafkaMessage(String data) throws IOException {
        adsbDTO DTO = stringToDTO(data);
        log.info("DTO 타입 : {}", DTO.getClass());
        saveAdsb(DTO);
        sendAdsb(DTO);
    }

}
