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

public class PhoneBookManagerTest {
  public static void main(String[] args) {
    PhoneBookManager phoneBook = new PhoneBookManager();
    phoneBook.add("Tom", "Smith", "(360) 123-4567", "example.com",
                  "1234 Nowhere Dr.", "Bellingham", 98225);
    System.out.println(phoneBook.getSize());

    phoneBook.add("Larry", "Gonzales", "(360) 234-5678", "xample.com",
                  "234 Nowhere Dr.", "Bellingham", 98225);

    phoneBook.add("John", "Apple", "(360) 345-6789", "ample.com",
                  "3456 Nowhere Dr.", "Bellingham", 98225);

    phoneBook.add("Sam", "Taylor", "(360) 987-6543", "mple.com",
                  "5678 Nowhere Dr.", "Bellingham", 98225);

    phoneBook.add("Catherine", "Dala", "(360) 876-5432", "ple.com",
                  "5632 Nowhere Dr.", "Bellingham", 98225);

    System.out.println(phoneBook.getSize());
    System.out.printf(phoneBook.toString());
    System.out.println("================");

    testRemoveAtIndex(phoneBook);
    phoneBook.add(1, "Tom", "Smith", "(360) 123-4567", "example.com",
                  "1234 Nowhere Dr.", "Bellingham", 98225);
    System.out.printf(phoneBook.toString());
    System.out.println("================");

    testFind(phoneBook);
    System.out.println("================");
    System.out.printf(phoneBook.toString());
    System.out.println("================");

    testGetAtIndex(phoneBook);
    System.out.println();
    System.out.println("================");

    System.out.printf(phoneBook.toString());
    System.out.println("================");
    testModifyAtIndex(phoneBook);

    testSortByDataAttribute(phoneBook);
  }

  public static void testSortByDataAttribute(PhoneBookManager phoneBook) {
    System.out.println("================");
    System.out.println("Testing sort()");
    phoneBook.sortByDataAttribute("lName");
    System.out.printf(phoneBook.toString());

    System.out.println("================");
    phoneBook.sortByDataAttribute("fName");
    System.out.printf(phoneBook.toString());

  }

  public static void testRemoveAtIndex(PhoneBookManager phoneBook) {
    System.out.println("Testing removeAtIndex()");
    phoneBook.removeAtIndex(0);
    phoneBook.removeAtIndex(1);
    System.out.printf(phoneBook.toString());
    System.out.println("================");

    phoneBook.removeAtIndex(2);
    System.out.printf(phoneBook.toString());
    System.out.println("================");

    phoneBook.removeAtIndex(2);
    System.out.printf(phoneBook.toString());
    System.out.println("================");
  }

  public static void testFind(PhoneBookManager phoneBook) {
    System.out.println("Testing find()");
    System.out.printf(phoneBook.find("fName", "Tom").toString());
    System.out.println();
    System.out.printf(phoneBook.find("lName", "Taylor").toString());
    System.out.println();
    System.out.printf(phoneBook.find("zip", "98225").toString());
    System.out.println();
  }

  public static void testGetAtIndex(PhoneBookManager phoneBook) {
    System.out.println("Testing getAtIndex()");
    System.out.printf(phoneBook.getAtIndex(1).toString());
    System.out.println();
    System.out.printf(phoneBook.getAtIndex(2).toString());
  }

  public static void testModifyAtIndex(PhoneBookManager phoneBook) {
    System.out.println("Testing modifyAtIndex()");
    System.out.printf(phoneBook.modifyAtIndex(0, "fName", "Lalalala").toString());
    System.out.println();
    System.out.printf(phoneBook.modifyAtIndex(2, "fName", "Dadada").toString());
  }
}
