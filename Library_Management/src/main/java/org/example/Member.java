package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Member {
    public double getmem_ID;
    public String getmem_Name;
    private String mem_Name;
    private double mem_ID;
    private int mem_age;
    private double fine;

    private double phonenumber;
    private List<Book> book_issue;
    private int issue;
    private List<Book> Available_books;

    public Member() {

    }

    public List<Book> getBook_issue() {
        return book_issue;
    }
    public List<Book> getAvailable_books() {
        return Available_books;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "Member{" +
                " mem_Name='" + mem_Name + '\'' +
                ", mem_ID=" + mem_ID +
                ", mem_age=" + mem_age +
                ", fine=" + fine +
                ", phonenumber=" + phonenumber +
                ", book_issue=" + book_issue +
                ", issue=" + issue + '\n'+
                " Available_books : " + Available_books + '\n'+
                " book : " + book +
                '}';
    }

    public Member(String a, int b, double c, double d, double ph) {
        this.mem_Name = a;
        this.mem_age = b;
        this.mem_ID = c;
        this.fine = d;
        this.phonenumber = ph;

    }

    public String getMem_Name() {
        return mem_Name;
    }

    public void setMem_Name(String mem_Name) {
        this.mem_Name = mem_Name;
    }

    public void setMem_ID(double mem_ID) {
        this.mem_ID = mem_ID;
    }

    public void setMem_age(int mem_age) {
        this.mem_age = mem_age;
    }

    public String getmem_Name() {
        return mem_Name;
    }

    public void listMyBooks(Member member, ArrayList<Book> booksList) {
        System.out.println("Books borrowed by " + member.getmem_Name() + ":");
        for (Book book : booksList) {
            if (book.getIssue() != 0 && book.getIssue() == member.issue) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println();
            }
        }
    }


    public void issueBook(Member member, int bookId, ArrayList<Book> booksList) {
        for (Book book : booksList) {
            if (getFine() > 0.0) {
                System.out.println("You have an outstanding penalty of $" + member.getFine() + ". Please clear your penalty before issuing a new book.");
                return;
            }
            System.out.println("Available Books: ");
            for (int i = 0; i < Available_books.size(); i++) {
                Book book1 = Available_books.get(i);
                System.out.println("Title: " + book1.getTitle() + "Author: " + book1.getAuthor() + "Copies available: " + book1.getNumCopies());
            }
            if (book.getBook_Id() == bookId) {
                if (book.isAvailable()) {
                    book.setIssue(member);
                    book.setNumCopies(book.getNumCopies() - 1);
                    System.out.println("Book '" + book.getTitle() + "' issued to " + member.getMem_Name());
//                    .add(book);
                } else {
                    System.out.println("Book '" + book.getTitle() + "' is not available for issuance.");
                }
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }
    Book book = new Book();

    public void returnBook() {
        Scanner input = new Scanner(System.in);
        if (book_issue.isEmpty()) {
            System.out.println("No books are currently borrowed by this member");
            return;
        }
        // Display of issued books along with their IDs
        System.out.println("Issued Books:");
        for (int i = 0; i < book_issue.size(); i++) {
            Book book = book_issue.get(i);
            System.out.println(i + 1 + " " + book.getTitle() + "by" + book.getAuthor());
        }
//          Take input for Book ID to be returned
        System.out.println("Enter Book_ID to return(1-" + book_issue.size() + "): ");
        int bookId_Return = input.nextInt();
        if (bookId_Return >= 1 && bookId_Return <= book_issue.size()) {
            Book book_Return = book_issue.remove(bookId_Return - 1);
            System.out.println("Book '" + book.getTitle() + "' returned successfully.");
        } else {
            System.out.println("Invalid Book ID. Please enter a valid book ID.");
        }
    }
    public void payFine(Member member){
        double currentFine = member.getFine();
        if (currentFine > 0) {
            System.out.println("Your current fine is $" + currentFine);
            System.out.print("Enter the amount to pay (or 0 to skip): $");
            if (fine>= 0) {
                if (fine <= currentFine) {
                    member.setFine(currentFine - fine);
                    System.out.println("Payment successful. Your remaining fine is $" + member.getFine());
                } else {
                    System.out.println("Invalid payment amount. Payment cannot exceed the fine amount.");
                }
            } else {
                System.out.println("Invalid payment amount. Payment must be a non-negative value.");
            }
        }
        else{
            System.out.println("You don't have any fines to pay.");
        }
    }

    public void listAvailableBooks(ArrayList<Book> books) {

    }

    public double getMem_Id() {
        return mem_ID;

    }
}



