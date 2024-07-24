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

    phoneBook.removeAtIndex(0);
    phoneBook.removeAtIndex(1);
    System.out.println(phoneBook.getSize());
    System.out.printf(phoneBook.toString());
    System.out.println("================");

    phoneBook.removeAtIndex(2);
    System.out.printf(phoneBook.toString());
    System.out.println("================");

    phoneBook.removeAtIndex(2);
    System.out.printf(phoneBook.toString());
    System.out.println("================");

    phoneBook.add(1, "Tom", "Smith", "(360) 123-4567", "example.com",
                  "1234 Nowhere Dr.", "Bellingham", 98225);
    System.out.printf(phoneBook.toString());
    System.out.println("================");

    System.out.printf(phoneBook.find("fName", "Tom").toString());
    System.out.println();
    System.out.printf(phoneBook.find("lName", "Taylor").toString());
    System.out.println();
    System.out.printf(phoneBook.find("zip", "98225").toString());
    System.out.println();
    System.out.println("================");

    System.out.printf(phoneBook.toString());
    System.out.println("================");
    System.out.printf(phoneBook.getAtIndex(1).toString());
    System.out.println();
    System.out.printf(phoneBook.getAtIndex(2).toString());
    System.out.println();
    System.out.println("================");

    System.out.printf(phoneBook.modifyAtIndex(0, "fName", "Lalalala").toString());
    System.out.println();
    System.out.printf(phoneBook.modifyAtIndex(2, "fName", "Dadada").toString());
  }
}
