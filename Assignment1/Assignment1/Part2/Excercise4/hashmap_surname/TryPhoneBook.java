package hashmap_surname;

class TryPhoneBook {
  public static void main(String[] args) {
    PhoneBook book = new PhoneBook();                 // The phone book
    FormattedInput in = new FormattedInput();         // Keyboard input
    Person someone;
    BookEntry []entries = null;

    for(;;) {
      System.out.println("Enter 1 to enter a new phone book entry\n"+
                         "Enter 2 to find the number for a name\n"+
                         "Enter 3 to find the name for a number\n"+
                         "Enter 4 to find the numbers for a second name\n"+
                         "Enter 9 to quit.");

      int what = in.intRead();
      switch(what) {
        case 1:
          book.addEntry(BookEntry.readEntry());
          break;
        case 2:
          someone = Person.readPerson();
          BookEntry entry = book.getEntry(someone);
          if(entry == null)
            System.out.println("The number for " + someone +
                               " was not found. ");
          else           
            System.out.println("The number for " + someone +
                               " is " + book.getEntry(someone).getNumber());
          break;
        case 3:
        	PhoneNumber number = PhoneNumber.readNumber();
            entry = book.getEntry(number);
            if(entry == null)
                System.out.println("No entry for the number "+number +
                                 " was found.");
              else           
                System.out.println("The name corresponding to the number "+number +
                                 " is " + book.getEntry(number).getPerson());
              break;
        case 4:
            // Get the second name
                System.out.println("\nEnter second name:");
                String name = in.readString().trim();
                entries = book.getEntries(name);
                if(entries.length == 0) {
                  System.out.println("No entries found for "+name);
                } else {
                System.out.println("Entries found for "+name+":");
                  for(int i = 0 ; i<entries.length ; i++)
                    System.out.println("\n"+ entries[i]);
                }

            break;
        case 9:
          System.out.println("Ending program.");
          return;
        default:
          System.out.println("Invalid selection, try again.");
          break;
      }
    }
  }
}
