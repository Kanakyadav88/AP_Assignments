package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Events extends Zoo_Attraction{
    List<Discounts> discounts = new ArrayList<Discounts>();
    List<Animals>animals = new ArrayList<>();


    public Zoo_Attraction zooAttraction;

    public Events(Zoo_Attraction zooAttraction) {
        this.zooAttraction = zooAttraction;
    }

    //stores id, pair info and (1 or 0)
    // mapped to 1-> the attraction is open
    // mapped to 0-> attraction is closed
    public void swap(int attraction_number){
        HashMap<Integer, HashMap<attraction_pair, Integer>> event_map = zooAttraction.event_map;
        HashMap<attraction_pair, Integer>nestedMap=event_map.get(attraction_number);
        for (attraction_pair pair : nestedMap.keySet()) {
            Integer currentState = nestedMap.get(pair);

            // Swap the state
            if (currentState == 1) {
                nestedMap.put(pair, 0);
            } else if (currentState == 0) {
                nestedMap.put(pair, 1);
            }
        }


    }
    public void view_event_state(){
        System.out.println("----Open events-----");
        HashMap<Integer, HashMap<attraction_pair, Integer>> event_map = zooAttraction.event_map;
        for(Integer i:event_map.keySet()){
            HashMap<attraction_pair, Integer> nestedMap = event_map.get(i);
            for(attraction_pair p:nestedMap.keySet()){
                Integer status = nestedMap.get(p); //  it can be 0 or 1 for open or closed
                int count = i+1;
                if(status==1){

                    System.out.println(" *** OPEN ***    "+ count +": " + p.getName()+ " -> Price  =  "+ p.getPrice() + " rs" );
                }else{
                    System.out.println(" *** CLOSED ***     "+count +": " + p.getName()+ " -> Price  =  "+ p.getPrice() + " rs" );
                }
            }
        }
    }
    public void view_attraction_prices(){   // displays number of the attraction, and its name, which the visitor can view
//        event_map in the Events class is essentially a reference to the event_map in the provided Zoo_Attraction instance.
        HashMap<Integer, HashMap<attraction_pair, Integer>> event_map = zooAttraction.event_map;
//        System.out.println("size of events"+event_map.size());
        for(Integer i:event_map.keySet()){
            System.out.println();
            HashMap<attraction_pair, Integer> nestedMap = event_map.get(i);
            for(attraction_pair p:nestedMap.keySet()){

                System.out.println(i+1 +": " + p.getName()+ " -> Price  =  "+ p.getPrice() + " rs" );
            }
        }
    }
    public void update_price(int attraction_number, int new_price) {
//        event_map in the Events class is essentially a reference to the event_map in the provided Zoo_Attraction instance
        HashMap<Integer, HashMap<attraction_pair, Integer>> event_map = zooAttraction.event_map;
        if (attraction_number < 0 || attraction_number >= event_map.size()) {
            System.out.println("Invalid attraction number.");
            return;
        }
        if (new_price < 0) {
            System.out.println("Price cannot be negative.");
            return;
        }
        HashMap<attraction_pair, Integer> nestedMap = event_map.get(attraction_number);

        if (nestedMap != null) {
            for (attraction_pair pair : nestedMap.keySet()) {
                pair.setPrice(new_price);
            }
        }
    }


    public void addDiscount(Discounts d) {
        discounts.add(d);
    }
    public void deleteDiscount(String code) {
        discounts.removeIf(discount -> discount.getDiscount_code().equals(code));
    }

    public void view_eligible_discounts(Visitor v){
        for(Discounts d:discounts){
            if(d.isEligible(v)){
                if(d.getFlag()==0){

                    System.out.println("DISCOUNT CODE: ***"+ d.getDiscount_code()+" ***   " + d.getOffer() + " % off for ages less than- "+ d.getAge());
                }else{
                    System.out.println("DISCOUNT CODE: ***"+ d.getDiscount_code()+" ***   " + d.getOffer() + " % off for ages more than- "+ d.getAge());

                }
            }
        }
    }
    public void view_discounts_admin(){   // list of ALL discounts
        for(Discounts d:discounts){
                if(d.getFlag()==0){

                    System.out.println("DISCOUNT CODE: ***"+ d.getDiscount_code()+" ***   " + d.getOffer() + " % off for ages less than- "+ d.getAge());
                }else{
                    System.out.println("DISCOUNT CODE: ***"+ d.getDiscount_code()+" ***   " + d.getOffer() + " % off for ages more than- "+ d.getAge());

                }

        }
    }
    public Discounts getDiscount(String code){
        for(Discounts d:discounts){
            if(d.getDiscount_code().equals(code)){
                return d;
            }
        }
        return null;
    }

    public void add_animals(Animals a){
        animals.add(a);
    }
    public Animals remove_animals(String name){

        for(Animals a:animals){
            if(a.getName().equals(name)){
                animals.remove(a);
                return a;
            }
        }
        return null;
    }
    public Animals update_animal(String name, Animals updated){
        for(Animals a:animals){
            if(Objects.equals(name, a.getName())){
                a.setName(updated.getName());
                a.setAbout(updated.getAbout());
                a.setNoise(updated.getNoise());
                a.setType(updated.getType());
                return a;
            }
        }
        return null;
    }
    public void show_animals(){
        for(Animals a:animals){
            System.out.println(a.getName());
        }
    }
    public void visit_animal_sound(String name){
        for(Animals a:animals){
            if(a.getName().equals(name)){
                System.out.println(a.getNoise()+ " !!!!!");
            }
        }
    }
    public boolean fetch_animal_of_type(String type){
        boolean present=false;
        for(Animals a:animals){
            if(a.getType().equals(type)){
                present=true;
                System.out.println( a.getName());
            }
        }
        return present;
    }
    public void visit_animal_info(String name){
        for(Animals a:animals){
            if(a.getName().equals(name)){
                System.out.println(" About "+ name + ":  " + a.getAbout());
            }
        }
    }
}
