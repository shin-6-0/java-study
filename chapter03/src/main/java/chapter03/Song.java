package chapter03;

public class Song {
	private String title;
	private String album;
	private String artist;
	private String composer;
	private int year;
	private int track;
	
	public Song() {}
	public Song(String title, String album, String artist, String composer, int year, int track) {
		super();
		this.title = title;
		this.album = album;
		this.artist = artist;
		this.composer = composer;
		this.year = year;
		this.track = track;
		
		System.out.println();
	}
	
	public Song(String title, String artist) {
//		this.title=title;
//		this.artist=artist;
		
		this(title,null,artist,null,0,0);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	public void show() {
		// TODO Auto-generated method stub
		System.out.println(artist+" "+title+" ( "+album+", "+year+", "+track+"번 track, "+composer+" 작곡 )");
	}
	
	
}
