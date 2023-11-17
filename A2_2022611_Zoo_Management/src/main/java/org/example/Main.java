package org.example;

import java.lang.reflect.Array;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    // Define the static final admin username and password
    private static final String ADMIN_USERNAME = "admin";
    private ArrayList<Feedback> feedbacks=new ArrayList<>();
    private static final String ADMIN_PASSWORD = "admin123";
    public static void main(String[] args) {
        ArrayList<String> feedbf=new ArrayList<>();
        Zoo_Attraction z = new Zoo_Attraction();
//        Animals a=new Animals();
        Events e = new Events(z);
//        SpecialDeals specialDeals = new SpecialDeals();

        ArrayList<SpecialDeals> SD = new ArrayList<>();
        SD.add(new SpecialDeals(2, 15));
        SD.add(new SpecialDeals(3, 30));
        Visitor_Info v=new Visitor_Info();
        boolean random = true;
        int attraction_count=0;
        int func = 0;
        Scanner read = new Scanner(System.in);
        while (random) {
            System.out.println("""
                    ------------------------------
                     Welcome to ZOOtopia!
                     1. Enter as Admin
                     2. Enter as a Visitor
                     3. View Special Deals 
                     4. Exit
                    ------------------------------   
                             """);
            func = Integer.parseInt(read.nextLine());
            switch (func) {
                case 1 -> {

                    System.out.print("Enter Admin Username: ");
                    String adminUsername = read.nextLine();
                    System.out.print("Enter Admin Password: ");
                    String adminPassword = read.nextLine();

                    if (adminUsername.equals(ADMIN_USERNAME) && adminPassword.equals(ADMIN_PASSWORD)) {
                        System.out.println("Logged in as Admin \n");
                        boolean admin_list=true;
                        while (admin_list) {
                            System.out.println("""
                                ----------------------------
                                Admin Menu:                            
                                1. Manage Attractions
                                2. Manage Animals
                                3. Schedule Events
                                4. Set Discounts
                                5. Set Special Deal
                                6. View Visitor Stats
                                7. View Feedback
                                8. Exit                            
                                 ----------------------------
                                """);
                            int i = Integer.parseInt(read.nextLine());
                            switch (i) {
                                case 1 -> {

                                    attraction:
                                    while (true) {
                                        System.out.println("""
                                            ----------------------------
                                            Manage Attractions:
                                                                                        
                                            1. Add Attraction
                                            2. View Attractions
                                            3. Modify Attraction
                                            4. Remove Attraction
                                            5. Exit
                                                        
                                             ----------------------------
                                                                                       
                                            """);
                                        int j = Integer.parseInt(read.nextLine());
                                        switch (j) {
                                            case 1 -> {
//                                            System.out.println("Add Attractions: \n");

                                                System.out.println("Enter Attraction Name: \n");
                                                String name = read.nextLine();
                                                System.out.println("Enter Attraction Description: \n");
                                                String des = read.nextLine();

                                                z.add_attraction(name, des);

                                                System.out.println("Attraction Added successfully." + '\n');
                                            }

                                            case 2 -> {
                                                System.out.println("View Attraction\n");
//                                            Zoo_Attraction z=new Zoo_Attraction();
                                                z.view_attraction_visitor();
                                            }
                                            case 3 -> {
                                                System.out.println("Modify Attractions:\n");
//                                            Zoo_Attraction z=new Zoo_Attraction();
                                                z.modify_attraction();
                                            }
                                            case 4 -> {
                                                System.out.println("Remove Attractions: \n");
//                                            Zoo_Attraction z=new Zoo_Attraction();
                                                z.remove_attraction();
                                            }
                                            case 5 -> {
                                                System.out.println("Exit\n");
                                                break attraction;
                                            }
                                            default -> throw new IllegalStateException("Unexpected value: " + func);
                                        }
                                    }
                                }
                                case 2 -> {
                                    System.out.println("Manage Animals: \n");
                                    animals:
                                    while (true) {
                                        System.out.println("""
                                            ----------------------------
                                            Manage Animals:
                                                   
                                            1. Add Animal
                                            2. Update Animal Details
                                            3. Remove Animal
                                            4. Exit
                                                       
                                            ----------------------------
                                                                                       
                                            """);
                                        int k = Integer.parseInt(read.nextLine());

                                        switch (k) {
                                            case 1 -> {
                                                System.out.println("""
                                            ----------------------------
                                            Add Animals:
                                                   
                                            1. Mammals
                                            2. Amphibian
                                            3. Reptile
                                               
                                            ----------------------------                                  
                                            """);
                                                String animal_type = (read.nextLine());
//                                            if(!animal_type.equals("mammals") && !animal_type.equals("amphibian") && !animal_type.equals("reptile")){
//                                                System.out.println("incorrct input");
//                                                break;
//                                            }
                                                System.out.println("Enter Animal Name: \n");
                                                String animal_name = read.nextLine();
                                                System.out.println("Enter animal sound");
                                                String sound = read.nextLine();
                                                System.out.println("enter animal info ");
                                                String info = read.nextLine();
                                                e.add_animals(new Animals(animal_name,animal_type, sound, info ));
                                                System.out.printf("Enter Animal Name: %s\nEnter animal type: %s\nAnimal added to Zoo \n%n", animal_name, animal_type);

                                            }
                                            case 2 -> {
//                                                System.out.println("Which animal do you want to update?");
                                                System.out.println("Which animal do you want to update?");
                                                e.show_animals();
                                                System.out.println("Enter Animal Name to be updated: ");
                                                String animal_name = read.nextLine();
                                                System.out.println(": animal_name = " + animal_name);

                                                System.out.println("Enter Animal Type: ");
                                                String animal_type = read.nextLine();
                                                System.out.println("Enter animal sound: ");
                                                String sound = read.nextLine();
                                                System.out.println("Enter animal info: ");
                                                String info = read.nextLine();

                                                try {
                                                    // Validate user input
                                                    if (animal_name.isEmpty() || animal_type.isEmpty() || sound.isEmpty() || info.isEmpty()) {
                                                        throw new IllegalArgumentException("Input cannot be empty.");
                                                    }

                                                    // Attempt to update the animal
                                                    if (e.update_animal(animal_name, new Animals(animal_name, animal_type, sound, info)) == null) {
                                                        System.out.println("Cannot update animal");
                                                    } else {

                                                        e.update_animal(animal_name, new Animals(animal_name, animal_type, sound, info));
                                                            System.out.println("Updated successfully");
                                                    }
                                                } catch (IllegalArgumentException x) {
                                                    System.out.println("Error: " + x.getMessage());
                                                } catch (Exception x) {
                                                    System.out.println("An error occurred while updating the animal.");
                                                }

                                            }
                                            case 3 -> {
                                                e.show_animals();
                                                System.out.println("""
                                                        ----------------------------
                                                        Which animal do you want to remove?                                    
                                                        """);
                                                String animal_name = (read.nextLine()).toLowerCase();
                                                if (animal_name.isEmpty()) {
                                                    System.out.println("Animal name cannot be empty.");
                                                } else {
                                                    if (e.remove_animals(animal_name) == null) {
                                                        System.out.println("Could not remove animal. Animal not found.");
                                                    } else {
                                                        System.out.println("Animal removed successfully.");
                                                    }
                                                }
                                            }
                                            case 4 -> {
                                                break animals;
                                            }
                                            default -> throw new IllegalStateException("Unexpected value: " + func);
                                        }
                                    }
                                }
                                case 3 -> {
                                    modification:while (true){
                                        System.out.println("""
                                            ----------------------------
                                            Select what modifications to make:     
                                            1. Change price of attraction
                                            2. Swap open/close for an event
                                            3. Exit
                                            ----------------------------
                                                                                       
                                            """);
                                        int l = Integer.parseInt(read.nextLine());
                                        switch (l) {
                                            case 1 -> {   // change prices
                                                e.view_attraction_prices();  // asks attraction number
                                                System.out.println("Enter the attraction price to change");
                                                int choice = Integer.parseInt(read.nextLine());
                                                System.out.println("Enter the updated price");
                                                int new_price= Integer.parseInt(read.nextLine());
                                                e.update_price(choice-1, new_price);
                                            }

                                            case 2-> {   // swap event closed or open
                                                e.view_event_state();
                                                System.out.println("Enter the index of attraction you want to swap for open/closed");
                                                int choice = Integer.parseInt(read.nextLine());
                                                if(choice>z.event_map.size()){
                                                    System.out.println("incorrect input");
                                                    break;
                                                }
                                                e.swap(choice-1);

                                            }
                                            case 3->{
                                                break modification;
                                            }
                                        }
                                    }
                                }
                                case 4 -> {
                                    dis:while (true) {
                                        System.out.println("""
                                            ----------------------------
                                            Set Discounts:     
                                            1. Add Discount
                                            2. Modify Discount
                                            3. Remove Discount
                                            4. Exit      
                                            ----------------------------                                        
                                            """);
                                        int l = Integer.parseInt(read.nextLine());
                                        switch (l) {
                                            case 1 -> {
                                                System.out.println("Enter Discount Category flag: (0 for upper age limit and 1 for lower age limit)" );
                                                int flag = Integer.parseInt(read.nextLine());
                                                int age=0;
                                                if(flag==1){
                                                    System.out.println("Discount above what age");
                                                    age = Integer.parseInt(read.nextLine());
                                                }else if (flag==0){
                                                    System.out.println("Discount under what age");
                                                    age = Integer.parseInt(read.nextLine());
                                                }else{
                                                    System.out.println("incorrect flag");
                                                    break;
                                                }
                                                System.out.println("Enter Discount Offer Percentage: \n");
                                                int off = Integer.parseInt(read.nextLine());
                                                System.out.println("Enter discount code ");
                                                String code = read.nextLine().toLowerCase();
                                                e.addDiscount(new Discounts(code,flag,age,off));
                                                System.out.println("Discount added successfully.\n");
                                            }
                                            case 2 -> {
                                                System.out.println("Modify discount: \n");
                                                e.view_discounts_admin();
                                                System.out.println("Enter code of discount to modify");
                                                String code= read.nextLine().toLowerCase();
                                                Discounts modi = e.getDiscount(code);
                                                if(modi!=null){
                                                    System.out.println("Enter Discount Category flag: (0 for upper age limit and 1 for lower age limit)" );
                                                    int flag = Integer.parseInt(read.nextLine());
                                                    int age=0;
                                                    if(flag==1){
                                                        System.out.println("Discount above what age");
                                                        age = Integer.parseInt(read.nextLine());
                                                    }else if (flag==0){
                                                        System.out.println("Discount under what age");
                                                        age = Integer.parseInt(read.nextLine());
                                                    }else{
                                                        System.out.println("incorrect flag");
                                                        break;
                                                    }
                                                    System.out.println("Enter Discount Offer Percentage: \n");
                                                    int off = Integer.parseInt(read.nextLine());
                                                    System.out.println("Enter discount code ");
                                                    String discount_code = read.nextLine().toLowerCase();
                                                    modi.setAge(age);
                                                    modi.setFlag(flag);
                                                    modi.setOffer(off);
                                                    modi.setDiscount_code(discount_code);
                                                    System.out.println("Discount successfully modified");
                                                }else{
                                                    System.out.println("Invalid code");

                                                }
                                            }
                                            case 3 -> {
                                                System.out.println("Remove Discount: \n");
                                                e.view_discounts_admin();
                                                System.out.println("Enter code of discount to remove");
                                                String code= read.nextLine();
                                                if(e.getDiscount(code)!=null){
                                                    e.deleteDiscount(code);
                                                }else{
                                                    System.out.println("incorrect code");

                                                }

                                            }
                                            case 4 -> {
                                                System.out.println("Exit!! \n");
                                                break dis;
                                            }
                                            default -> throw new IllegalStateException("Unexpected value: " + func);
                                        }
                                    }
                                }
                                case 5 -> {
                                    System.out.println("Set Special deals: \n");
                                    System.out.println("1. View Special Deals\n2.Add New Special Deal");
                                    System.out.println("Enter choice: ");
                                    Scanner new_ = new Scanner(System.in);
                                    int kan = new_.nextInt();

                                    if (kan==1) {
                                        for (SpecialDeals SD_ : SD) {
                                            System.out.println("Number of tickets, %discount");
                                            System.out.println(SD_.getNumberOfTickets() + ", " + SD_.getPercentageDiscount() + "%");
                                        }
                                    }
                                    else {

                                        System.out.println("Enter number of tickets");
                                        int dog = new_.nextInt();
                                        System.out.println("Enter discount");
                                        int cat = new_.nextInt();

                                        SD.add(new SpecialDeals(dog, cat));

                                    }

                                }
                                case 6 -> {
                                    System.out.println("Visitor Statistics ");
                                }
                                case 7 -> {
                                    v.view_feedback();
                                }

                                case 8 -> {
                                    System.out.println("Logged Out!!");
                                    admin_list=false;
                                }
                                default -> throw new IllegalStateException("Unexpected value: " + func);
                            }
                        }
                    } else {
                        System.out.println("Incorrect admin login. Please try again.");
                    }
                    break;
                }
                case 2 -> {
                    visitor:while (true) {
                        System.out.println("Enter as visitor\n" +
                                "-------------------------------------- \n" +
                                "1. Register\n" +
                                "2. Login\n" +
                                "3. Cancel\n"+
                                "---------------------------------------");
                        System.out.println("enter you choice \n");
                        int m = Integer.parseInt(read.nextLine());
                        switch (m) {
                            case 1 -> {
                                System.out.println("Enter Visitor Name: " );
                                String name = read.nextLine();
                                System.out.println("Enter Visitor Age: " );
                                int age = Integer.parseInt(read.nextLine());
                                System.out.println("Enter Visitor Phone no.: " );
                                double phone_no = Double.parseDouble(read.nextLine());
                                System.out.println("Enter Visitor Balance: " );
                                int bal = Integer.parseInt(read.nextLine());
                                System.out.println("Enter Visitor Email: " );
                                String email = read.nextLine();
                                System.out.println("Enter numerical Password: " );
                                String password = read.nextLine();
                                v.registerVisitor(name, age, phone_no, bal, email, password);
//
                            }
                            case 2 -> {
                                System.out.println("Enter Visitor Email: " );
                                String email = read.nextLine();
                                System.out.println("Enter visitor Password: " );
                                String password = read.nextLine();
                                Visitor current = v.login_visitor(email, password);
                                if (current == null) {
                                    System.out.println("Incorrect login. Please try again.");
                                } else {
                                    System.out.println("Login Successfully\n");
                                }
                                vis:while (true) {
                                    System.out.println("""
                                            ----------------------------
                                            Visitor Menu:
                                                                                        
                                            1. Explore the Zoo
                                            2. Buy Membership
                                            3. Buy Tickets
                                            4. View Discounts
                                            5. View Special Deals
                                            6. Visit Animals
                                            7. Visit Attractions
                                            8. Leave Feedback
                                            9. Log Out                                 
                                            ----------------------------
                                            """);
                                    int n = Integer.parseInt(read.nextLine());
                                    switch (n) {
                                        case 1 -> {
                                            while (true) {
                                                System.out.println("""
                                                        ----------------------------
                                                        Explore the Zoo:
                                                        1. View Attractions
                                                        2. View Animals
                                                        3. Exit                           
                                                        ----------------------------
                                                        """);
                                                int o = Integer.parseInt(read.nextLine());
                                                switch (o) {
                                                    case 1 -> {
                                                        System.out.println("Here are the list of attractions you can visit later " +
                                                                "Attractions in the Zoo:\n" +
                                                                "1. Jungle Safari\n" +
                                                                "2. Botanical Garden\n" +
                                                                "3. Dinosaur Show\n");
                                                        z.view_attraction_visitor();
                                                        int p = Integer.parseInt(read.nextLine());

                                                        if (p > z.attraction_map.size()) {
                                                            System.out.println("Error wrong input");
                                                        } else {
                                                            z.attraction_map.get(p - 1).getDescription();
                                                        }
                                                    }
                                                    case 2 -> {
                                                        System.out.println("Here are the list of animals in the zoo that you can visit later\n");
                                                        e.show_animals();
                                                    }
                                                    case 3 -> {
                                                        break;
                                                    }
                                                    default -> throw new IllegalStateException("Unexpected value: " + func);
                                                }
                                            }

                                        }
                                        case 2 -> {
                                            buy_membership:while (true) {
                                                System.out.println("""
                                                        Buy Membership: 
                                                        ---------------------------------
                                                        1.Basic Membership (₹20)
                                                        2.Premium Membership (₹50)
                                                        3.Exit
                                                        ---------------------------------
                                                        """);
                                                int q = Integer.parseInt(read.nextLine());
                                                switch (q) {
                                                    case 1 -> {
                                                        current.setType(0);
                                                        double new_balance = (double)(current.getBalance()-20);
                                                        current.setBalance(new_balance);
                                                    }
                                                    case 2 -> {
                                                        current.setType(1); // premium membership
                                                        double new_balance = (double)(current.getBalance()-50);
                                                        current.setBalance(new_balance);
                                                        int r = Integer.parseInt(read.nextLine());
                                                        e.view_eligible_discounts(current);
                                                        System.out.println("Enter discount code to apply ");
                                                        String input = read.nextLine().toLowerCase();
                                                        Discounts applied = e.getDiscount(input);  // get the discount from the code
                                                        attraction_pair ap= z.getAttraction(r-1);
                                                    }
                                                    case 3->{
                                                        break buy_membership;
                                                    }
                                                }
                                                System.out.println("Basic Membership purchased successfully. Your balance is now " +current.getBalance());
                                            }

                                        }
                                        case 3 -> {
                                                System.out.println(
                                                        "---------------------------------------------------" + "\n" +
                                                        "Select an Attraction to Buy a Ticket:\n" +
                                                                "1. Jungle Safari (₹10)" + '\n' +
                                                                "2. Botanical Garden (₹15)" + '\n'+
                                                                "3. Dinosaur Show (₹12)" +'\n'
                                                    +
                                                                "---------------------------------------------------------");
                                                // here show all the attractions that are OPEN right now
                                                z.view_open_attraction();
                                                System.out.println("enter you choice");
                                                int r = Integer.parseInt(read.nextLine());

                                                // show discounts here
                                                System.out.println(" Available discounts : ");

                                                e.view_eligible_discounts(current);
                                                System.out.println("Enter discount code to apply ");
                                                String input = read.nextLine().toLowerCase();
                                                Discounts applied = e.getDiscount(input);  // get the discount from the code
                                                attraction_pair ap= z.getAttraction(r-1);
                                                if(!v.buyTicket(current, ap, applied)){
                                                    break;
                                                }
                                        }
                                        case 4->{
                                            System.out.println("Available discounts for you: " +
                                                    "View Discounts:\n" +
                                                    "1. Minor (10% discount) - MINOR10\n" +
                                                    "2. Senior Citizen (20% discount) - SENIOR20");
                                            e.view_eligible_discounts(current);
                                        }
                                        case 5->{
                                            System.out.println("View Special Deals: " +
                                                    "1. Buy 2 tickets and get 15% off\n" +
                                                    "2. Buy 3 tickets and get 30% off");
                                        }
                                        case 6->{
                                            System.out.println("""
                                            ----------------------------
                                            1. Mammals
                                            2. Amphibian
                                            3. Reptile
                                            ----------------------------
                                            Which type of animal do you want to visit? Enter numeric option                                    
                                            """);
                                            int animal_type = Integer.parseInt(read.nextLine());
                                            switch (animal_type) {
                                                case 1:
                                                    if (!e.fetch_animal_of_type("mammals")) {
                                                        System.out.println("No animals found");
                                                        break;
                                                    }
                                                    break;
                                                case 2:
                                                    if (!e.fetch_animal_of_type("amphibian")) {
                                                        System.out.println("No amphibians found");
                                                        break;
                                                    }
                                                    break;
                                                case 3:
                                                    if (!e.fetch_animal_of_type("reptile")) {
                                                        System.out.println("No reptiles found");
                                                        break;
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("incorrect input");
                                                    break;
                                            }
                                            System.out.println("Enter which animal you would like to go to");
                                            String animal_name = (read.nextLine()).toLowerCase(Locale.ROOT);
                                            System.out.println("""
                                            ----------------------------
                                            Do you want to    
                                            1. Visit
                                            2. Read
                                            ----------------------------
                                            Select your choice                                   
                                            """);
                                            int to_do = Integer.parseInt(read.nextLine());
                                            switch (to_do) {
                                                case 1:
                                                    e.visit_animal_sound(animal_name);
                                                    break;
                                                case 2:
                                                    e.visit_animal_info(animal_name);
                                                    break;
                                                default:
                                                    System.out.println("incorrect option");
                                                    break;
                                            }
                                            break;
                                        }
                                        case 7->{
                                            System.out.println("Visit Attractions:\n" +
                                                    "Select an Attraction to Visit:\n" +
                                                    "1. Jungle Safari\n" +
                                                    "2. Botanical Garden\n" +
                                                    "3. Dinosaur Show\n" +
                                                    "4. Exit");
                                            System.out.println("You have a ticket for the following attractions");
                                            v.get_ticket(current);
                                            System.out.println("Enter the name of the attraction you want to visit");
                                            String at = read.nextLine();
                                            // find out the attraction pair from its name
                                            attraction_pair ap=z.getAttraction_from_name(at);
                                            if(ap!=null){
                                                v.useTicket(current, ap);
                                            }else{
                                                System.out.println("Incorrect input");
                                            }
                                        }
                                        case 8->{
//                                            System.out.println("Drop your feedback here");
                                            System.out.println("Enter your name: ");
                                            String name = read.nextLine();
                                            System.out.println("Enter feedback ");
                                            String feedback= read.nextLine();
                                            v.add_feedback(new Feedback(name, feedback));

                                        }
                                        case 9->{
                                            System.out.println("Exit");
                                            break vis;
                                        }
                                    }
                                }
                            }
                            case 3->{
                                break visitor;
                            }
                            default -> throw new IllegalStateException("Unexpected value: " + func);

                        }
                    }
                }
                case 3 -> {
                    System.out.println("Special Discount: \n");
                    System.out.println("The special discount are: ");
                    for (SpecialDeals x:SD){
                        System.out.println("Number of tickets: "+x.getNumberOfTickets()+" "+"Discount percentage: "+x.getPercentageDiscount());
                    }
                }
                case 4 -> {
                    random = false;
                }
                default -> throw new IllegalStateException("Unexpected value: " + func);
            }
        }
    }
}