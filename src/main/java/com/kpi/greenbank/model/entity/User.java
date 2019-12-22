package com.kpi.greenbank.model.entity;

import java.util.Objects;

public class User {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private UserRole role;
    private String address;
    private String city;
    private UserBranch branch;
    private String zip;
    private String phoneNumber;
    private Float amount;

    public User() {

    }

    public User(
            String email,
            String password,
            String firstName,
            String lastName,
            UserRole role,
            String address,
            String city,
            UserBranch branch,
            String zip,
            String phoneNumber,
            Float amount) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.address = address;
        this.city = city;
        this.branch = branch;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public UserBranch getBranch() {
        return branch;
    }

    public void setBranch(UserBranch branch) {
        this.branch = branch;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(email, user.email)) return false;
        if (!Objects.equals(password, user.password)) return false;
        if (!Objects.equals(firstName, user.firstName)) return false;
        if (!Objects.equals(lastName, user.lastName)) return false;
        if (!Objects.equals(role.getTitle(), user.role.getTitle())) return false;
        if (!Objects.equals(address, user.address)) return false;
        if (!Objects.equals(city, user.city)) return false;
        if (!Objects.equals(branch.getTitle(), user.branch.getTitle())) return false;
        if (!Objects.equals(zip, user.zip)) return false;
        if (!Objects.equals(phoneNumber, user.phoneNumber)) return false;

        return Objects.equals(amount, user.amount);
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (role.getTitle() != null ? role.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (branch.getTitle() != null ? branch.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "User(" +
                "email=" + email +
                ", password=" + '\'' + password + '\'' +
                ", firstName=" + '\'' + firstName + '\'' +
                ", lastName=" + '\'' + lastName + '\'' +
                ", role=" + '\'' + role.getTitle() + '\'' +
                ", address=" + '\'' + address + '\'' +
                ", city=" + '\'' + city + '\'' +
                ", branch=" + '\'' + branch.getTitle() + '\'' +
                ", zip=" + '\'' + zip + '\'' +
                ", phoneNumber=" + '\'' + phoneNumber + '\'' +
                ", amount=" + '\'' + amount + '\'' +
                ')';
    }
}
