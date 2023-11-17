package org.example;

public class attraction_pair implements Attraction{   // stores info of the attrcation
    private String name;
    private String description;
    private int price;
    private int ticket_sold;
    public attraction_pair(String name, String description) {
        this.name = name;
        this.description = description;
        this.price=0;
        this.ticket_sold=0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTicket_sold() {
        return ticket_sold;
    }

    public void setTicket_sold(int ticket_sold) {
        this.ticket_sold = ticket_sold;
    }

    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public String getName(){
//        System.out.println(description);
        return name;
    }
    public String getDescription(){
//        System.out.println(description);
        return description;
    }
    public void increment_visitor_count(){
        this.ticket_sold++;
    }

}
