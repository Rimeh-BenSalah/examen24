package examen2024;

public class Serie extends Content{
	private int nbEpisodes;
	private int dureeEpisode;
	public Serie(String title,String genre,boolean isfree,int nbEpisodes,int dureeEpisode) {
		super(title,genre,isfree);
		this.nbEpisodes=nbEpisodes;
		this.dureeEpisode=dureeEpisode;
	}
	public void afficheDetails() {
		System.out.println(title+" "+genre+" "+isfree+" "+nbEpisodes+" "+dureeEpisode);
	}
	public int getDuration() {
	        return nbEpisodes * dureeEpisode;
	    }

}
