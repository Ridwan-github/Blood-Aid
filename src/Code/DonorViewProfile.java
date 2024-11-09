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

    final String RED = "\033[31m";
    final String RESET = "\033[0m";

    public void viewProfile(){
        System.out.println(RED + "Personal Information -- " + RESET);
        System.out.println(RED + "Name: " + RESET +donor.getName());
        System.out.println(RED + "ID: " + RESET +donor.getDonorID());
        System.out.println(RED + "Age: " + RESET+donor.getAge());
        System.out.println(RED + "Blood Group: " + RESET +donor.getBloodGroup());
        System.out.println(RED + "Phone: " + RESET +donor.getPhoneNumber());
        System.out.println(RED + "Email: " + RESET +donor.getEmail());
        System.out.println(RED + "Location -- " + RESET);
        System.out.println(RED + "City: " + RESET +donor.getCity());
        System.out.println(RED + "Area: " + RESET +donor.getArea());
        System.out.println(RED + "Zip Code: " + RESET +donor.getZipCode());
        System.out.println(RED + "Preferred Hospital: " + RESET +donor.getPreferedHospital());
        System.out.println(RED + "Others -- " + RESET);
        System.out.println(RED + "Points: " + RESET +donor.getPoints());
        if(donor.isEligible()){
            System.out.println("Eligible: Yes");
        }
        else{
            System.out.println("Eligible: No");
        }
        System.out.println("Last Donated: " + donor.getLastDonatedDate().toString());
    }
}
