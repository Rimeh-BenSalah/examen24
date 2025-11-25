package examen2024;

public class Movie extends Content{
	private int duration;
	public Movie(String title,String genre,boolean isfree,int duration){
		super(title,genre,isfree);
		this.duration=duration;
	}
	public void afficheDetails() {
		System.out.println(title+" "+genre+" "+isfree+" "+duration);
	}
	public int getDuration() {
		return duration;
	}

}
