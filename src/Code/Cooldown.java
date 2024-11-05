package Code;

class Cooldown {
   // private Map<Code.DonationType, Integer> cooldownPeriods; // e.g., {Code.WholeBloodDonation -> 60 days}

    public int getCooldown(DonationType donationType){
        return 0;
    }
    public boolean checkCooldown(Donor donor, DonationType donationType){
        return false;
    }
}