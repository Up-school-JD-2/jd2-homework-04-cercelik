package UpSchoolHw.MusicStore;

import java.util.ArrayList;
import java.util.List;

public class Basket {

	private String userName;
	private List<Albums> albums;

	Basket(String userName) {
		this.userName = userName;
		albums = new ArrayList<>();

	}

	public String getUser() {
		return userName;
	}

	public void addBasketItem(Albums album) {
		this.albums.add(album);

	}

	public double getTotalPrice() {
		double totalPrice = 0;
		for (Albums album : albums) {
			totalPrice += album.getAlbumPrice();
		}
		return totalPrice;
	}

	public void printBasket() {
		System.out.println("User name is: " + getUser());
		if (albums.isEmpty()) {
			System.out.println("No item in the basket");
		}

		else {
			System.out.println("Albums in the basket: ");
			for (Albums album : albums) {
				System.out.println(album.getAlbumName());
			}

		}
		
		System.out.println("Total price is: " + getTotalPrice());

	}

}
