package br.com.vvaug.spotifyutils.client;

import br.com.vvaug.spotifyutils.response.CategoriesItemResponse;
import br.com.vvaug.spotifyutils.response.SeveralCategoriesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="spotify-get-categories-client", url="${feign.spotify.categories.url}")
public interface SpotifyCategoriesClient {
	
	@GetMapping
	SeveralCategoriesResponse getCategories(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);
	
	@GetMapping("/{id}")
	CategoriesItemResponse getSingleCategory(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization );

}
