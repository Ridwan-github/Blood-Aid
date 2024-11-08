package Code;

import external_Functions.PasswordCipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

public class Recipient {
    private String name;
    private String phoneNumber;
    private String city;
    private String area;
    private String bloodGroup;
    private String password;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    PasswordCipher passwordCipher = new PasswordCipher();
    public void registerRecipient() {
        try{
            File file = new File("src/filemanagement/Recipient.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String encryptedPassword = passwordCipher.encryptPassword(getPassword());
            bufferedWriter.write(getName() + ";" + getPhoneNumber() + ";" + getCity() + ";" + getArea() + ";" + getBloodGroup() + ";" + encryptedPassword);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loginRecipient(String phoneNumber, String password) {
        try {
            File file = new File("src/filemanagement/Recipient.txt");
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                String decryptedPassword = passwordCipher.decryptPassword(data[5]);
                if (data[1].equals(phoneNumber) && decryptedPassword.equals(password)) {
                    setName(data[0]);
                    setPhoneNumber(data[1]);
                    setCity(data[2]);
                    setArea(data[3]);
                    setBloodGroup(data[4]);
                    setPassword(data[5]);
                    break;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Recipient recipient = new Recipient();
        recipient.setName("John Doe");
        recipient.setPhoneNumber("0123456789");
        recipient.setCity("Dhaka");
        recipient.setArea("Uttara");
        recipient.registerRecipient();
    }
}