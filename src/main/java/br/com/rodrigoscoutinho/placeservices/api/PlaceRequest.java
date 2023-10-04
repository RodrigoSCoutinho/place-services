package br.com.rodrigoscoutinho.placeservices.api;

import jakarta.validation.constraints.NotBlank;


public record PlaceRequest(
        @NotBlank String name, @NotBlank String state){
}
