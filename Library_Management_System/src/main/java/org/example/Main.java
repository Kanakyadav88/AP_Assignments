package org.example;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static ArrayList<Book> bookslist = new ArrayList<>();
    public static ArrayList<Member> memberslist = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Librarian librarian = new Librarian();
        Member member = new Member();
        boolean over = false;
        int func = 0;
        int i = 0;
        int j = 0;
        int bookid = 0;
        while(!over) {
            System.out.println("""
                    ---------------------------------
                    1.Enter as a librarian
                    2.Enter as a member
                    3.Exit
                    ---------------------------------
                    """);
            boolean lib_over = false;
            boolean mem_over = false;
            func = Integer.parseInt(scanner.nextLine());
            switch(func){
                case 1->{
                    while(!lib_over){
                        System.out.println("---------------------------------\n" +
                                "1.Register a member\n" +
                                "2.Remove a member\n" +
                                "3.Add a book\n" +
                                "4.Remove a book\n" +
                                "5.View all members along with their books and fines to be paid\n" +
                                "6.View all books\n" +
                                "7.Back\n" +
                                "---------------------------------\n");
                        i = Integer.parseInt(scanner.nextLine());
                        switch(i){
                            case 1 -> librarian.addmember();
                            case 2 -> {
                                System.out.println("Name: ");
                                String name = scanner.nextLine();
                                System.out.println("Mobile: ");
                                String mobile = scanner.nextLine();
                                librarian.removemember(name, mobile);
                            }
                            case 3 -> {
                                System.out.println("Name: ");
                                String name = scanner.nextLine();
                                System.out.println("Author: ");
                                String author = scanner.nextLine();
                                System.out.println("Number of Copies: ");
                                int copies = Integer.parseInt(scanner.nextLine());
                                for(int i1=0; i1 <copies; i1++){
                                    bookid++;
                                    librarian.addbook(name, author, bookid);
                                }
                                System.out.println("Book Added Successfully! ");
                            }
                            case 4 -> {
                                System.out.println("Id of book you want to remove: ");
                                int id = Integer.parseInt(scanner.nextLine());
                                librarian.removebook(id);
                            }
                            case 5 -> librarian.listmembers();
                            case 6 -> librarian.listbooks();
                            case 7 -> lib_over = true;
                            default -> System.out.println("Invalid Input");
                        }
                    }
                }
                case 2 ->{
                    System.out.println("Login \n Name:");
                    String name = scanner.nextLine();
                    System.out.println("Phone Number: ");
                    String phonenumber = scanner.nextLine();
                    if(member.memberExists(name, phonenumber)){
                        while(!mem_over) {
                            System.out.println("Welcome " + name + "Member ID: " + phonenumber);
                            System.out.println("""
                                    ---------------------------------
                                    1.List Available Books
                                    2.List My Books
                                    3.Issue book
                                    4.Return book
                                    5.Pay Fine
                                    6.Back
                                    ---------------------------------
                                    """);
                            j = Integer.parseInt(scanner.nextLine());
                            switch (j){
                                case 1 -> member.listAllBooks();
                                case 2 -> member.listMyBooks(name);
                                case 3 -> {
                                    System.out.println("ID of book you want to issue");
                                    int id = Integer.parseInt(scanner.nextLine());
                                    member.issueBook(name, id);
                                }
                                case 4 -> {
                                    member.listMyBooks(name);
                                    System.out.println("ID of book you want to return");
                                    int id = Integer.parseInt(scanner.nextLine());
                                    member.returnBook(name, id);
                                }
                                case 5 -> member.PayFine(name);
                                case 6 -> mem_over = true;
                                default -> System.out.println("Invalid Input");
                            }
                        }
                    }else{
                        System.out.println("Invalid login credentials");
                    }

                }
            }
        }
    }
}