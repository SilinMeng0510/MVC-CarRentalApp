package model.user;

/**
 * Administer has a name and a ID.
 */
public class Administer {
    private String name;
    private String id;


    /**
     * constructor to init administer
     * @param name
     * @param id
     */
    public Administer(String name, String id){
        this.name = name.toUpperCase();
        this.id = id.toUpperCase();
    }

    /**
     * getter function to access name
     * @return String name
     */
    public String getName(){
        return name;
    }

    /**
     * getter function to access id
     * @return String ID
     */
    public String getID(){
        return id;
    }

}