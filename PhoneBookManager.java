// Siona Vivian
// 25/7/24
// CS 143
// Lab 5: Phonebook
/*
  The program is to create a Phone Book using linked lists.
*/

public class PhoneBookManager {
  private PhoneBookNode head;
  private int size;

  public PhoneBookManager() {
    this.head = null;
    this.size = 0;
  }

  public void add(String fName, String lName, String phoneNumber, String email,
             String streetAddress, String city, int zip) {
    this.size += 1;
    PhoneBookNode newNode = new PhoneBookNode(fName, lName, email, phoneNumber,
                                              streetAddress, city, zip);
    if (head == null) {
      this.head = newNode;
      return;
    }

    PhoneBookNode current = head;

    // Iterate to end of list
    while (current.getNext() != null) {
      current = current.getNext();
    }

    current.setNext(newNode);
  }

  public void add(int index, String fName, String lName, String phoneNumber,
                  String email, String streetAddress, String city, int zip) {
    this.size += 1;
    PhoneBookNode newNode = new PhoneBookNode(fName, lName, email, phoneNumber,
                                streetAddress, city, zip);

    if (head == null) {
      this.head = newNode;
      return;
    }

    PhoneBookNode current = head;
    int i = 1;

    // Iterate to index
    while (i < index && current.getNext() != null) {
      current = current.getNext();
      i += 1;
    }

    newNode.setNext(current.getNext());
    current.setNext(newNode);
  }

  public PhoneBookNode removeAtIndex(int index) {
    if (index == 0) {
      return remove();
    }

    // Return early if index is greater than number of nodes
    if (index >= this.size) {
      return null;
    }

    int i = 1;
    PhoneBookNode current = head;

    while (i < index && current.getNext() != null) {
      current = current.getNext();
      i += 1;
    }

    this.size -= 1;
    PhoneBookNode removedNode = current.getNext();
    current.setNext(removedNode.getNext());

    return removedNode;
  }

  public PhoneBookNode remove() {
    if (head == null) {
      return null;
    } else {
      this.size -= 1;
      PhoneBookNode removedNode = head;
      head = head.getNext();
      return removedNode;
    }
  }

  public PhoneBookNode find(String attributeName, String attributeValue) {
    if (head == null) {
      return null;
    }

    if (!head.hasDataAttribute(attributeName) && !attributeName.equals("zip")) {
      return null;
    }

    PhoneBookNode current = head;

    // Continue down list until value matches
    while (current.getNext() != null) {
      if (checkNodeValue(current, attributeName, attributeValue)) {
        return current;
      }

      current = current.getNext();
    }

    // Needed as above loop terminates early
    if (checkNodeValue(current, attributeName, attributeValue)) {
      return current;
    }

    return null;
  }

  public PhoneBookNode getAtIndex(int index) {
    if (head == null) {
      return null;
    }

    int i = 0;
    PhoneBookNode current = head;

    // Loop until index
    while (i != index && current.getNext() != null) {
      current = current.getNext();
      i += 1;
    }

    // Needed to see if above loop terminated early
    if (i != index) {
      return null;
    } else {
      return current;
    }
  }

  public int findIndex(String key, String value) {
    if (this.head == null) {
      return -1;
    }

    int i = 0;
    PhoneBookNode current = this.head;

    // Continue down the list until value matches
    while (current.getNext() != null)  {
      if (checkNodeValue(current, key, value)) {
        return i;
      }

      current = current.getNext();
      i += 1;
    }

    // Needed as the while loop does not check if the last node matches
    if (checkNodeValue(current, key, value)) {
      return i;
    }

    return -1;
  }

  public PhoneBookNode modifyAtIndex(int index, String key, String value) {
    if (this.head == null) {
      return null;
    }

    PhoneBookNode current = getAtIndex(index);
    current.setDataAttribute(key, value);
    return current;
  }

  public int getSize() {
    return this.size;
  }

  public String toString() {
    String currentString = "";
    PhoneBookNode currentNode = head;

    while (head != null) {
      currentString += currentNode.toString() + "%n";

      if (currentNode.getNext() == null) {
        return currentString;
      }
      currentNode = currentNode.getNext();
    }

    return currentString;
  }

  private boolean checkNodeValue(PhoneBookNode node, String key, String value) {
    if (key == "zip") {
      return Integer.parseInt(value) == node.getZip();
    }
    return node.getDataAttribute(key).equals(value);
  }
}
