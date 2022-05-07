package alura7DaysOfCode;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ImdbApiClient {

	private String apiKey;

	public ImdbApiClient(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getBody() throws IOException, InterruptedException, Exception {
		HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://imdb-api.com/en/API/Top250Movies/" + apiKey)).GET().build();
		HttpClient client = HttpClient.newHttpClient();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String json = response.body();
		return json;
	}
}
