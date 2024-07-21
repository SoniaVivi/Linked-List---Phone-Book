public class PhoneBookManager {
  private PhoneBookNode headNode;

  public PhoneBookManager() {
    this.headNode = null;
  }

  public void add(String fName, String lName, String phoneNumber, String email,
             String streetAddress, String city, int zip) {

    PhoneBookNode newNode = new PhoneBookNode(fName, lName, email, phoneNumber,
                                              streetAddress, city, zip);
    if (headNode == null) {
      this.headNode = newNode;
      return;
    }

    PhoneBookNode current = headNode;

    while (current.getNext() != null) {
      current = current.getNext();
    }

    current.setNext(newNode);

  }

  public void add(int index, String fName, String lName, String phoneNumber,
                  String email, String streetAddress, String city, int zip) {
    PhoneBookNode newNode = new PhoneBookNode(fName, lName, email, phoneNumber,
                                streetAddress, city, zip);

    if (headNode == null) {
      this.headNode = newNode;
      return;
    }

    PhoneBookNode current = headNode;
    int i = 1;

    while (i < index && current.getNext() != null) {
      current = current.getNext();
      i += 1;
    }

    newNode.setNext(current.getNext());
    current.setNext(newNode);
  }

  public PhoneBookNode remove(int index) {
    if (index == 0) {
      if (headNode == null) {
        return null;
      } else {
        PhoneBookNode removedNode = headNode;
        headNode = headNode.getNext();
        return removedNode;
      }
    }

    int i = 1;
    PhoneBookNode current = headNode;

    while (i < index && current.getNext() != null) {
      current = current.getNext();
      i += 1;
    }

    if (current.getNext() == null) {
      return null;
    }

    PhoneBookNode removedNode = current.getNext();

    current.setNext(removedNode.getNext());

    return removedNode;
  }
}
