package hashmap_surname;

import java.util.*;

import hashmap_surname.BookEntry;

import java.io.*;

class PhoneBook implements Serializable {
  public void addEntry(BookEntry entry) {
    phonebook.put(entry.getPerson(), entry);
    phonebook.put(entry.getNumber(), entry);
    addNewEntry(entry.getPerson().getSecondname(), entry);
  }

  public BookEntry getEntry(Person key) {
    return (BookEntry)phonebook.get(key);
  }
  private void addNewEntry(Object key, BookEntry entry) {
	    list.add(entry);
	    phonebook.put(key, list);
	  }
  public PhoneNumber getNumber(Person key) {
    return getEntry(key).getNumber();
  }
  public BookEntry getEntry(PhoneNumber key) {
	    return (BookEntry)phonebook.get(key);
	  
	  }
  public BookEntry[] getEntries(Object key) {
	    LinkedList list = (LinkedList)(phonebook.get(key));
	    if(list == null) { 
	      return new BookEntry[0];
	    }else {
	      BookEntry[] entries = new BookEntry[list.size()]; 
	      return (BookEntry[])(list.toArray(entries));
	    }
	  }
  private HashMap phonebook = new HashMap();
  private LinkedList list = new LinkedList();


}

