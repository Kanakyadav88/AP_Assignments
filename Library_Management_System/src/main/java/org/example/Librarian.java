package org.example;

import java.util.Scanner;

import static org.example.Main.bookslist;
import static org.example.Main.memberslist;

public class Librarian {
    private int nextMemberID = 0;


    public  void addmember() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter mobile number: ");
        String mobileNumber = scanner.nextLine();
        nextMemberID++;

        // Create a new member with a unique memberID
        Member newMember = new Member(name, age, mobileNumber, nextMemberID);

        // Increment the nextMemberID for the next member

        // Add the new member to the ArrayList
        memberslist.add(newMember);

        System.out.println("Member successfully Registered with ID: " + nextMemberID);
    }





    // Create a method to remove a member by name and mobile number
    public void removemember(String name, String mobileNumber) {
        // Iterate through the membersList to find the member with the matching name and mobile number
        for (Member member : memberslist) {
            if (member.getName().equalsIgnoreCase(name) && member.getMobileNumber().equals(mobileNumber)) {
                // Remove the matching member
                memberslist.remove(member);
                System.out.println("Member removed successfully.");
                return; // Exit the loop once a member is removed
            }
        }

        // If no matching member is found, display a message
        System.out.println("Member not found.");
    }


    public void addbook(String name, String author, int bookid){
        Book book = new Book(name, author, bookid);
        bookslist.add(book);
    }

    public void removebook(int bookID) {
        // Iterate through the bookList to find the book with the matching bookID
        for (Book book : bookslist) {
            if (book.getBookid() == bookID) {
                // Remove the matching book
                bookslist.remove(book);
                System.out.println("Book removed successfully.");
                return; // Exit the loop once a book is removed
            }
        }

        // If no matching book is found, display a message
        System.out.println("Book not found.");
    }

    public void listmembers(){
        for (Member member : memberslist) {
            System.out.println("Member ID: " + member.getMemberID());
            System.out.println("Name: " + member.getName());
            System.out.println("Age: " + member.getAge());
            System.out.println("Mobile Number: " + member.getMobileNumber());
            System.out.println("Fine: " + member.getFine());
            System.out.println("Books: " + member.getMembersbooks().size()); // Assuming you want to print the number of books

            // You can also print the details of each book if needed
            for (Book book : member.getMembersbooks()) {
                System.out.println("Book ID: " + book.getBookid());
                System.out.println("Book Title: " + book.getName());
                System.out.println("Book Author: " + book.getAuthor());
            }

            System.out.println(); // Add a separator between members
        }

    }

    public void listbooks(){
        for (Book book : bookslist) {
            System.out.println("Book ID: " + book.getBookid());
            System.out.println("Book Name: " + book.getName());
            System.out.println("Author: " + book.getAuthor());
            System.out.println(); // Add a separator between books
        }

    }

}
