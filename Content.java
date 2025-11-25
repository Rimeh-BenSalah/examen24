package examen2024;

public abstract class Content implements Streamable{
	protected String title;
	protected String genre;
	protected boolean isfree;
	Content(String title,String genre,boolean isfree){
		this.title=title;
		this.genre=genre;
		this.isfree=isfree;
	}
	void afficheDetails(){};
	public void play(){
		System.out.println("Lecture de:"+" "+genre+"afficher les détails du contenu");
		
	}
	public String getTitle() {
		return title;}
	public String getGenre() {
		return genre;}
}
