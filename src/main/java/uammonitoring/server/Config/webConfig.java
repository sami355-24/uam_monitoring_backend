package uammonitoring.server.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import uammonitoring.server.Converter.*;

@Configuration
public class webConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new fixmDTOToFixmConverter());
        registry.addConverter(new fixmDTORouteToRouteConverter());
        registry.addConverter(new fixmToFixmDTOConverter());
        registry.addConverter(new adsbDTOToAdsb());
        registry.addConverter(new ListOfAdsbToListOfAdsbDTO());
    }
}
