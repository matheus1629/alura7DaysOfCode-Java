package alura7DaysOfCode;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ApiTop250Filmes {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

		HttpRequest request = HttpRequest
	            .newBuilder()
	            .uri(new URI("https://imdb-api.com/en/API/Top250Movies{apiKey}"))
	            .GET()
	            .build();
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpResponse<String> response =
			      client.send(request, BodyHandlers.ofString());

	            
		System.out.println(response.body());

	}

}
