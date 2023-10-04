package br.com.rodrigoscoutinho.placeservices.domain;

import br.com.rodrigoscoutinho.placeservices.api.PlaceRequest;
import com.github.slugify.Slugify;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepository placeRepository;
    private Slugify slg;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
        this.slg = Slugify.builder().build();
    }

    public Mono<Place> create(PlaceRequest placeRequest){
        var place = new Place(null, placeRequest.name(), slg.slugify(placeRequest.name()),
               placeRequest.state(), placeRequest.createdAt(), placeRequest.updateAt());
        return placeRepository.save(place);
    }
}
