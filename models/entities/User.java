package models.entities;

import models.enums.Role;

abstract public class User {
    private String name;
    private Role role;
    private double walletBalance = 0.0;

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public void addToWallet(double amount) {
        this.walletBalance += amount;
    }

    public boolean deductFromWallet(double amount) {
        if (walletBalance >= amount) {
            walletBalance -= amount;
            return true;
        }
        return false;
    }

}