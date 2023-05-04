package uammonitoring.server.Converter;

import org.springframework.core.convert.converter.Converter;
import uammonitoring.server.DTO.fixmDTO;
import uammonitoring.server.DTO.partOfFixmDTO.*;
import uammonitoring.server.Entity.fixm;
import uammonitoring.server.Entity.route;

import java.util.ArrayList;
import java.util.List;

public class fixmToFixmDTOConverter implements Converter<fixm, fixmDTO> {

    @Override
    public fixmDTO convert(fixm source) {
        FlightIdentifier flightIdentifier = new FlightIdentifier(source.getUamIdentification());
        Vertiport deparuteVertiport = new Vertiport(source.getDepartureLongitude(), source.getDepartureLatitude());
        PlannedTime departureTime = new PlannedTime(source.getDepartureDate(), source.getDepartureTime(), source.getDepartureTimeReference());
        Departure departure = new Departure(deparuteVertiport, departureTime);
        Vertiport arrivalVertiport = new Vertiport(source.getArrivalLongitude(), source.getArrivalLatitude());
        PlannedTime arrivalTime = new PlannedTime(source.getArrivalDate(), source.getArrivalTime(), source.getArrivalTimeReference());
        Arrival arrival = new Arrival(arrivalVertiport, arrivalTime);

        List<route> routes = source.getRoutes();
        List<DTORoute> dtoRoutes = new ArrayList<>();
        for (route r : routes) {
            DTORoute dtoRoute = new DTORoute(r.getLongitude(), r.getLatitude());
            dtoRoutes.add(dtoRoute);
        }

        return fixmDTO.builder()
                .flightIdentifier(flightIdentifier)
                .departure(departure)
                .arrival(arrival)
                .route(dtoRoutes)
                .build();
    }
}
