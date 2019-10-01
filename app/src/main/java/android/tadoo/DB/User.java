package android.tadoo.DB;

public class User {

    public User(String Name, String LastName){
        myName = Name;
        myLastName = LastName;
    }

    private String myName, myLastName;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyLastName() {
        return myLastName;
    }

    public void setMyLastName(String myLastName) {
        this.myLastName = myLastName;
    }
}
