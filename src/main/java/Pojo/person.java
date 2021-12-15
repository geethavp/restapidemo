package Pojo;

public class person {

    private personName personName;
    private String dateOfBirth;
    private email emailAddress;
    private String gender;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Pojo.personName getPersonName() {
        return personName;
    }

    public void setPersonName(Pojo.personName personName) {
        this.personName = personName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public email getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(email emailAddress) {
        this.emailAddress = emailAddress;
    }


}
