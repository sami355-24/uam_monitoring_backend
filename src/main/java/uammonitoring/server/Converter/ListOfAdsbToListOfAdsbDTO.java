package uammonitoring.server.Converter;

import com.sun.source.tree.BinaryTree;
import org.springframework.core.convert.converter.Converter;
import uammonitoring.server.DTO.Common.FlightIdentifier;
import uammonitoring.server.DTO.PartOfAdsbDTO.currentPosition;
import uammonitoring.server.DTO.PartOfAdsbDTO.currentTime;
import uammonitoring.server.DTO.adsbDTO;
import uammonitoring.server.Entity.adsb;

import java.util.ArrayList;
import java.util.List;

public class ListOfAdsbToListOfAdsbDTO implements Converter<List<adsb>, List<adsbDTO>> {
    @Override
    public List<adsbDTO> convert(List<adsb> source) {
        List<adsbDTO> DTOs = new ArrayList<>();

        for (adsb x : source) {
            DTOs.add(
                adsbDTO.builder()
                        .flightIdentifier(new FlightIdentifier(x.getUamIdentification()))
                        .currentTime(new currentTime(x.getUamCurrentDate(), x.getUamCurrentTime(), x.getUamCurrentTimeReference()))
                        .currentPosition(new currentPosition(x.getUamCurrentLongitude(), x.getUamCurrentLatitude(), x.getUamCurrentAltitude()))
                        .build()
            );
        }

        return DTOs;
    }
}
