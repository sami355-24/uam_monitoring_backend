package uammonitoring.server.Converter;


import org.springframework.core.convert.converter.Converter;
import uammonitoring.server.DTO.fixmDTO;
import uammonitoring.server.Entity.fixm;

public class fixmDTOToFixmConverter implements Converter<fixmDTO, fixm>{


    @Override
    public fixm convert(fixmDTO source) {
        return fixm.builder()
                .uamIdentification(source.getFlightIdentifier().getUamIdentification())
                .departureLongitude(source.getDeparture().getVertiport().getLongitude())
                .departureLatitude(source.getDeparture().getVertiport().getLatitude())
                .departureDate(source.getDeparture().getPlannedDepartureTime().getDate())
                .departureTime(source.getDeparture().getPlannedDepartureTime().getTime())
                .departureTimeReference(source.getDeparture().getPlannedDepartureTime().getTimeReference())
                .arrivalLongitude(source.getArrival().getVertiport().getLongitude())
                .arrivalLatitude(source.getArrival().getVertiport().getLatitude())
                .arrivalDate(source.getArrival().getPlannedArrivalTime().getDate())
                .arrivalTime(source.getArrival().getPlannedArrivalTime().getTime())
                .arrivalTimeReference(source.getArrival().getPlannedArrivalTime().getTimeReference())
                .routes(null)
                .build();
    }
}
