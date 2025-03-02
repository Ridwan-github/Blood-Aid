package Code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class AnalyticReport {
    public int totalNoOfDonor(){
        try{

            File file = new File("Donor.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                count++;
            }
            reader.close();
            count--;
            return count;
        } catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }

    public int totalNoOfRecipient(){
        try{

            File file = new File("Recipient.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                count++;
            }
            reader.close();
            count--;
            return count;
        } catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }

    public int totalNoOfDonation(){
        try{

            File file = new File("DonationRequestHistory.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if(data[4].equals("Donated")){
                    count++;
                }
            }
            reader.close();
            return count;
        } catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }

    public int totalPendingRequest(){
        try{

            File file = new File("DonationRequestHistory.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if(data[4].equals("Pending")){
                    count++;
                }
            }
            reader.close();
            return count;
        } catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }

    public int totalNoOfRequestToBeConfirmed(){
        try{

            File file = new File("DonationRequestHistory.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if(data[4].equals("Accepted")){
                    count++;
                }
            }
            reader.close();
            return count;
        } catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }

    public int totalNoOfRequests(){
        try{

            File file = new File("DonationRequestHistory.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                count++;
            }
            reader.close();
            return count;
        } catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }

    public int totalNoOfBloodgroup(String bloodGroup){
        try{
            File file = new File("DonationRequestHistory.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if(data[5].equals(bloodGroup) && data[4].equals("Donated")){
                    count++;
                }
            }
            reader.close();
            return count;
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public int totalNoOfBloodgroupRequested(String bloodGroup){
        try{
            File file = new File("DonationRequestHistory.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if(data[5].equals(bloodGroup) && !data[4].equals("Donated")){
                    count++;
                }
            }
            reader.close();
            return count;
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public int totalNoOFApositive(){
        return totalNoOfBloodgroup("A+");
    }

    public int totalNoOFBpositive(){
        return totalNoOfBloodgroup("B+");
    }

    public int totalNoOFABpositive(){
        return totalNoOfBloodgroup("AB+");
    }

    public int totalNoOFABnegative(){
        return totalNoOfBloodgroup("AB-");
    }

    public int totalNoOFBnegative(){
        return totalNoOfBloodgroup("B-");
    }

    public int totalNoOFAnegative(){
        return totalNoOfBloodgroup("A-");
    }

    public int totalNoOFOnegative(){
        return totalNoOfBloodgroup("O-");
    }

    public int totalNoOFOpositive(){
        return totalNoOfBloodgroup("O+");
    }

    public int totalNoOdApositiveRequested(){
        return totalNoOfBloodgroupRequested("A+");
    }

    public int totalNoOdBpositiveRequested(){
        return totalNoOfBloodgroupRequested("B+");
    }

    public int totalNoOdABpositiveRequested(){
        return totalNoOfBloodgroupRequested("AB+");
    }

    public int totalNoOdABnegativeRequested(){
        return totalNoOfBloodgroupRequested("AB-");
    }

    public int totalNoOdBnegativeRequested(){
        return totalNoOfBloodgroupRequested("B-");
    }

    public int totalNoOdAnegativeRequested(){
        return totalNoOfBloodgroupRequested("A-");
    }

    public int totalNoOdOnegativeRequested(){
        return totalNoOfBloodgroupRequested("O-");
    }

    public int totalNoOdOpositiveRequested(){
        return totalNoOfBloodgroupRequested("O+");
    }

    public void maximumBloodGroupDonated(){
        int Apositive = totalNoOFApositive();
        int Bpositive = totalNoOFBpositive();
        int ABpositive = totalNoOFABpositive();
        int ABnegative = totalNoOFABnegative();
        int Bnegative = totalNoOFBnegative();
        int Anegative = totalNoOFAnegative();
        int Onegative = totalNoOFOnegative();
        int Opositive = totalNoOFOpositive();

        int max = Math.max(Apositive, Math.max(Bpositive, Math.max(ABpositive, Math.max(ABnegative, Math.max(Bnegative, Math.max(Anegative, Math.max(Onegative, Opositive)))))));

        if(max == Apositive){
            System.out.println("A+ : " + Apositive);
        } else if(max == Bpositive){
            System.out.println("B+ : " + Bpositive);
        } else if(max == ABpositive){
            System.out.println("AB+ : " + ABpositive);
        } else if(max == ABnegative){
            System.out.println("AB- : " + ABnegative);
        } else if(max == Bnegative){
            System.out.println("B- : " + Bnegative);
        } else if(max == Anegative){
            System.out.println("A- : " + Anegative);
        } else if(max == Onegative){
            System.out.println("O- : " + Onegative);
        } else {
            System.out.println("O+ : "  + Opositive);
        }
    }

    public int totalNoOfDonors(String bloodGroup){
        try{
            File file = new File("Donor.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if(data[4].equals(bloodGroup)){
                    count++;
                }
            }
            reader.close();
            return count;

        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public int totalNoOfApositiveDonors(){
        return totalNoOfDonors("A+");
    }

    public int totalNoOfBpositiveDonors(){
        return totalNoOfDonors("B+");
    }

    public int totalNoOfABpositiveDonors(){
        return totalNoOfDonors("AB+");
    }

    public int totalNoOfAnegativeDonors(){
        return  totalNoOfDonors("A-");
    }

    public int totalNoOfBnegativeDonors(){
        return  totalNoOfDonors("B-");
    }

    public int totalNoOfABnegativeDonors(){
        return  totalNoOfDonors("AB-");
    }

    public int totalNoOfOpositiveDonors(){
        return  totalNoOfDonors("O+");
    }

    public int totalNoOfOnegativeDonors(){
        return  totalNoOfDonors("O-");
    }

    public void maximumBloodGroupRequested(){
        int Apositive = totalNoOdApositiveRequested();
        int Bpositive = totalNoOdBpositiveRequested();
        int ABpositive = totalNoOdABpositiveRequested();
        int ABnegative = totalNoOdABnegativeRequested();
        int Bnegative = totalNoOdBnegativeRequested();
        int Anegative = totalNoOdAnegativeRequested();
        int Onegative = totalNoOdOnegativeRequested();
        int Opositive = totalNoOdOpositiveRequested();

        int max = Math.max(Apositive, Math.max(Bpositive, Math.max(ABpositive, Math.max(ABnegative, Math.max(Bnegative, Math.max(Anegative, Math.max(Onegative, Opositive)))))));

        if(max == Apositive){
            System.out.println("A+ : " + Apositive);
        } else if(max == Bpositive){
            System.out.println("B+ : " + Bpositive);
        } else if(max == ABpositive){
            System.out.println("AB+ : " + ABpositive);
        } else if(max == ABnegative){
            System.out.println("AB- : " + ABnegative);
        } else if(max == Bnegative){
            System.out.println("B- : " + Bnegative);
        } else if(max == Anegative){
            System.out.println("A- : " + Anegative);
        } else if(max == Onegative){
            System.out.println("O- : " + Onegative);
        } else {
            System.out.println("O+ : "  + Opositive);
        }
    }
}
