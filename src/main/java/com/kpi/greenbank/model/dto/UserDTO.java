package com.kpi.greenbank.model.dto;

import com.kpi.greenbank.model.entity.UserBranch;
import com.kpi.greenbank.model.entity.UserRole;

import java.util.Objects;

public class UserDTO {

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

    public UserDTO() {

    }

    private UserDTO(Builder builder) {
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
        amount = builder.amount;
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

    public static class Builder {

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

        public Builder setRole(UserRole role) {
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

        public Builder setBranch(UserBranch branch) {
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

        public Builder setAmount(Float amount) {
            this.amount = amount;

            return this;
        }


        public UserDTO build() {
            return new UserDTO(this);
        }

    }

}
