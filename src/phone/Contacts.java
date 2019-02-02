package phone;

class Contacts extends MobilePhone {

    private String contactName;
    private String phoneNumber;

    Contacts(String contactName, String phoneNumber) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    String getContactName() {
        return contactName;
    }

    void setContactName(String contactName) {
        this.contactName = contactName;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
