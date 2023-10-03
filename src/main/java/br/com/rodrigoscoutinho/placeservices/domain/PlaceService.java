package br.com.rodrigoscoutinho.placeservices.domain;

import br.com.rodrigoscoutinho.placeservices.api.PlaceRequest;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Mono<Place> create(PlaceRequest placeRequest){
        var place = new Place(null, placeRequest.name(), placeRequest.slug(),
               placeRequest.state(), placeRequest.createdAt(), placeRequest.updateAt());
        return placeRepository.save(place);
    }
}
