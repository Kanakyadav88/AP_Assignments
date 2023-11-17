package org.example;

public class Discounts {
    private String discount_code;

    private double offer;
    private boolean eligibility;
    private int age;

    private int flag;   // 1 means check for age above given, 0 means check for age under given age
    Discounts(String discount_code, int flag, int age, int offer){
        this.discount_code= discount_code;
        this.flag=flag;
        this.age=age;
        this.offer=offer;
        this.eligibility=false;
    }
    public double getOffer() {
        return offer;
    }

    public void setOffer(double offer) {
        this.offer = offer;
    }

    public boolean isEligibility() {
        return eligibility;
    }

    public void setEligibility(boolean eligibility) {
        this.eligibility = eligibility;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public String getDiscount_code() {
        return discount_code;
    }

    public void setDiscount_code(String discount_code) {
        this.discount_code = discount_code;
    }
    public void setFlag(int flag){
        this.flag=flag;
    }
    public int getFlag(){
        return this.flag;
    }


    public boolean isEligible(Visitor v){
        if((this.flag==0 && v.getAge()<=this.age) || (this.flag==1 && v.getAge()>=this.age)){

            return true;
        }else{
            return false;
        }
    }
}
