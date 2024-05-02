package edu.iu.habahram.c322final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(schema = "flowers")
public class Order {
    @Id
    private int id;
    private int customerId;
    private String flowerName;
    private int cost;
    private String firstName;
    private String lastName;
    private String status;


    public Order() {}


    public Order(int id, int customerId, String flowerName, int cost, String firstName, String lastName, String status) {
        this.id = id;
        this.customerId = customerId;
        this.flowerName = flowerName;
        this.cost = cost;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }


    public String toLine(int id) {
        return String.format("%1$s,%2$s,%3$s,%4$s,%5$s,%6$s,%7$s", id, this.customerId, this.flowerName, this.cost, this.firstName, this.lastName, this.status);
    }

    public static Order fromLine(String line) {
        String[] tokens = line.split(",");
        return new Order(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3]), tokens[4], tokens[5], tokens[6]);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}