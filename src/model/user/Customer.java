package model.user;

public class Customer {
    private String name;
    private String phone;

    public Customer(String name, String phone){
        this.name = name.toUpperCase();
        this.phone = phone.toUpperCase();
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }


}
