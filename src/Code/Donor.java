package Code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import external_Functions.UserID_generate;

public class Donor implements User {

    private String name;
    private String phoneNumber;
    private String DonorID;
    private String city;
    private String area;
    private String bloodGroup;
    private String password;
    private String NID;
//    private List<DonationHistory> donationHistory;
    private int points;
    private boolean isEligible;
    private String preferedHospital;
    private String zipCode;
    private String username;
    private String age;
    private String email;
    private String lastDonated;



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

//    public List<DonationHistory> getDonationHistory() {
//        return donationHistory;
//    }
//
//    public void setDonationHistory(List<DonationHistory> donationHistory) {
//        this.donationHistory = donationHistory;
//    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPreferedHospital() {
        return preferedHospital;
    }

    public void setPreferedHospital(String preferedHospital) {
        this.preferedHospital = preferedHospital;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastDonated() {
        return lastDonated;
    }

    public void setLastDonated(String lastDonated) {
        this.lastDonated = lastDonated;
    }

    public void registerDonor() {
        try{
            File file = new File("src/filemanagement/Donor.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            setDonorID(UserID_generate.generateUserID());
            setEligible(true);
            bufferedWriter.write(getName() + ";"
                    + getPhoneNumber() + ";"
                    + getcity() + ";"
                    + getArea() + ";"
                    +getBloodGroup() + ";"
                    + getNID() + ";"
                    + getPassword() + ";"
                    + getDonorID() + ";"
                    + getPoints() + ";"
                    + isEligible() + ";"
                    + getPreferedHospital() + ";"
                    + getZipCode() + ";"
                    + getUsername() + ";"
                    + getAge() + ";"
                    + getEmail() + ";"
                    + getLastDonated());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loginDonor(String phoneNumber, String password) {
        try {
            File file = new File("src/filemanagement/Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                if (data[1].equals(phoneNumber) && data[6].equals(password)) {
                    setName(data[0]);
                    setPhoneNumber(data[1]);
                    setcity(data[2]);
                    setArea(data[3]);
                    setBloodGroup(data[4]);
                    setNID(data[5]);
                    setPassword(data[6]);
                    setDonorID(data[7]);
                    setPoints(Integer.parseInt(data[8]));
                    setEligible(Boolean.parseBoolean(data[9]));
                    setPreferedHospital(data[10]);
                    setZipCode(data[11]);
                    setUsername(data[12]);
                    setAge(data[13]);
                    setEmail(data[14]);
                    setLastDonated(data[15]);
                    break;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}