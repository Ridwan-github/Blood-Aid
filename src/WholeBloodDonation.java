class WholeBloodDonation implements DonationType {
    private static final int COOLDOWN_PERIOD = 60;

    @Override
    public String getType() { return "Whole Blood"; }

    @Override
    public int getCooldownPeriod() { return COOLDOWN_PERIOD; }
}