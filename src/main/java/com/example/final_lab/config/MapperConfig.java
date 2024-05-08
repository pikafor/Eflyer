package com.example.final_lab.config;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.text.SimpleDateFormat;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

/**
 * Configuration ModelMapper,
 *
 * @author <a href="mailto:azuev@bostonsd.ru></a>"
 * @date 26.12.2022
 */
@Configuration
@Slf4j
public class MapperConfig {
    @Bean(value = "mapper")
    @Primary
    @Scope("prototype")
    public ModelMapper mapper() {
        return createDefaultModelMapper();
    }


    private static ModelMapper createDefaultModelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setPreferNestedProperties(false)
                .setFieldAccessLevel(PRIVATE)
                .setSkipNullEnabled(true);
        return mapper;
    }

    @Bean(name = "dateFormatter")
    public SimpleDateFormat dateFormatter() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    }

    @Bean(name = "dateFormat")
    public SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("dd.MM.yyyy");
    }
    @Bean(name = "dateTimeFormat")
    public SimpleDateFormat dateTimeFormat() {
        return new SimpleDateFormat("dd.MM.yyyy HH:mm");
    }
}
