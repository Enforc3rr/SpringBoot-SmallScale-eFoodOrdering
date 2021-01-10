package com.foodordering.app.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderid;

    private int orderCost;

    @ManyToOne
    private UserEntity userid;

    @ManyToMany
    @JoinTable(name = "Order_Dish", joinColumns = {@JoinColumn (name = "orderid")} ,
    inverseJoinColumns = {@JoinColumn(name = "dishid")})
    private List<DishEntity> dishids;

    public OrderEntity(UserEntity userid, List<DishEntity> dishids , int orderCost) {
        this.userid = userid;
        this.orderCost = orderCost;
        this.dishids = dishids;
    }

    public OrderEntity(){ }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public UserEntity getUserid() {
        return userid;
    }

    public void setUserid(UserEntity userid) {
        this.userid = userid;
    }

    public List<DishEntity> getDishids() {
        return dishids;
    }

    public void setDishids(List<DishEntity> dishids) {
        this.dishids = dishids;
    }

    public int getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(int orderCost) {
        this.orderCost = orderCost;
    }
}
