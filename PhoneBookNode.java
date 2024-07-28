// Siona Vivian
// 25/7/24
// CS 143
// Lab 5: Phonebook
/*
  The program is to create a Phone Book using linked lists.
*/
// ============= EXTRA CREDIT ===============
//               Created PhoneBookManager.sort()
// Sources: https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html
//          https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
//          https://stackoverflow.com/questions/6203411/comparing-strings-by-their-alphabetical-order
//          https://www.w3schools.com/java/ref_string_compareto.asp
//          https://en.wikipedia.org/wiki/Gnome_sort


import java.util.*;

public class PhoneBookNode {
  private final Map<String, String> data;
  private int zip;
  private PhoneBookNode next;

  public PhoneBookNode(String fName, String lName, String email,
                       String phoneNumber, String streetAddress, String city,
                       int zip) {
    this.data = new HashMap<String, String>();
    this.data.put("fName", fName);
    this.data.put("lName", lName);
    this.data.put("email", email);
    this.data.put("phoneNumber", phoneNumber);
    this.data.put("streetAddress", streetAddress);
    this.data.put("city", city);
    this.zip = zip;
    this.next = null;
  }

  public PhoneBookNode(String fName, String lName, String email,
                       String phoneNumber, String streetAddress, String city,
                       int zip, PhoneBookNode next) {
    this.data = new HashMap<String, String>();
    this.data.put("fName", fName);
    this.data.put("lName", lName);
    this.data.put("email", email);
    this.data.put("phoneNumber", phoneNumber);
    this.data.put("streetAddress", streetAddress);
    this.data.put("city", city);
    this.zip = zip;
    this.next = next;
  }

  public int getZip() {
    return this.zip;
  }

  public PhoneBookNode getNext() {
    return this.next;
  }

  public void setZip(int zip) {
   this.zip = zip;
  }

  public void setNext(PhoneBookNode next) {
    this.next = next;
  }

  public String getDataAttribute(String key) {
    return this.data.get(key);
  }

  public void setDataAttribute(String key, String value) {
    if (this.data.containsKey(key)) {
      this.data.put(key, value);
    }
  }

  public boolean hasDataAttribute(String key) {
    return this.data.containsKey(key);
  }

  public String toString() {
    String buffer = "%n    ";
    // buffer key data, buffer key data, ...., buffer key data
    return String.format("%s%s: %s%s%s: %s%s%s: %s%s%s: %s%s%s: %s%s%s: %s%s%s: %d",
                          buffer, "First Name", this.data.get("fName"), buffer,
                          "Last Name", this.data.get("lName"), buffer, "Email",
                          this.data.get("email"), buffer, "Phone Number",
                          this.data.get("phoneNumber"), buffer, "Street Address",
                          this.data.get("streetAddress"), buffer, "City",
                          this.data.get("city"), buffer, "Zip", zip);
  }
}
