package UpSchoolHw.MusicStore;

import java.util.List;

public class Albums {

	private String albumName;
	private String singerName;
	private int releaseDate;
	private double albumPrice;



	Albums(String albumName, String singerName, int releaseDate, double albumPrice) {
		this.albumName = albumName;
		this.singerName = singerName;
		this.releaseDate = releaseDate;
		this.albumPrice = albumPrice;
	
	}

	public String getAlbumName() {
		return albumName;
	}

	public String getSingerName() {
		return singerName;
	}

	public int getReleaseDate() {
		return releaseDate;
	}

	public double getAlbumPrice() {
		return albumPrice;
	}

	public void printAlbums(List<Songs> songs) {

		System.out.println("Album name is: " + getAlbumName());
		System.out.println("Singer name is: " + getSingerName());
		System.out.println("Album release date is: " + getReleaseDate());
		System.out.println("Album price is: " + getAlbumPrice());
		System.out.println();
		System.out.println("***Album Songs***");

		for (Songs song : songs) {

			System.out.println("* " + song.getsongName());

		}
		

		System.out.println();

	}

}
