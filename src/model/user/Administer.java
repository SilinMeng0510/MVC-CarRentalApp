package model.user;

public class Administer {
    private String name;
    private String id;


    public Administer(String name, String id){
        this.name = name.toUpperCase();
        this.id = id.toUpperCase();
    }

    public String getName(){
        return name;
    }

    public String getID(){
        return id;
    }

}