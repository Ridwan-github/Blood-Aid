import java.util.List;
import java.util.Scanner;

class Donor implements User, Notifiable {

    private String name;
    private String phoneNumber;
    private String DonorID;
    private String address;
    private String bloodGroup;
    private List<DonationHistory> donationHistory;
    private int points;
    private boolean isEligible;

    public void login(String phoneNumber, String password) {
        // Implementation
    }

    public void logout() {
        // Implementation
    }

    public void donateBlood() {
        // Implementation
    }

    public void acceptRequest() {
        // Implementation
    }

    public boolean checkEligibility() {
        // Implementation
        return false;
    }

    public void notifyUser() {
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

    public String getBloodGroup() {
        return bloodGroup;
    }

    public List<DonationHistory> getDonationHistory() {
        return donationHistory;
    }

    public int getPoints() {
        return points;
    }

    public boolean getIsEligible() {
        return isEligible;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setDonationHistory(List<DonationHistory> donationHistory) {
        this.donationHistory = donationHistory;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setIsEligible(boolean isEligible) {
        this.isEligible = isEligible;
    }

    public String getDonorID() {
        return DonorID;
    }

    public void setDonorID(String DonorID) {
        this.DonorID = DonorID;
    }

    @Override
    public void notifyUser(String message) {

    }
}