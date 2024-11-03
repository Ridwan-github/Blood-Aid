package Code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class Donor implements User {

    private String name;
    private String phoneNumber;
    private String DonorID;
    private String city;
    private String area;
    private String bloodGroup;
    private String password;
    private String NID;
    private List<DonationHistory> donationHistory;
    private int points;
    private boolean isEligible;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDonorID() {
        return DonorID;
    }

    public void setDonorID(String donorID) {
        DonorID = donorID;
    }

    public String getcity() {
        return city;
    }

    public void setcity(String city) {
        this.city = city;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public List<DonationHistory> getDonationHistory() {
        return donationHistory;
    }

    public void setDonationHistory(List<DonationHistory> donationHistory) {
        this.donationHistory = donationHistory;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isEligible() {
        return isEligible;
    }

    public void setEligible(boolean eligible) {
        isEligible = eligible;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {
        this.NID = NID;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void registerDonor() {
        try{
            File file = new File("src/filemanagement/Donor.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(getName() + "\t" + getPhoneNumber() + "\t" + getcity() + "\t" + getArea() + "\t" +getBloodGroup() + "\t" + getNID() + "\t" + getPassword());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Donor donor = new Donor();
        donor.setName("John Doe");
        donor.setPhoneNumber("0123456789");
        donor.setcity("Dhaka");
        donor.setArea("Uttara");
        donor.setBloodGroup("A+");
        donor.setNID("1234567890123456");
        donor.setPassword("password");
        donor.registerDonor();
    }
}