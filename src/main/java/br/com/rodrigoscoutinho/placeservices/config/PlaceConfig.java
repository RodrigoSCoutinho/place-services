package br.com.rodrigoscoutinho.placeservices.config;


import br.com.rodrigoscoutinho.placeservices.domain.PlaceRepository;
import br.com.rodrigoscoutinho.placeservices.domain.PlaceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlaceConfig {

    @Bean
    PlaceService placeService(PlaceRepository placeRepository){
        return new PlaceService((placeRepository));
    }
}
