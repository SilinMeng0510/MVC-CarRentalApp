package model.user;

public class Administer {
    private String name;
    private String phone;


    public Administer(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

}