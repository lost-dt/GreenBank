package com.kpi.greenbank.model.entity;

import java.util.Objects;

public class User {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private String address;
    private String city;
    private String branch;
    private String zip;
    private String phoneNumber;

    public User() {

    }

    public User(
            String email,
            String password,
            String firstName,
            String lastName,
            String role,
            String address,
            String city,
            String branch,
            String zip,
            String phoneNumber) {
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
    }

    protected User(Builder builder) {
        email = builder.email;
        password = builder.password;
        firstName = builder.firstName;
        lastName = builder.lastName;
        role = builder.role;
        address = builder.address;
        city = builder.city;
        branch = builder.branch;
        zip = builder.zip;
        phoneNumber = builder.phoneNumber;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
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

    public static class Builder {

        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private String role;
        private String address;
        private String city;
        private String branch;
        private String zip;
        private String phoneNumber;

        public Builder() {

        }

        public Builder setEmail(String email) {
            this.email = email;

            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;

            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;

            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;

            return this;
        }

        public Builder setRole(String role) {
            this.role = role;

            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;

            return this;
        }

        public Builder setCity(String city) {
            this.city = city;

            return this;
        }

        public Builder setBranch(String branch) {
            this.branch = branch;

            return this;
        }

        public Builder setZip(String zip) {
            this.zip = zip;

            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;

            return this;
        }



        public User build() {
            return new User(this);
        }

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
        if (!Objects.equals(address, user.address)) return false;
        if (!Objects.equals(city, user.city)) return false;
        if (!Objects.equals(branch, user.branch)) return false;
        if (!Objects.equals(zip, user.zip)) return false;

        return Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (branch != null ? branch.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "User(" +
                "email=" + email +
                ", password=" + '\'' + password + '\'' +
                ", firstName=" + '\'' + firstName + '\'' +
                ", lastName=" + '\'' + lastName + '\'' +
                ", address=" + '\'' + address + '\'' +
                ", city=" + '\'' + city + '\'' +
                ", branch=" + '\'' + branch + '\'' +
                ", zip=" + '\'' + zip + '\'' +
                ", phoneNumber=" + '\'' + phoneNumber + '\'' +
                ')';
    }
}
