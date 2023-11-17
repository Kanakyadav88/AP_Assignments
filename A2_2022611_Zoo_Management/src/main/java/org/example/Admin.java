package org.example;
import java.util.*;
public class Admin {
    public int attraction_count=0;
    private int totalVisitors;
    private double totalRevenue;

    public int getTotalVisitors() {
        return totalVisitors;
    }

    public void setTotalVisitors(int totalVisitors) {
        this.totalVisitors = totalVisitors;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString() {
        return "Admin" + "attraction_count: " + attraction_count + '\n'+
                "totalVisitors: " + totalVisitors + '\n'+
                "totalRevenue: " + totalRevenue + '\n';
    }
}
