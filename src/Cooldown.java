class Cooldown {
   // private Map<DonationType, Integer> cooldownPeriods; // e.g., {WholeBloodDonation -> 60 days}

    public int getCooldown(DonationType donationType){
        return 0;
    }
    public boolean checkCooldown(Donor donor, DonationType donationType){
        return false;
    }
}