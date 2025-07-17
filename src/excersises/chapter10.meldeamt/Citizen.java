package excersises.chapter10.meldeamt;

import java.io.Serializable;

public class Citizen implements Comparable<Citizen>, Serializable {

    public static final long serialVersionUID = 3L;


    private String lastName;
    private String firstName;
    private String birthLastName;
    private String email;
    private Title title;
    private MaritalStatus maritalStatus;


    public Citizen(String lastName, String firstName, String birthLastName, String email, Title title, MaritalStatus maritalStatus){
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setBirthLastName(birthLastName);
        this.setEmail(email);
        this.setTitle(title);
        this.setMaritalStatus(maritalStatus);
    }


    @Override
    public int compareTo(Citizen o) {
        int comp = this.getLastName().compareTo(o.getLastName());
        if(comp == 0){
            comp = this.getFirstName().compareTo(o.getFirstName());
        }

        return comp;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){ return true; }
        if(o == null){ return false; }
        if(this.getClass() != o.getClass()){ return false; }

        Citizen e = (Citizen)o;

        if(!this.getLastName().equals(e.getLastName())){ return false; }
        if(!this.getFirstName().equals(e.getFirstName())){ return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return this.getLastName().hashCode() ^ this.getFirstName().hashCode();
    }

    @Override
    public String toString() {
        return this.getTitle() + " "
                + this.getFirstName() + " "
                + this.getLastName()
                + (this.getBirthLastName() != null ? " (" + this.getBirthLastName() +  ")" : "" ) + ";\t "
                + "EMail: " + this.getEmail()
                + "\tFamilienstand: " + this.getMaritalStatus();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthLastName() {
        return birthLastName;
    }

    public void setBirthLastName(String birthLastName) {
        this.birthLastName = birthLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

}
