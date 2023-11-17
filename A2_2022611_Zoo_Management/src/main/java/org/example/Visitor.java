package org.example;

import java.util.ArrayList;

public class Visitor implements Ticketinfo {

    private String Name;
    private int age;
    private double Phone_no;
    private double balance;
    private String mail;
    private String password;
    private int type;
    public ArrayList<Ticket>tickets=new ArrayList<>();   // list of what tickets one has bought


    public Visitor(String name, int age, double phone_no, double balance, String mail, String password) {
        Name = name;
        this.age = age;
        Phone_no = phone_no;
        this.balance = balance;
        this.mail = mail;
        this.password = password;
        this.type=-1;  // initially all visitors will be without membership
    }
    public void addTickets(Ticket ticket){
        tickets.add(ticket);
    }
    public void visit_attraction(attraction_pair a){
        for (Ticket ticket : tickets) {   // for the tickets that the user has, if a valid ticket matches an attraction , invalidate it
            if (ticket.isValid() && ticket.attraction.equals(a)) {
                ticket.inValidate();
                System.out.println("Visited: "+ ticket.attraction.getName());
                break;
            }
        }
    }

    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type=type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPhone_no() {
        return Phone_no;
    }

    public void setPhone_no(double phone_no) {
        Phone_no = phone_no;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Visitor: " +
                "Name: '" + Name  + '\n' +
                "Age: " + age + '\n' +
                "Phone_no: " + Phone_no + '\n' +
                "Balance: " + balance + '\n' +
                "Mail: " + mail + '\n' +
                " Password: " + password + '\n';
    }
}
