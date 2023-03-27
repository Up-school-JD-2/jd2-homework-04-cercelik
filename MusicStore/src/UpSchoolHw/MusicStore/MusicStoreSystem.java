package UpSchoolHw.MusicStore;

import java.util.ArrayList;
import java.util.List;

class MusicStoreSystem {

	private List<Albums> albums;
	private List<Songs> songs;
	private List<UserManagement> users;


	public MusicStoreSystem() {
		albums = new ArrayList<>();
		songs = new ArrayList<>();
		users = new ArrayList<>();
		
	}

	public void addAlbums(Albums albums) {
		this.albums.add(albums);
	}

	public void addSongs(Songs songs) {
		this.songs.add(songs);
	}

	public void addUsers(UserManagement users) {
		this.users.add(users);
	}


	public void listUsers() {
		System.out.println();

		for (UserManagement u : users) {
			u.UserInfo();
		}
	}

	public void listAlbumsWithSongs() {
		System.out.println("------------------Album with Songs------------------");
		for (Albums a : albums) {
			List<Songs> albumSongs = new ArrayList<>();
			for (Songs s : songs) {
				if (s.getAlbum().getAlbumName() == a.getAlbumName()) {
					albumSongs.add(s);
				}
			}
			a.printAlbums(albumSongs);
			System.out.println("-----------------------------------------");
		}
	}
	
	public List<Albums> getAlbums() {
		
			return albums;
		
	}

	public boolean existsAlbums(String albumName) {

		boolean existsAlbums = false;
		for (Albums a : albums) {
			if (a.getAlbumName().equals(albumName)) {
				existsAlbums = true;
				break;
			}
		}

		return existsAlbums;

	}

	public UserManagement findUser(String selectedUser) {
	
		UserManagement result = null;
		for (UserManagement user : users) {
			
			if (user.getLoginName().equals(selectedUser)) {
				result = user;
				break;
			}
			else
				continue;
		}

		return result;

	}

	public void listSongs() {
		System.out.println("------------------Songs------------------");
		for (Songs song : songs) {
			song.printSongs();

			System.out.println("-----------------------------------------");
		}
	}



}
