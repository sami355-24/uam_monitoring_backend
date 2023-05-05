package uammonitoring.server.Converter;

import org.springframework.core.convert.converter.Converter;
import uammonitoring.server.DTO.adsbDTO;
import uammonitoring.server.Entity.adsb;

public class adsbDTOToAdsb implements Converter<adsbDTO, adsb>{
    @Override
    public adsb convert(adsbDTO source) {
        return adsb.builder()
                .id(null)
                .uamIdentification(source.getFlightIdentifier().getUamIdentification())
                .uamCurrentDate(source.getCurrentTime().getDate())
                .uamCurrentTime(source.getCurrentTime().getTime())
                .uamCurrentTimeReference(source.getCurrentTime().getTimeReference())
                .uamCurrentAltitude(source.getCurrentPosition().getAltitude())
                .uamCurrentLongitude(source.getCurrentPosition().getLongitude())
                .uamCurrentLatitude(source.getCurrentPosition().getLatitude())
                .build();
    }
}
