package Code;

import external_Functions.MyDate;
import external_Functions.PasswordCipher;
import external_Functions.UserID_generate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Donor implements User {

    private String name;
    private String phoneNumber;
    private String DonorID;
    private String city;
    private String area;
    private String bloodGroup;
    private String password;
    private String NID;
    private int points;
    private boolean isEligibleForWholeBlood;
    private boolean isEligibleForPlatelets;
    private boolean isEligibleForPlasma;
    private boolean isEligibleForPowerRed;
    private String preferedHospital;
    private String zipCode;
    private String username;
    private String age;
    private String email;
    private MyDate lastDonatedDateWholeBlood;
    private MyDate lastDonatedDatePlatelets;
    private MyDate lastDonatedDatePlasma;
    private MyDate lastDonatedDatePowerRed;



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


    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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

    public boolean isEligibleForWholeBlood() {
        return isEligibleForWholeBlood;
    }

    public void setEligibleForWholeBlood(boolean eligibleForWholeBlood) {
        isEligibleForWholeBlood = eligibleForWholeBlood;
    }

    public boolean isEligibleForPlatelets() {
        return isEligibleForPlatelets;
    }

    public void setEligibleForPlatelets(boolean eligibleForPlatelets) {
        isEligibleForPlatelets = eligibleForPlatelets;
    }

    public boolean isEligibleForPlasma() {
        return isEligibleForPlasma;
    }

    public void setEligibleForPlasma(boolean eligibleForPlasma) {
        isEligibleForPlasma = eligibleForPlasma;
    }

    public boolean isEligibleForPowerRed() {
        return isEligibleForPowerRed;
    }

    public void setEligibleForPowerRed(boolean eligibleForPowerRed) {
        isEligibleForPowerRed = eligibleForPowerRed;
    }

    public MyDate getLastDonatedDateWholeBlood() {
        return lastDonatedDateWholeBlood;
    }

    public void setLastDonatedDateWholeBlood(String lastDonatedDateWholeBlood) {
        this.lastDonatedDateWholeBlood = new MyDate(lastDonatedDateWholeBlood);
    }

    public MyDate getLastDonatedDatePlatelets() {
        return lastDonatedDatePlatelets;
    }

    public void setLastDonatedDatePlatelets(String lastDonatedDatePlatelets) {
        this.lastDonatedDatePlatelets = new MyDate(lastDonatedDatePlatelets);
    }

    public MyDate getLastDonatedDatePlasma() {
        return lastDonatedDatePlasma;
    }

    public void setLastDonatedDatePlasma(String lastDonatedDatePlasma) {
        this.lastDonatedDatePlasma = new MyDate(lastDonatedDatePlasma);
    }

    public MyDate getLastDonatedDatePowerRed() {
        return lastDonatedDatePowerRed;
    }

    public void setLastDonatedDatePowerRed(String lastDonatedDatePowerRed) {
        this.lastDonatedDatePowerRed = new MyDate(lastDonatedDatePowerRed);
    }



    PasswordCipher passwordCipher = new PasswordCipher();
    public void registerDonor() {
        try{
            File file = new File("Donor.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            String encryptedPassword = passwordCipher.encryptPassword(getPassword());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            setDonorID(UserID_generate.generateUserID());
            String password = passwordCipher.encryptPassword(getPassword());
            bufferedWriter.write(getName() + ";"
                    + getPhoneNumber() + ";"
                    + getcity() + ";"
                    + getArea() + ";"
                    +getBloodGroup() + ";"
                    + getNID() + ";"
                    + password + ";"
                    + getDonorID() + ";"
                    + getPoints() + ";"
                    + getPreferedHospital() + ";"
                    + getZipCode() + ";"
                    + getUsername() + ";"
                    + getAge() + ";"
                    + getEmail() + ";"
                    + isEligibleForWholeBlood() + ";"
                    + isEligibleForPlatelets() + ";"
                    + isEligibleForPlasma() + ";"
                    + isEligibleForPowerRed() + ";"
                    + (getLastDonatedDateWholeBlood() == null ? "0/0/0000" : getLastDonatedDateWholeBlood().toString()) + ";"
                    + (getLastDonatedDatePlatelets() == null ? "0/0/0000" : getLastDonatedDatePlatelets().toString()) + ";"
                    + (getLastDonatedDatePlasma() == null ? "0/0/0000" : getLastDonatedDatePlasma().toString()) + ";"
                    + (getLastDonatedDatePowerRed() == null ? "0/0/0000" : getLastDonatedDatePowerRed().toString()) + ";"
            );
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loginDonor(String phoneNumber, String password) {
        try {
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                if (data[1].equals(phoneNumber) && passwordCipher.decryptPassword(data[6]).equals(password)) {
                    setName(data[0]);
                    setPhoneNumber(data[1]);
                    setcity(data[2]);
                    setArea(data[3]);
                    setBloodGroup(data[4]);
                    setNID(data[5]);
                    setPassword(data[6]);
                    setDonorID(data[7]);
                    setPoints(Integer.parseInt(data[8]));
                    setPreferedHospital(data[9]);
                    setZipCode(data[10]);
                    setUsername(data[11]);
                    setAge(data[12]);
                    setEmail(data[13]);
                    setEligibleForWholeBlood(Boolean.parseBoolean(data[14]));
                    setEligibleForPlatelets(Boolean.parseBoolean(data[15]));
                    setEligibleForPlasma(Boolean.parseBoolean(data[16]));
                    setEligibleForPowerRed(Boolean.parseBoolean(data[17]));
                    setLastDonatedDateWholeBlood(data[18]);
                    setLastDonatedDatePlatelets(data[19]);
                    setLastDonatedDatePlasma(data[20]);
                    setLastDonatedDatePowerRed(data[21]);
                    break;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loginDonor(String donorID) {
        try {
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                if (data[7].equals(donorID)) {
                    setName(data[0]);
                    setPhoneNumber(data[1]);
                    setcity(data[2]);
                    setArea(data[3]);
                    setBloodGroup(data[4]);
                    setNID(data[5]);
                    setPassword(data[6]);
                    setDonorID(data[7]);
                    setPoints(Integer.parseInt(data[8]));
                    setPreferedHospital(data[9]);
                    setZipCode(data[10]);
                    setUsername(data[11]);
                    setAge(data[12]);
                    setEmail(data[13]);
                    setEligibleForWholeBlood(Boolean.parseBoolean(data[14]));
                    setEligibleForPlatelets(Boolean.parseBoolean(data[15]));
                    setEligibleForPlasma(Boolean.parseBoolean(data[16]));
                    setEligibleForPowerRed(Boolean.parseBoolean(data[17]));
                    setLastDonatedDateWholeBlood(data[18]);
                    setLastDonatedDatePlatelets(data[19]);
                    setLastDonatedDatePlasma(data[20]);
                    setLastDonatedDatePowerRed(data[21]);
                    break;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    final String RED = "\033[31m";
    final String RESET = "\033[0m";

    public void viewProfile(String id) {
        try {
            File file = new File("Donor.txt");
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                if (data[7].equals(id)) {
                    System.out.println("==============================================================================================");
                    System.out.println("                    Donor's Profile");
                    System.out.println("==============================================================================================");
                    System.out.println(RED + "Name: " + RESET + data[0]);
                    System.out.println(RED + "Phone Number: " + RESET + data[1]);
                    System.out.println(RED + "City: " + RESET + data[2]);
                    System.out.println(RED + "Area: " + RESET + data[3]);
                    System.out.println(RED + "Blood Group: " + RESET + data[4]);
                    System.out.println(RED + "Donor ID: " + RESET + data[7]);
                    System.out.println(RED + "Points: " + RESET + data[8]);
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