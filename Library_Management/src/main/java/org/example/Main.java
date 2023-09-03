package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner user_input = new Scanner(System.in);

        Librarian librarian = new Librarian();
        Member member = new Member();
        Book book_list = new Book();

        while (true) {
            int j = -1;
            System.out.println(
                    """
                            1. Enter as a librarian\s
                            2. Enter as a member\s
                            3. Exit\s
                            """);
            int user_choice = user_input.nextInt();

            switch (user_choice) {
                case 1 -> {
                    while (j != 7) {
                        System.out.println(
                                """
                                        1. Register a member
                                        2. Remove a member
                                        3. Add a book
                                        4. Remove a book
                                        5. View all members along with their books and fines to be paid
                                        6. View all books
                                        7. Back
                                        """);
                        j = user_input.nextInt();

                        switch (j) {

                            case 1 -> {
                                System.out.println(" Register a member");
                                librarian.Add_Member();
                            }
                            case 2 -> {
                                System.out.println("Enter a Name or ID(phone number) to Remove a member");
                                double input = user_input.nextDouble();
                                librarian.Remove_Member_By_ID(input);

                            }
                            case 3 -> {
                                librarian.addBook();
                                System.out.println("Book added successfully.");
                            }
                            case 4 -> {
                                System.out.print("Enter the ID of the book to remove: ");
                                int bookIdToRemove = user_input.nextInt();
//                                Book.remove(bookIdByRemove);
                            }
                            case 5 -> {
//                                librarian.members.add(member);
                                System.out.println("View all members along with their books and fines to be paid");
                                for (Member member1 : librarian.members) {
                                    System.out.println(member1);
                                }
                                //System.out.println(librarian.getMembers());
                            }
                            case 6 -> {
                                System.out.println("View all books");
                                for (Book book1 : librarian.booksList) {
                                    System.out.println(book1);
                                }
                            }
                            case 7 -> System.out.println("Exiting the librarian menu.");
//                                return; // Exit the loop

                            default -> System.out.println("Invalid choice. Please select a valid option.");
                        }
                    }
                }
                case 2 -> {
                    librarian.loginAsMember();
                    Member currentMember = librarian.getCurrentMember();
                    if (currentMember != null) {
                        System.out.println("Logged in as: " + member.getmem_Name());
                    } else {
                        System.out.println("No member is currently logged in.");
                    }
                        while (j != 6) {
                            System.out.println(
                                    """
                                            1. List Available Books\s
                                            2. List My Books
                                            3. Issue book
                                            4. Return book
                                            5. Pay Fine
                                            6. Back
                                            """);
                            j = user_input.nextInt();

                            switch (j) {

                                case 1 -> {
                                    System.out.println("List Available Books");
//                                    if(loggedIn) {
                                    member.listAvailableBooks(book_list.getBooks());
//                                    }
                                }
                                case 2 -> {
                                    System.out.println("List My Books");

//                                    if (loggedIn) {
                                        member.listMyBooks(member, librarian.booksList);
//                                    }
                                }
                                case 3 -> {  // Issue the Book
                                    System.out.print("Enter the book ID to issue: ");
                                    int bookIdToIssue = user_input.nextInt();
                                    member.issueBook(currentMember, bookIdToIssue, book_list.getBooks());
                                }
                                case 4 ->{ System.out.println("Return a Book");

//                                  System.out.print("Enter the book ID to return: ");
                                    int book_Return = user_input.nextInt();
//                                  member.returnBook(currentMember, bookIdToReturn, member.getBooks());
                                    member.returnBook();
                                    book_list.setNumCopies(book_list.getNumCopies() + 1);
                                }
                                case 5 -> {
                                    System.out.println("Pay Fine");
                                    member.payFine(currentMember);
                                }
                                case 6 ->
                                    System.out.println("Exiting the member menu.");
//                                    loggedIn = false;

                                default -> System.out.println("Invalid member choice. Please select a valid option.");
                            }
                        }
                    }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid user choice. Please select a valid option.");
            }
        }
    }
}

