package alura7DaysOfCode;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ApiTop250Filmes {

	public static void main(String[] args) throws Exception {
		
		String apiKey = "k_kqxu078z";
		
		String json = new ImdbApiClient(apiKey).getBody(); 

		List<FilmesLista> filmes = new ImdbMovieJsonParser(json).parse();
		
		PrintWriter writer = new PrintWriter("content.html");
		new HtmlGenerator(writer).generate(filmes);
		writer.close();		
	}

}