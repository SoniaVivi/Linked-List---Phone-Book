public class PhoneBookNode {
  private String fName;
  private String lName;
  private String phoneNumber;
  private String email;
  private String steetAddress;
  private String city;
  private int zip;
  private PhoneBookNode next;

  public PhoneBookNode(String fName, String lName, String email,
                       String phoneNumber, String streetAddress, String city,
                       int zip) {
    this.fName = fName;
    this.lName = lName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.steetAddress = streetAddress;
    this.city = city;
    this.zip = zip;
    this.next = null;
  }

  public PhoneBookNode(String fName, String lName, String email,
                       String phoneNumber, String streetAddress, String city,
                       int zip, PhoneBookNode next) {
    this.fName = fName;
    this.lName = lName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.steetAddress = streetAddress;
    this.city = city;
    this.zip = zip;
    this.next = next;
  }

  public String getFName() {
    return this.fName;
  }

  public String getLName() {
    return this.lName;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public String getEmail() {
    return this.email;
  }

  public String getStreetAddress() {
    return this.steetAddress;
  }

  public String getCity() {
    return this.city;
  }

  public int getZip() {
    return this.zip;
  }

  public PhoneBookNode getNext() {
    return this.next;
  }

  public void setFName(String fName) {
    this.fName = fName;
  }

  public void setLName(String lName) {
    this.lName = lName;
  }

  public void setPhoneNumber(String phoneNumber) {
     this.phoneNumber = phoneNumber;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setStreetAddress(String streetAddress) {
    this.steetAddress = streetAddress;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setZip(int zip) {
   this.zip = zip;
  }

  public void setNext(PhoneBookNode next) {
    this.next = next;
  }


}
