package by.baranov.webproject.entity;

import java.io.Serializable;

public class User extends Entity implements Serializable {
    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String role;

    public User(long userId, String firstName, String lastName, String email, String password, String phoneNumber,
                String address, String role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role=role;
    }

    public User(long userId, String firstName, String lastName, String email, String phoneNumber, String address,
                String role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role=role;
    }

    public long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "{" +
                "  \"userId\":\"" + userId + "\"" +
                ", \"firstName\":\"" + firstName + "\"" +
                ", \"lastName\":\"" + lastName + "\"" +
                ", \"email\":\"" + email + "\"" +
                ", \"password\":\"" + password + "\"" +
                ", \"phoneNumber\":\"" + phoneNumber + "\"" +
                ", \"address\":\"" + address + "\"" +
                ", \"role\":\"" + role + "\"" +
                '}';
    }
}
