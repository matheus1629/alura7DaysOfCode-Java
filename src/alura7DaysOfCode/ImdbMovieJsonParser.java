package alura7DaysOfCode;

import java.util.ArrayList;
import java.util.List;

public class ImdbMovieJsonParser {

	private String json;
	
	
	public ImdbMovieJsonParser(String json) {
		this.json = json;
	}

	public List<FilmesLista> parse() {
		
		// parâmetro para substring()
		int finalSubString = json.lastIndexOf("]");
		int comecoSubString = json.indexOf("{", 1);
		String jsonInteiro = json.substring(comecoSubString, finalSubString);
		
		// json para Array
		String jsonParaSplit = jsonInteiro.replace("},{", "}gambiarra{");
		String[] jsonArray = jsonParaSplit.split("gambiarra");
			
		
		// instanciando objeto da classe FilmesListas e adicionando a lista
		List<FilmesLista> filmes = new ArrayList<FilmesLista>();
		for (String string : jsonArray) {
			String[] atributos = string.split("\"{1},\"{1}");
			FilmesLista objetoFilmes = new FilmesLista(atributos[2], atributos[5], atributos[7], atributos[4]);
			
			filmes.add(objetoFilmes);
		}
		return filmes;
		
	}
	
	
}
