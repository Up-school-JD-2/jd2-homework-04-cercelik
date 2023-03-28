package UpSchoolHw.MusicStore;

public class Songs {
	private String songName;
	private Albums album;
	private double length;

	public Songs(Albums album, String songName, double length) {
		this.album = album;
		this.songName = songName;
		this.length = length;
	}

	public String getsongName() {
		return songName;
	}

	public double getLength() {
		return length;
	}
	
	public Albums getAlbum() {
		return album;
	}

	public void printSongs() {

		System.out.println("Song name is: " + getsongName());
		System.out.println("Singer name is: " + album.getSingerName());
		System.out.println("Album name is: " + album.getSingerName());
		System.out.println("Song length is: " + getLength());
		System.out.println();
	}

}
