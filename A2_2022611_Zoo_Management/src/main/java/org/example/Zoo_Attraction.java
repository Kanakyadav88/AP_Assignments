package org.example;


import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;

public class Zoo_Attraction extends Admin{
    HashMap<Integer, HashMap<attraction_pair,Integer>>event_map=new HashMap<>();  // have to maintain for events section (initially all attractions open and at 0 cost)

    HashMap<Integer, attraction_pair> attraction_map=new HashMap<>();
    public void add_attraction(String name, String desc){

        attraction_map.put(attraction_count, new attraction_pair(name, desc));

        // now to put in events map
        attraction_pair ap=new attraction_pair(name, desc);
        HashMap<attraction_pair , Integer> nestedMap = new HashMap<>();
        nestedMap.put(ap, 1); // 1 for this attraction means its open to all now


        event_map.put(attraction_count, nestedMap);
        System.out.println("Events map is now " + event_map.size());
//        System.out.println(attraction_map.size());
        attraction_count++;

    }

    public void remove_attraction(){
        view_attraction_visitor();
        System.out.println("Which attraction do you want to delete?");
        Scanner s=new Scanner(System.in);
        int i = Integer.parseInt(s.nextLine());
        attraction_map.remove(i-1);
        System.out.println("Removed Successfully");
        event_map.remove(i-1);
        attraction_count--;
    }
    public void modify_attraction(){
        view_attraction_visitor();
        System.out.println("Which attraction do you want to modify?");
        Scanner s=new Scanner(System.in);
        int i = Integer.parseInt(s.nextLine());
        // ask for name and desc again
        System.out.println("Enter Attractions name: \n");
        String ani = s.nextLine();
        System.out.println("Enter Attraction desc:  \n");
        String des = s.nextLine();
        attraction_map.put(i-1, new attraction_pair(ani, des));

        // now to update the events map
        HashMap<attraction_pair, Integer> nestedMap=new HashMap<>();
        nestedMap.put(new attraction_pair(ani, des), 1);
        event_map.put(i-1, nestedMap);

    }

    public void view_attraction_visitor(){   // displays number of the attraction, and its name, which the visitor can view
        for(Integer i:attraction_map.keySet()){
            System.out.println(i+1 +": " + attraction_map.get(i).getName() );
        }
    }
    public void view_open_attraction(){   // view all the open attractions to the visitor
        System.out.println("----Open events-----");
        HashMap<Integer, HashMap<attraction_pair, Integer>> event_map = this.event_map;
        for(Integer i:event_map.keySet()){
            HashMap<attraction_pair, Integer> nestedMap = event_map.get(i);
            for(attraction_pair p:nestedMap.keySet()){
                Integer status = nestedMap.get(p); //  it can be 0 or 1 for open or closed
                int count = i+1;
                if(status==1){

                    System.out.println(" *** OPEN ***    "+ count +": " + p.getName()+ " -> Price  =  "+ p.getPrice() + " rs" );
                }
            }
        }
    }

    public attraction_pair getAttraction(int index){
        HashMap<attraction_pair, Integer> nestedMap = event_map.get(index);

        if (nestedMap == null) {
            // No attraction exists for the given ID
            System.out.println("Incorrect input");
            return null;
        }

        // Just return the first (and probably only) attraction_pair from the nestedMap
        for (attraction_pair pair : nestedMap.keySet()) {
            return pair;
        }
        return null;

    }
    public attraction_pair getAttraction_from_name(String name ){

        for (HashMap<attraction_pair, Integer> innerMap : event_map.values()) {
            for (attraction_pair attraction : innerMap.keySet()) {
                if (attraction.getName().equals(name)) {
                    return attraction;
                }
            }
        }
        return null;
    }
}
