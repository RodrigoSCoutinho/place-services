package br.com.rodrigoscoutinho.placeservices;

import br.com.rodrigoscoutinho.placeservices.api.PlaceRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlaceServicesApplicationTests {
    @Autowired
	WebTestClient webTestClient;

	@Test
	public void testCreatePlaceSuccess() {
		var name = "Valid Name";
		var state = "Valid State";
		var slug = "valid-name";

		webTestClient
				.post()
				.uri("/places")
				.bodyValue(
						new PlaceRequest(name, state)
				)
				.exchange()
				.expectBody()
				.jsonPath("name").isEqualTo(name)
				.jsonPath("state").isEqualTo(state)
				.jsonPath("slug").isEqualTo(slug)
				.jsonPath("createdAt").isNotEmpty()
				.jsonPath("updateAt").isNotEmpty();
	}

	@Test
	public void testCreatePlaceFailure(){
		var name = "";
		var state = "";

		webTestClient
				.post()
				.uri("/places")
				.bodyValue(
						new PlaceRequest(name, state)
				)
				.exchange()
				.expectStatus().isBadRequest();
	}
}
