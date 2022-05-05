package alura7DaysOfCode;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.google.gson.Gson;

public class ApiTop250Filmes {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		
		String apiKey = "k_kqxu078z";

		HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://imdb-api.com/en/API/Top250Movies/" + apiKey)).GET().build();
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		String json = response.body();
		
		// parâmetro para substring()
		int finalSubString = json.lastIndexOf("]");
		int comecoSubString = json.indexOf("{", 1);
		String jsonInteiro = json.substring(comecoSubString, finalSubString);
		

		// json para Array
		String jsonParaSplit = jsonInteiro.replace("},{", "}gambiarra{");
		String[] jsonArray = jsonParaSplit.split("gambiarra");
		
		List<FilmesLista> filmes = new ArrayList<>();
		
		// instanciando objeto da classe FilmesListas e adicionando a lista
		for (String string : jsonArray) {
			String[] atributos = string.split("\"{1},\"{1}");
			FilmesLista objetoFilmes = new FilmesLista(atributos[2], atributos[5], atributos[7], atributos[4]);
			filmes.add(objetoFilmes);
		}
		
		filmes.forEach(System.out::println);	
			
	}

}