package Code;

import external_Functions.PasswordCipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class User {
    private String name;
    private String phoneNumber;
    private String password;
    private String city;
    private String area;
    private String bloodGroup;

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public boolean login(String phoneNumber, String password) {
        PasswordCipher passwordCipher = new PasswordCipher();
        try {
            File file = new File("Recipient.txt");
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
                    setPassword(decryptedPassword);
                    return true;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean registerUser(){
        Recipient recipient = new Recipient();
        recipient.setName(getName());
        recipient.setPhoneNumber(getPhoneNumber());
        recipient.setCity(getCity());
        recipient.setArea(getArea());
        recipient.setBloodGroup(getBloodGroup());
        recipient.setPassword(getPassword());
        recipient.registerRecipient();

        PasswordCipher passwordCipher = new PasswordCipher();
        try{
            File file = new File("User.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String encryptedPassword = passwordCipher.encryptPassword(getPassword());
            bufferedWriter.write(getName() + ";" + getPhoneNumber() + ";" + encryptedPassword);
            bufferedWriter.newLine();
            bufferedWriter.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
