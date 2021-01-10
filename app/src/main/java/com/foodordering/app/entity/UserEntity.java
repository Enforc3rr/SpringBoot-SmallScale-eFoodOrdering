package com.foodordering.app.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;
    private String username;
    private String firstName;
    private String lastName;
    private String userAddress;
    private String mobileNumber;
    private String email;
    private String password;
    private boolean userEnabled = true;
    private String role = "User";

    @OneToMany(mappedBy = "userid")
    private List<OrderEntity> orderEntity;

    public UserEntity(){

    }

    public UserEntity(String username,String email , String firstName, String lastName, String userAddress, String mobileNumber,
                      boolean userEnabled, String role,String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAddress = userAddress;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.userEnabled = userEnabled;
        this.role = role;
        this.password = password;
    }
    public String getPassword(){return password;}

    public void setPassword(String password){this.password=password;}

    public String getEmail(){return email;}

    public void setEmail(String email){this.email=email;}

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean isUserEnabled() {
        return userEnabled;
    }

    public void setUserEnabled(boolean userEnabled) {
        this.userEnabled = userEnabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<OrderEntity> getOrderEntity() {return orderEntity;}

    public void setOrderEntity(List<OrderEntity> orderEntity) {this.orderEntity = orderEntity;}
}
