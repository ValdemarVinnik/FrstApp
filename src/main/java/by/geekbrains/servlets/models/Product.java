package by.geekbrains.servlets.models;

public class Product {

    private int id;
    private int cost;
    private String title;

    public Product(int id, String title, int cost) {
        this.id = id;
        this.cost = cost;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }
}
