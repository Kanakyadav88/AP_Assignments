package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Book {
    private String Title;
    private int Book_Id;
    private int numCopies;
    private String author;
    private int issue;
    private LocalDateTime due_Date;
    private long issueTimestamp;  //Timestamp when the book was borrowed.


    public LocalDateTime getDue_Date() {
        return due_Date;
    }

    public void setDue_Date(LocalDateTime due_Date) {
        this.due_Date = due_Date;
    }

    public Book(int nextBookId, String Title, String author, int numCopies) {
        if (numCopies < 0) {
            throw new IllegalArgumentException("Number of copies cannot be negative.");
        }
        this.Book_Id = nextBookId;
        this.Title = Title;
        this.author = author;
        this.numCopies = numCopies;
        this.issue = 0;
        this.issueTimestamp = 0;
        this.due_Date = due_Date;
    }
    public void returnBook() {
        issue = 0;
        issueTimestamp = 0;
    }


    public Book() {

    }
    public String getTitle() {
        return Title;
    }
    public int getBook_Id() {
        return Book_Id;
    }

    public int getNumCopies() {
        return numCopies;
    }

    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    public String getAuthor() {
        return author;
    }
    public int getIssue() {
        return issue;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Title='" + Title + '\'' +
                ", Book_Id=" + Book_Id +
                ", numCopies=" + numCopies +
                ", author='" + author + '\'' +
                ", issue=" + issue +
                '}';
    }
    ArrayList<Book> getBooks() {
        return null;
    }
    public boolean isAvailable() {
        return numCopies > 0 && issue == 0;
    }
    public double calculateFine() {
        long currentTime = System.currentTimeMillis();
        long issueTime = issueTimestamp;
        long elapsedTimeInSeconds = (currentTime - issueTime) / 1000;
        int secondsInADay = 86400; // Number of seconds in a day (24 hours)

        if (elapsedTimeInSeconds <= secondsInADay) {
            return 0.0; // No fine within a day
        } else {
            // Calculate the fine (e.g., $3 per day)
            int daysLate = (int) (elapsedTimeInSeconds / secondsInADay);
            double fine = daysLate * 3.0; // $3 per day late
            return fine;
        }
    }

    public void setIssue(Member member) {
    }
}

