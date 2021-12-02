package model.user;

/**
 * A Customer has name and phone.
 */
public class Customer {
    private String name;
    private String phone;

    /**
     * constructor to init customer
     * @param name
     * @param phone
     */
    public Customer(String name, String phone){
        this.name = name.toUpperCase();
        this.phone = phone.toUpperCase();
    }

    /**
     * getter function to access customer's name
     * @return String name
     */
    public String getName(){
        return name;
    }

    /**
     * getter function to access customer's phone
     * @return String phone
     */
    public String getPhone(){
        return phone;
    }


}
