package Code;

public class DonorViewProfile {
    private String password;
    private String phoneNumber;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    Donor donor = new Donor();
    public DonorViewProfile(String phoneNumber, String password){
        this.phoneNumber = phoneNumber;
        this.password = password;
        donor.loginDonor(phoneNumber, password);
    }

    public void viewProfile(){
        System.out.println("Personal Information -- ");
        System.out.println("Name: " +donor.getName());
        System.out.println("ID: " +donor.getDonorID());
        System.out.println("Age: " +donor.getAge());
        System.out.println("Blood Group: " +donor.getBloodGroup());
        System.out.println("Phone: " +donor.getPhoneNumber());
        System.out.println("Email: " +donor.getEmail());
        System.out.println("Location -- ");
        System.out.println("City: " +donor.getCity());
        System.out.println("Area: " +donor.getArea());
        System.out.println("Zip Code: " +donor.getZipCode());
        System.out.println("Preferred Hospital: " +donor.getPreferedHospital());
        System.out.println("Others -- ");
        System.out.println("Points: " +donor.getPoints());
        if(donor.isEligible()){
            System.out.println("Eligible: Yes");
        }
        else{
            System.out.println("Eligible: No");
        }
        System.out.println("Last Donated: " +donor.getLastDonated());
    }
}
