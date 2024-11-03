package Code;

import java.util.List;

interface Searchable {
    List<Donor> searchDonors(String bloodGroup, String region, DonationType donationType);
}
