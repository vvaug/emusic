package br.com.vvaug.spotifyutils.resource;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vvaug.spotifyutils.response.CategoriesItemResponse;
import br.com.vvaug.spotifyutils.response.SeveralCategoriesResponse;
import br.com.vvaug.spotifyutils.usecase.GetSeveralCategoriesUseCase;
import br.com.vvaug.spotifyutils.usecase.GetSingleCategoryUseCase;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("browse/categories")
@RequiredArgsConstructor
public class CategoriesResource {
	
	
	private final GetSeveralCategoriesUseCase getSeveralCategoriesUseCase;
	private final GetSingleCategoryUseCase getSingleCategoryUseCase;
	
	@GetMapping
	public SeveralCategoriesResponse getCategories(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
		return getSeveralCategoriesUseCase.execute(authorization);
	}
	
	@GetMapping("/{id}")
	public CategoriesItemResponse getSingleCategory(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
		return getSingleCategoryUseCase.execute(id, authorization);
	}
}
