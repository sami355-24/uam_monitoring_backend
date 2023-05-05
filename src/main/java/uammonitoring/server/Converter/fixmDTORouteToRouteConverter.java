package uammonitoring.server.Converter;

import org.springframework.core.convert.converter.Converter;
import uammonitoring.server.DTO.PartOfFixmDTO.DTORoute;
import uammonitoring.server.DTO.fixmDTO;
import uammonitoring.server.Entity.route;

import java.util.ArrayList;
import java.util.List;

public class fixmDTORouteToRouteConverter implements Converter<fixmDTO, List<route>> {

    @Override
    public List<route> convert(fixmDTO source) {
        List<DTORoute> sourceRoutes = source.getRoute();
        List<route> resultRoutes = new ArrayList<>();

        for (DTORoute sourceRoute : sourceRoutes) {
            route resultRoute = route.builder()
                    .longitude(sourceRoute.getLongitude())
                    .latitude(sourceRoute.getLatitude())
                    .build();

            resultRoutes.add(resultRoute);
        }

        return resultRoutes;
    }
}
