package br.com.rodrigoscoutinho.placeservices.web;

import br.com.rodrigoscoutinho.placeservices.api.PlaceResponse;
import br.com.rodrigoscoutinho.placeservices.domain.Place;

public class PlaceMapper {
    public static PlaceResponse fromPlaceToResponse(Place place){
        return new PlaceResponse(place.name(), place.slug(), place.state(), place.createdAt(), place.updateAt());
    }
}
