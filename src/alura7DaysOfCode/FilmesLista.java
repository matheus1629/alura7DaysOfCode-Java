package alura7DaysOfCode;

public class FilmesLista implements Content, Comparable<Content>{

	private String title;
	private String url;
	private String rating;
	private String year;
	private String[] titleSplit;
	private String[] yearSplit;
	private String ratingSplit;
	private String[] urlSplit;
	
	public FilmesLista(String title, String url, String rating, String year) {
		this.title = title;
		this.url = url;
		this.rating = rating;
		this.year = year;
	}
	
	@Override
	public String title() {
		titleSplit = this.title.split("\"");
		return this.titleSplit[2];
	}
	
	@Override
	public String rating() {
		ratingSplit = this.rating.replace("imDbRating\":\"", " ");
		return this.ratingSplit;
	}
	
	@Override
	public String year() {
		yearSplit = this.year.split("\"");
		return this.yearSplit[2];
	}

	@Override
	public String urlImage() {
		urlSplit = this.url.split("\"");
		return this.urlSplit[2];
	}
	
	@Override
	public String toString() {
		return ("Título: " + this.title + " | Nota: " + this.rating + " | Ano: " + this.year + " | URL: " + this.url);
	}

	@Override
	public int compareTo(Content outro) {
		return this.rating().compareTo(outro.rating());
	}

}
