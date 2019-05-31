package monopoly3;

import java.util.*;

class Utility {

	protected String name;
	protected int rent;
	protected int price;
	protected boolean bought = false;
	protected int ownerID = -1;
	protected String picture;
	
	/**
	* Initilise the utility
	* @param name The name of the utility
	* @param price The cost of the utility to buy
	*/
	public Utility(String name, int price, String picture) {
		this.name = name;
		this.price = price;
		rent = price / 2;
		this.picture = picture;
	}

	/**
	* Player buys the utility
	* @param player_id the new owners id
	*/
	public void buy_utility(int player_id) {
		bought = true;
		ownerID = player_id;
	}

	/**
	* Return the id of the owner
	* @return the id of owner
	*/
	public int owner() {
		return ownerID;
	}

	/**
	* Return the name of the utilities picture
	* @return the name of the picture
	*/
	public String picture() {
		return picture;
	}

	/**
	* Return the cost of the utility
	* @return the price
	*/
	public int cost() {
		return price;
	}

	/**
	* Return the name of the utility
	* @return the name
	*/
	public String name() {
		return name;
	}

	/**
	* Return the rent of the utility
	* @return the rent
	*/
	public int rent() {
		return rent;
	}

	/**
	* Double the rent when player owns multiple railroads
	*/
	public void update_rent() {
		rent *= 2;
	}

	/**
	* Check if the utility has been bought
	* @return true if bought, false otherwise
	*/
	public boolean available() {
		return bought;
	}
}