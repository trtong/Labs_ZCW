public class Payee {

    private String familyName;
    private String givenName;
    private String emailAddress;

    public Payee(String familyName, String givenName, String emailAddress) {
        this.familyName = familyName;
        this.givenName = givenName;
        this.emailAddress = emailAddress;
    }

    public Payee() {
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    // ... and a bunch more hidden stuff: for testing purposes only


//    @Override
//    public boolean equals(Object obj) {
//        Payee p = (Payee) obj;
//        return (this.emailAddress.equalsIgnoreCase(p.emailAddress));
//    }
}
