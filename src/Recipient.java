import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Recipient implements User, Searchable, Notifiable {
    private String name;
    private String phoneNumber;
    private String address;

    // Methods: login, logout, postRequest, searchDonors, notifyUser, confirmDonation, etc.

    public void login(String phoneNumber, String password) {
        // Implementation
    }

    public void logout() {
        // Implementation
    }

    public void postRequest() {
        // Implementation
    }

    List<Donor> donors = new ArrayList<Donor>();

    public List<Donor> searchDonors(String bloodGroup, String region, DonationType donationType) {
        // Implementation
        return donors;
    }

    public void notifyUser() {
        // Implementation
    }

    public void confirmDonation() {
        // Implementation
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public void notifyUser(String message) {

    }
}