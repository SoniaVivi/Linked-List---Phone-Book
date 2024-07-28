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

  public void sortByDataAttribute(String dataAttribute) {
    ArrayList<PhoneBookNode> list = toArrayList();
    int index = 0;

    while (index < list.size()) {
      // Increase index and continue as there is nothing to compare
      if (index == 0) {
        index += 1;
        continue;
      }

      // Get strings of the data attributes of the nodes at current and prev index
      String currentString = list.get(index).getDataAttribute(dataAttribute);
      String prevString = list.get(index - 1).getDataAttribute(dataAttribute);

      // If current is greater then prev, continue
      if (currentString.compareToIgnoreCase(prevString) >= 1) {
        index += 1;
      } else {
        // If current is smaller, swap the prev and current then decrement index
        // The index will "follow" the smaller until it is in its right position,
        // not smaller than the previous, or is at 0.
        Collections.swap(list, index, index - 1);
        index -= 1;
      }
    }

    // Set head to the first node in list then set the next links of each node
    this.head = list.get(0);
    PhoneBookNode prev = this.head;
    for (PhoneBookNode node : list.subList(1, list.size())) {
      prev.setNext(node);
      prev = node;
    }

    prev.setNext(null);
  }

  private ArrayList<PhoneBookNode> toArrayList() {
    ArrayList<PhoneBookNode> temp = new ArrayList<PhoneBookNode>();
    PhoneBookNode current = this.head;

    while (current.getNext() != null) {
      temp.add(current);
      current = current.getNext();
    }

    if (current != null) {
      temp.add (current);
    }

    return temp;
  }

  private boolean checkNodeValue(PhoneBookNode node, String key, String value) {
    if (key == "zip") {
      return Integer.parseInt(value) == node.getZip();
    }
    return node.getDataAttribute(key).equals(value);
  }
}
