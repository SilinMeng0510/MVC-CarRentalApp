public class Administer {
    private String name;
    private int phone;
    private final int SSN;

    public Administer(String name, int phone, int ssn){
        this.name = name;
        this.phone = phone;
        this.SSN = ssn;
    }

    public String getName(){
        return name;
    }

    public int getPhone(){
        return phone;
    }

    public boolean verifySSN(int ssn){
        if (SSN == ssn){
            return true;
        }
        return false;
    }
}