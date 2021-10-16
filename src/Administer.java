public class Administer {
    private String name;
    private int phone;
    private int password = -1;
    private final int SSN;

    public Administer(String name, int phone, int ssn){
        this.name = name;
        this.phone = phone;
        this.SSN = ssn;
    }

    public void createPassword(int password){
        if (password >= 0){
            this.password = password;
        }
        else {
            System.out.println("PLEASE ENTER POSITIVE NUMBER AS YOUR PASSWORD.");
        }
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

    public boolean verifyPassword(int password){
        if (this.password == -1 || this.password == password){
            return true;
        }
        return false;
    }
}
