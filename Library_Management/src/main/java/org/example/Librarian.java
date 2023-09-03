package org.example;
import java.util.*;

public class Librarian {
    ArrayList<Member> members = new ArrayList<>();
    ArrayList<Book> booksList = new ArrayList<>();
    private Map<String, String> memberCredentials; // Map to store member credentials (name -> phone number)
    private Member currentMember;

    private int member_id = 0;

    public Librarian() {
        memberCredentials = new HashMap<>();
    }
//    public void registerMember(String mem_n)

    public void Add_Member() {
        member_id++;
        Scanner mem_input = new Scanner(System.in);

        System.out.println("Enter member name:");
        String mem_Name = mem_input.nextLine();

        System.out.println("Enter member age:");
        int mem_age = mem_input.nextInt();

        System.out.println("Enter phone_no as ID:");
        double phonenumber = mem_input.nextDouble();

        // Create and initialize the Member object
        Member member = new Member(mem_Name, mem_age, member_id, 0.0, phonenumber);

        // Add the member to the list
        members.add(member);
    }


    public void Remove_Member_By_ID(double ph) {
        Iterator<Member> iterator = members.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            if (member.getMem_Id() == ph) {
                iterator.remove();
                System.out.println("Member removed successfully.");
            }
        }
    }
    int nextBookId = 0;
    public  void addBook() {
        Book book = new Book();
        Scanner user_input = new Scanner(System.in);

        System.out.println(" Add a book");
        System.out.println("Enter book title: ");
        String Title = user_input.nextLine();
        System.out.print("Enter book author: ");
        String author = user_input.nextLine();
        System.out.print("Enter number of copies: ");
        int numCopies = user_input.nextInt();

        Book newBook = new Book(nextBookId, Title, author, numCopies);
        booksList.add(newBook);
        nextBookId++;
    }
    public void removeBookById(int bookId) {
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getBook_Id() == bookId) {
                booksList.remove(i);
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
    public void loginAsMember() {
        Member member = new Member();
        Scanner scanner = new Scanner(System.in);

        // Prompt for member name and phone number
        System.out.print("Enter your name: ");
        member.getmem_Name = scanner.nextLine();
        System.out.println("Enter your phone no.");
        member.getmem_ID = scanner.nextInt();

        // Check if the member is registered
        if (memberCredentials.containsKey(member.getMem_Name())) {
            System.out.print("Enter your phone number: ");
            String phoneNumber = scanner.nextLine();

            // Check if the entered phone number matches the registered phone number
            if (phoneNumber.equals(memberCredentials.get(member.getMem_Name()))) {
                currentMember = new Member(); // Create a Member object for the logged-in member
                System.out.println("Logged in as " + member.getMem_Name());
            } else {
                System.out.println("Invalid phone number. Please try again.");
            }
        } else {
            System.out.println("Member not registered. Please register first.");
        }
    }

    public Member getCurrentMember() {
        return currentMember;
    }
}


