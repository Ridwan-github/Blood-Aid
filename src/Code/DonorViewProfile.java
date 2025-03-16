package Code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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

    public void updateProfile(String field, String newValue) {
        switch (field.toLowerCase()) {
            case "city":
                donor.setCity(newValue);
                break;
            case "area":
                donor.setArea(newValue);
                break;
            case "email":
                donor.setEmail(newValue);
                break;
            default:
                System.out.println("Invalid field to update");
                return;
        }

        try {
            File file = new File("Donor.txt");
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;
            String header = reader.readLine();
            content.append(header).append("\n");

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data[1].equals(this.phoneNumber)) {
                    switch (field.toLowerCase()) {
                        case "city":
                            data[2] = newValue;
                            break;
                        case "area":
                            data[3] = newValue;
                            break;
                        case "email":
                            data[13] = newValue;
                            break;
                    }
                    line = String.join(";", data);
                }
                content.append(line).append("\n");
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content.toString());
            writer.close();

            System.out.println("Profile updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating profile: " + e.getMessage());
        }
    }

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
        System.out.println(RED + "NID: " + RESET +donor.getNID());
        if (donor.isEligibleForWholeBlood()){
            System.out.println(RED + "Eligible for Whole Blood: " + RESET + "Yes");
        } else {
            System.out.println(RED + "Eligible for Whole Blood: " + RESET + "No");
        }
        if (donor.isEligibleForPlatelets()){
            System.out.println(RED + "Eligible for Platelets: " + RESET + "Yes");
        } else {
            System.out.println(RED + "Eligible for Platelets: " + RESET + "No");
        }
        if (donor.isEligibleForPlasma()){
            System.out.println(RED + "Eligible for Plasma: " + RESET + "Yes");
        } else {
            System.out.println(RED + "Eligible for Plasma: " + RESET + "No");
        }
        if (donor.isEligibleForPowerRed()){
            System.out.println(RED + "Eligible for Power Red: " + RESET + "Yes");
        } else {
            System.out.println(RED + "Eligible for Power Red: " + RESET + "No");
        }
        System.out.println(RED + "Last Donated -- " + RESET);
        if (donor.getLastDonatedDateWholeBlood().isNull()){
            System.out.println(RED + "Whole Blood: " + RESET + "Never donated");
        } else {
            System.out.println(RED + "Whole Blood: " + RESET + donor.getLastDonatedDateWholeBlood().toString());
        }
        if (donor.getLastDonatedDatePlatelets().isNull()){
            System.out.println(RED + "Platelets: " + RESET + "Never donated");
        } else {
            System.out.println(RED + "Platelets: " + RESET + donor.getLastDonatedDatePlatelets().toString());
        }
        if (donor.getLastDonatedDatePlasma().isNull()){
            System.out.println(RED + "Plasma: " + RESET + "Never donated");
        } else {
            System.out.println(RED + "Plasma: " + RESET + donor.getLastDonatedDatePlasma().toString());
        }
        if (donor.getLastDonatedDatePowerRed().isNull()){
            System.out.println(RED + "Power Red: " + RESET + "Never donated");
        } else {
            System.out.println(RED + "Power Red: " + RESET + donor.getLastDonatedDatePowerRed().toString());
        }
    }
}
