package org.example;

public class Ticket {
//    public attraction_pair attraction;
    public Attraction attraction;
//    public Visitor visitor;
    public Boolean isValid;
//    public Ticket(attraction_pair attraction) {
    public Ticket(Attraction attraction){
        this.attraction = attraction;
        this.isValid = true;
    }
    public boolean isValid(){
        return isValid;
    }
    public void inValidate(){
        this.isValid=false;
    }
}
