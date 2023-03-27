package UpSchoolHw.MusicStore;

import java.util.Scanner;

public class MusicStoreTest {

	// public static String userName,email,address;
	public static MusicStoreSystem musicStoreSystem = new MusicStoreSystem();
	public static UserManagement currentUser;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Albums album1 = new Albums("The Wall", "Pink Floyd", 1979, 12.5);
		Albums album2 = new Albums("Whatever People Say I Am, That's What I'm Not", "Arctic Monkeys", 2006, 25);

		Songs song1 = new Songs(album1, "Goodbye Blue Sky", 2.45);
		Songs song2 = new Songs(album1, "Comfortably Numb", 6.23);
		Songs song3 = new Songs(album1, "Another Brick in the Wall", 3.11);
		Songs song4 = new Songs(album1, "Hey You", 4.41);
		Songs song5 = new Songs(album1, "Is there anybody out there?", 2.42);

		Songs song6 = new Songs(album2, "Fake Tales Of San Francisco", 2.58);
		Songs song7 = new Songs(album2, "When the sun goes down", 3.20);
		Songs song8 = new Songs(album2, "Mardy Bum", 2.55);
		Songs song9 = new Songs(album2, "Dancing Shoes", 2.21);

		UserManagement user1 = new UserManagement("Ceren Çelik", "cerencelik", "celikceren@gmail.com",
				"Beşiktaş/İstanbul");
		UserManagement user2 = new UserManagement("Eren Çelik", "erencelik", "celikeren@gmail.com", "Çorlu/Tekirdağ");
		UserManagement user3 = new UserManagement("Baran Çelik", "barancelik", "celikbaran@gmail.com",
				"Dublin/Ireland");

		MusicStoreTest m = new MusicStoreTest();


		musicStoreSystem.addAlbums(album1);
		musicStoreSystem.addAlbums(album2);
		musicStoreSystem.addSongs(song1);
		musicStoreSystem.addSongs(song2);
		musicStoreSystem.addSongs(song3);
		musicStoreSystem.addSongs(song4);
		musicStoreSystem.addSongs(song5);
		musicStoreSystem.addSongs(song6);
		musicStoreSystem.addSongs(song7);
		musicStoreSystem.addSongs(song8);
		musicStoreSystem.addSongs(song9);
		musicStoreSystem.addUsers(user1);
		musicStoreSystem.addUsers(user2);
		musicStoreSystem.addUsers(user3);

		m.printMenu();
		m.chooseAction();

	}

	public void printMenu() {

		System.out.println("\n********************");
		System.out.println("Welcome to the Music Store with only 2 albums:) ");
		System.out.println();
		System.out.println("1- Choose user: ");
		System.out.println("2- Search a music album: ");
		System.out.println("3- Add to basket:  ");
		System.out.println("4- Purchase album:  ");
		System.out.println("********************\n");
	
	}

	public void searchAlbum() {

		Scanner s = new Scanner(System.in);
		System.out.println("Please enter album name you look for.");

		String searchedAlbum = s.nextLine();

		if (musicStoreSystem.existsAlbums(searchedAlbum)) {
			System.out.println("You are lucky. You found the album we sold, out of 9 million albums. ");
		}

		else {
			System.out.println("Album not found. ");
		}

	}

	public void chooseUser() {

		Scanner s = new Scanner(System.in);
		System.out.println("Users in the system are listed below. Please select one of them to proceed");
		musicStoreSystem.listUsers();
		String selectedUser = s.nextLine();

		System.out.println();
		currentUser = musicStoreSystem.findUser(selectedUser);
		if (currentUser == null) {
			System.out.println("user not found. ");
		}

		else {
			System.out.println("Continue shopping as: " + currentUser.getUserName());
		}

	}

	public void addAlbumToBasket() {
		if (currentUser == null) {
			System.out.println("Please select user before adding an item to a basket.");
		}

		else {

			boolean isItemAddedtoBasket = false;
			Scanner s = new Scanner(System.in);
			System.out.println("Please enter album name you want to buy: ");
			String selectedAlbumName = s.nextLine();

			for (Albums album : musicStoreSystem.getAlbums()) {
				if (album.getAlbumName().equals(selectedAlbumName)) {
					currentUser.basket.addBasketItem(album);
					System.out.println("Selected album added to the basket. ");
					isItemAddedtoBasket = true;
					break;

				}

			}

			if (isItemAddedtoBasket == false) {
				System.out.println("Album not found");
			}

		}
	}

	public void purchaseAlbums() {

		Scanner s = new Scanner(System.in);

		if (currentUser == null) {
			System.out.println("Select user before purchasing albums");
		}

		else {
			if (currentUser.basket.getTotalPrice() == 0) {
				System.out.println("Add album to your basket before purchasing. ");
			}

			else {
				currentUser.basket.printBasket();
				System.out.println("Please select 5 to proceed with purchasing items in your basket above. ");
				int userSelection = s.nextInt();
				if (userSelection == 5) {
					System.out.println("Finished purchasing.");
					System.out.println("Total price is: " + currentUser.basket.getTotalPrice());
				}

				else {
					System.out.println("Wrong input.");
					printMenu();
				}
			}

		}
	}

	public void chooseAction() {

		System.out.println("Please select an action from menu (1-4)");
		Scanner s = new Scanner(System.in);
		int selection = s.nextInt();
		switch (selection) {
		case 1:
			chooseUser();
			break;

		case 2:
			searchAlbum();
			break;

		case 3:
			addAlbumToBasket();
			break;

		case 4:
			purchaseAlbums();
			break;
		}

		printMenu();
		chooseAction();

	}

}
