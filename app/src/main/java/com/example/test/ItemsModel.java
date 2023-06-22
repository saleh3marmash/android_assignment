package com.example.test;

public class ItemsModel {
    String itemName;
    int price;
    int image;

    public ItemsModel(String itemName, int price, int image) {
        this.itemName = itemName;
        this.price = price;
        this.image = image;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}
