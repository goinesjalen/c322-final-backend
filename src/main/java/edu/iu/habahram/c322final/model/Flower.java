package edu.iu.habahram.c322final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "flowers")
public class Flower {

    @Id
    private int id;
    private String type;
    private String occasion;
    private String color;
    private int price;
    private String name;

    public Flower(){}

    public Flower(int id, String type, String occasion, String color, int price, String name) {
        this.id = id;
        this.type = type;
        this.occasion = occasion;
        this.color = color;
        this.price = price;
        this.name = name;
    }

    public String toLine(int id) {
        return String.format("%1$s,%2$s,%3$s,%4$s,%5$s,%6$s", this.id, this.type, this.occasion, this.color, this.price, this.name);
    }

    public static Flower fromLine(String line) {
        String[] tokens = line.split(",");
        return new Flower(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]), tokens[5]);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }
}