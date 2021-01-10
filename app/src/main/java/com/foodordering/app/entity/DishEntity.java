package com.foodordering.app.entity;
import javax.persistence.*;
@Entity
public class DishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dishid;
    private String dishName;
    private String dishType;
    private int dishCost;
    private String dishDescription;

    public DishEntity(){

    }
    public DishEntity(String dishName, String dishType, int dishCost, String dishDescription) {
        this.dishName = dishName;
        this.dishType = dishType;
        this.dishCost = dishCost;
        this.dishDescription = dishDescription;
    }

    public long getDishid() {return dishid;}
    public void setDishid(long dishid) {this.dishid = dishid;}

    public String getDishName() {
        return dishName;
    }
    public void setDishName(String dishName) { this.dishName = dishName;}

    public String getDishType() {
        return dishType;
    }
    public void setDishType(String dishType) {
        this.dishType = dishType;
    }

    public int getDishCost() {
        return dishCost;
    }
    public void setDishCost(int dishCost) {
        this.dishCost = dishCost;
    }

    public String getDishDescription() {
        return dishDescription;
    }
    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }
}
