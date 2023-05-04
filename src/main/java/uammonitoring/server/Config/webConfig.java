package uammonitoring.server.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import uammonitoring.server.Converter.fixmDTORouteToRouteConverter;
import uammonitoring.server.Converter.fixmDTOToFixmConverter;
import uammonitoring.server.Converter.fixmToFixmDTOConverter;

@Configuration
public class webConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new fixmDTOToFixmConverter());
        registry.addConverter(new fixmDTORouteToRouteConverter());
        registry.addConverter(new fixmToFixmDTOConverter());
    }
}
