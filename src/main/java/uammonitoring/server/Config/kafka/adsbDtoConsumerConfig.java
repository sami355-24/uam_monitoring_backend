package uammonitoring.server.Config.kafka;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import uammonitoring.server.DTO.adsbDTO;

import java.util.Map;

@Configuration
public class adsbDtoConsumerConfig {

    private final String bootstrapServer = "34.64.73.86:9092";
    @Bean
    public Map<String,Object> adsbDtoConsumerConfigs() {
        return CommonJsonDeserializer.getStringObjectMap(bootstrapServer);
    }

    @Bean
    public ConsumerFactory<String, adsbDTO> adsbDTO_ConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                adsbDtoConsumerConfigs(),
                new StringDeserializer(),
                new JsonDeserializer<>(adsbDTO.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, adsbDTO> adsbDTOListener() {
        ConcurrentKafkaListenerContainerFactory<String, adsbDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(adsbDTO_ConsumerFactory());
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.RECORD);
        return factory;
    }

    @Bean
    public StringJsonMessageConverter jsonConverter() {
        return new StringJsonMessageConverter();
    }

}
