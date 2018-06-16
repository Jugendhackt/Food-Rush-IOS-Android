package com.example.calebseeling.foodcrush;

/**
 * Created by calebseeling on 16.06.18.
 */

public class generater_bar {

    public String Name;
    public String Wanted;
    public int payment;


    public generater_bar(String name, String wanted, int payment) {
        Name = name;
        Wanted = wanted;
        this.payment = payment;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getWanted() {
        return Wanted;
    }

    public void setWanted(String wanted) {
        Wanted = wanted;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
}
