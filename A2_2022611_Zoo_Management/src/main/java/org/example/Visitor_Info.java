package org.example;

import java.util.ArrayList;

public class Visitor_Info extends Admin{
    ArrayList<Visitor>visitor_info=new ArrayList<Visitor>();
    ArrayList<Feedback>feedback=new ArrayList<>();


    public void registerVisitor(String name, int age, double phone_no, double balance, String mail, String password){
        for(Visitor v:visitor_info){
            if(v.getMail()==mail){
                System.out.println("Visitor already exists");
                return;
            }
        }
        visitor_info.add(new Visitor(name, age, phone_no, balance, mail, password));
        System.out.println("registration successful");
    }

    public Visitor login_visitor( String mail, String password){
        for(Visitor v:visitor_info){
            if(v.getMail().equals(mail) && v.getPassword()==password){
                System.out.println("Successful login");
                return v;
            }
        }
//        System.out.println("Incorrect info try again ");
        return null;

    }
    public boolean buyTicket(Visitor v, attraction_pair a, Discounts d){
        int ticket_price= a.getPrice();
        if(d!=null){
            System.out.println("Applied discount CODE= ***" + d.getDiscount_code() + " ***");
            ticket_price-= (ticket_price* (d.getOffer()/100));
        }
        if(v.getType()==0 && v.getBalance()>=ticket_price){
            double current_balance=(double)(v.getBalance()- ticket_price);
            v.setBalance(current_balance);


            v.addTickets(new Ticket(a));
            a.increment_visitor_count();
            System.out.println("Successfully bought tickets");
            return true;
        }else{
            System.out.println("Cannot buy tickets");
            return false;
        }
    }
    public void useTicket(Visitor v, attraction_pair a) {
        v.visit_attraction(a);

    }
    public void add_feedback(Feedback f){
        feedback.add(f);
        System.out.println("Added your feedback ");
    }
    public void view_feedback(){
        for(Feedback f:feedback){
            System.out.println("Name : " + f.getName() + " said - " + f.getFeedback());
        }
    }

    public void get_ticket(Visitor v){

        for(Ticket t:v.tickets){
            if(t.isValid){

                System.out.println(t.attraction.getName());
            }
        }
    }
}
