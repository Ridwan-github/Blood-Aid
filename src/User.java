interface User {
    String getName();
    String getPhoneNumber();

    String getAddress();
    void login(String phoneNumber, String password);
    void logout();
}