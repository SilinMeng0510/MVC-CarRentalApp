public class Administer {
    private String name;
    private String phone;
    private final int SSN;

    public Administer(String name, String phone, int ssn){
        this.name = name;
        this.phone = phone;
        this.SSN = ssn;
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

}