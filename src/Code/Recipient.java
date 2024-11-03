package Code;

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

    public void registerRecipient() {
        try{
            File file = new File("src/filemanagement/Recipient.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(getName() + "\t" + getPhoneNumber() + "\t" + getCity() + "\t" + getArea() + "\t" + getBloodGroup() + "\t" + getPassword());
            bufferedWriter.newLine();
            bufferedWriter.close();
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