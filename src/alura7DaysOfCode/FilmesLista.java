package alura7DaysOfCode;

public class FilmesLista {

	private String title;
	private String url;
	private String rating;
	private String year;
	
	public FilmesLista(String title, String url, String rating, String year) {
		this.title = title;
		this.url = url;
		this.rating = rating;
		this.year = year;
	}
	
	@Override
	public String toString() {
		return ("Título: " + this.title + " | Nota: " + this.rating + " | Ano: " + this.year + " | URL: " + this.url);
	}
	
}
