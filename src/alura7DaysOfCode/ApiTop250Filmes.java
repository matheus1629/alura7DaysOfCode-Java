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
		
//		System.out.println(jsonInteiro);
	
//		String jsonParaSplit = jsonInteiro.replace("},{", "}gambiarra{");
//		String[] jsonArray = jsonParaSplit.split("gambiarra");
//		
//		List<String> titles = new ArrayList<>();
//		List<String> urlImages = new ArrayList<>();
//		List<String> rating = new ArrayList<>();
//		List<String> years = new ArrayList<>();
//		
//		for (String string : jsonArray) {
//			String[] atributos = string.split("\"{1},\"{1}");
//			titles.add(atributos[2]);
//			urlImages.add(atributos[6]);
//			rating.add(atributos[8]);
//			years.add(atributos[4]);
//		}
		
		
//		String [] atributos = jsonArray[1].split("\"{1},\"{1}");
			
	}

}


/*
*substring(), split() e replace()  \ |
*Matcher e Pattern  regex
*Com o resultado do parseamento, você deverá criar diferentes listas, 
*cada uma com um atributo do filme. Uma lista com os títulos, outra com a URL da imagem e assim por diante. 
*
*1º EXTRAIR O json inteiro [ ]
*2º split para separar os filmes
*3º separar cada informação do filme String [] atributos = jsonFilmes.split(“\”,”\”);
*4º pegar o atributo na posição correta usando métodos da classe String e guardá-lo em uma lista. 
*/