package br.com.vvaug.spotifyutils.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class CategoriesResponse {
	
	private String href;
    private int limit;
    private String next;
    private int offset;
    private Object previous;
    private int total;
    private ArrayList<CategoriesItemResponse> items;
	

}
