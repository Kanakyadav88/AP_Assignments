package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import static org.example.Main.bookslist;
import static org.example.Main.memberslist;

public class Member {
    private String name;
    private int age;
    private String mobileNumber;
    private int memberID;

    private int fine = 0;
    private ArrayList<Book> membersbooks = new ArrayList<>();

    public boolean memberExists(String name, String phoneNumber) {
        for (Member member : memberslist) {
            if (member.getName().equalsIgnoreCase(name) && member.getMobileNumber().equals(phoneNumber)) {
                return true; // Member with matching details found
            }
        }
        return false; // Member with matching details not found
    }
    public void listAllBooks() {
        ArrayList<Book> availableBooks = new ArrayList<>();

        // Iterate through the booksList
        for (Book book : bookslist) {
            boolean isIssued = false;

            // Check if the book has been issued by any member
            for (Member member : memberslist) {
                if (member.getMembersbooks().contains(book)) {
                    isIssued = true;
                    break;
                }
            }

            // If the book has not been issued, add it to the availableBooks list
            if (!isIssued) {
                availableBooks.add(book);
            }
        }

        // Print the list of available books
        if (availableBooks.isEmpty()) {
            System.out.println("No books are available.");
        } else {
            System.out.println("Available Books:");
            for (Book book : availableBooks) {
                System.out.println("Book ID: " + book.getBookid());
                System.out.println("Book Name: " + book.getName());
                System.out.println("Author: " + book.getAuthor());
                System.out.println();
            }
        }
    }

    public void listMyBooks(String memberName) {
        boolean memberFound = false;

        // Iterate through the membersList
        for (Member member : memberslist) {
            if (member.getName().equalsIgnoreCase(memberName)) {
                memberFound = true;

                ArrayList<Book> issuedBooks = member.getMembersbooks();

                // Print the list of books issued by the member
                if (issuedBooks.isEmpty()) {
                    System.out.println("No books issued by " + memberName);
                } else {
                    System.out.println(memberName + "'s Issued Books:");
                    for (Book book : issuedBooks) {
                        System.out.println("Book ID: " + book.getBookid());
                        System.out.println("Book Name: " + book.getName());
                        System.out.println("Author: " + book.getAuthor());
                        System.out.println();
                    }
                }

                break; // Exit the loop once the member is found
            }
        }

        if (!memberFound) {
            System.out.println("Member not found.");
        }
    }

    private static Timer timer = new Timer(true);
    private static Map<Integer, Long> bookIssueTimes = new HashMap<>();

    // Other class members and methods...

    public void issueBook(String name, int bookID) {
        Member member = findMember(name);
        int memID = member.getMemberID();
        Book book = findBook(bookID);

        if (member == null) {
            System.out.println("Member not found.");
        } else if (book == null) {
            System.out.println("Book not found.");
        } else if (member.getMembersbooks().size() >= 2) {
            System.out.println("You can't issue more than two books at a time.");
        } else if (bookIssueTimes.containsKey(memID)) {
            long currentTime = System.currentTimeMillis();
            long lastIssueTime = bookIssueTimes.get(memID);

            if (currentTime - lastIssueTime < 10000) {
                System.out.println("You can't issue another book until 10 seconds have passed.");
            } else {
                member.getMembersbooks().add(book);
                bookIssueTimes.put(memID, currentTime);

                System.out.println("Book issued successfully.");
            }
        } else {
            member.getMembersbooks().add(book);
            bookIssueTimes.put(memID, System.currentTimeMillis());

            System.out.println("Book issued successfully.");
        }
    }
    private Member findMember(String name) {
        for (Member member : memberslist) {
            if (member.getName().equals(memberID)) {
                return member;
            }
        }
        return null;
    }

    private Book findBook(int bookID) {
        for (Book book : bookslist) {
            if (book.getBookid() == bookID) {
                return book;
            }
        }
        return null;
    }

    public boolean returnBook(String name, int bookID) {
        Member member = findMember(name);
        Book book = findBook(bookID);

        if (member == null) {
            System.out.println("Member not found.");
            return false;
        }

        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }

        if (!member.getMembersbooks().contains(book)) {
            System.out.println("The book with ID " + bookID + " is not issued to " + member.getName() + ".");
            return false;
        }

        long issueTime = bookIssueTimes.get(memberID);
        long currentTime = System.currentTimeMillis();
        long timeDifferenceInSeconds = (currentTime - issueTime) / 1000;

        if (timeDifferenceInSeconds <= 10) {
            System.out.println("The book was returned on time.");
        } else {
            long fine = timeDifferenceInSeconds - 10;
            System.out.println("The book was returned " + fine + " seconds late.");

            // Calculate the fine (1 rupee per second after 10 seconds)
            long fineAmount = fine * 1;
            System.out.println("Fine Amount: " + fineAmount + " rupees");

            // Update the member's fine
            member.setFine((int) (member.getFine() + fineAmount));
        }

        // Remove the book from the member's list of issued books
        member.getMembersbooks().remove(book);
        bookIssueTimes.remove(memberID);

        System.out.println("Book returned successfully.");
        return true;
    }

    public void PayFine(String name) {
        Member member = findMember(name);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        int totalFinePaid = member.getFine();

        if (totalFinePaid == 0) {
            System.out.println("No fine to pay.");
        } else {
            System.out.println("Total Fine Paid: " + totalFinePaid + " rupees.");

            // Set the member's fine to zero
            member.setFine(0);
        }
    }



    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public ArrayList<Book> getMembersbooks() {
        return membersbooks;
    }

    public void setMembersbooks(ArrayList<Book> membersbooks) {
        this.membersbooks = membersbooks;
    }

    public Member(String name, int age, String mobileNumber, int nextMemberID) {
        this.name = name;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.memberID = memberID;
    }

    public Member() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}
