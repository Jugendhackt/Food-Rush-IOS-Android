package com.example.calebseeling.foodcrush;

/**
 * Created by calebseeling on 16.06.18.
 */

public class generater_bar {

    public  static String Name;
    public static String Wanted;
    public static int payment;


    public generater_bar(String name, String wanted, int payment) {
        Name = name;
        Wanted = wanted;
        this.payment = payment;
    }

    public static String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static String getWanted() {
        return Wanted;
    }

    public void setWanted(String wanted) {
        Wanted = wanted;
    }

    public static int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
}
