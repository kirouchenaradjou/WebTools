package excercise3_hashmap;

import java.util.*;
import java.io.*;

class PhoneBook implements Serializable {
  public void addEntry(BookEntry entry) {
    phonebook.put(entry.getPerson(), entry);
    phonebook.put(entry.getNumber(), entry);
  }

  public BookEntry getEntry(Person key) {
    return (BookEntry)phonebook.get(key);
  }

  public PhoneNumber getNumber(Person key) {
    return getEntry(key).getNumber();
  }
  public BookEntry getEntry(PhoneNumber key) {
	    return (BookEntry)phonebook.get(key);
	  
	  }
  private HashMap phonebook = new HashMap();

}

