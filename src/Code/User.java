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

    public boolean login(String phoneNumber, String password) {
        PasswordCipher passwordCipher = new PasswordCipher();
        try{
            File file = new File("User.txt");
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(";");
                String decryptedPassword = passwordCipher.decryptPassword(data[2]);
                if (data[1].equals(phoneNumber) && decryptedPassword.equals(password)) {
                    setName(data[0]);
                    setPhoneNumber(data[1]);
                    setPassword(data[2]);
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

    public boolean findUser(String phone, String password){
        try {
            File file = new File("User.txt");
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                if (data[1].equals(phone) && PasswordCipher.decryptPassword(data[6]).equals(password)) {
                    return true;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
