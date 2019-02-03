package excercise3_hashmap;

import java.io.*;

public class Person implements Comparable, Serializable {
  // Constructor
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  public Person(String num) {
	  this.num=num;
  }
  public String toString() {
    return firstName + " " + lastName;
  }


  // Compare Person objects
  public int compareTo(Object person) {
    int result = lastName.compareTo(((Person)person).lastName);
    return result == 0 ? firstName.compareTo(((Person)person).firstName):result;
  }


  public boolean equals(Object person) {
    return compareTo(person) == 0;
  }

  public int hashCode() {
	  if(firstName!=null)
	  {
    return 7*firstName.hashCode()+13*lastName.hashCode();
	  }
	return 7*num.hashCode();
  }


  // Read a person from the keyboard
  public static Person readPerson() {
    FormattedInput in = new FormattedInput();
    // Read in the first name and remove blanks front and back
    System.out.println("\nEnter first name:");
    String firstName = in.stringRead().trim();

    // Read in the surname, also trimming blanks
    System.out.println("Enter last name:");
    String surname = in.stringRead().trim();
    return new Person(firstName,surname);
  }
  public static Person readNum() {
	    FormattedInput in = new FormattedInput();
	    // Read in the first name and remove blanks front and back
	    System.out.println("\nEnter first name:");
	    String number = Integer.toString(in.intRead());
	    // Read in the surname, also trimming blanks
	    return new Person(number);
	  }

  private String firstName;    // First name of person
  private String lastName;      // Second name of person
  private String num;      // Second name of person

}
