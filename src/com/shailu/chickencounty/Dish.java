package com.shailu.chickencounty;

public class Dish {
	private String Name;
	private int price;

	Dish(String s, int p) {
		this.Name = s;
		this.price = p;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
