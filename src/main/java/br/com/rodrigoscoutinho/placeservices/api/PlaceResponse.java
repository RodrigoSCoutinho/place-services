package br.com.rodrigoscoutinho.placeservices.api;

import java.time.LocalDateTime;

public record PlaceResponse(
        String name, String slug, String state, LocalDateTime createdAt, LocalDateTime updateAt
){
}
