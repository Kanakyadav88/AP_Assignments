package org.example;

public class Feedback {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    private String feedback;
    Feedback(String name, String feedback){
        this.name  = name;
        this.feedback=feedback;
    }
}
