package excercise3_hashmap;

import java.io.*;

public class PhoneNumber implements Serializable {
  public PhoneNumber(String areacode, String number) {
    this.areacode = areacode;
    this.number = number;
  }


  // Read a phone number from the keyboard
  public static PhoneNumber readNumber() {
    FormattedInput in = new FormattedInput();

    // Read in the area code
    System.out.println("\nEnter the area code:");
    String area = Integer.toString(in.intRead());

    // Read in the number
    System.out.println("Enter the local code:");
    String number = Integer.toString(in.intRead());

    System.out.println("Enter the number:");
    number += " " + Integer.toString(in.intRead());

    return new PhoneNumber(area,number);
  }

  public String toString() { return areacode + ' ' + number; }
  
  public int hashCode() {
	    return 7*areacode.hashCode()+13*number.hashCode();
	  }

	  public boolean equals(Object phoneNumber) {
	    PhoneNumber pn = (PhoneNumber)phoneNumber;
	    return areacode.equals(pn.areacode) && number.equals(pn.number);
	  }
  private String areacode;
  private String number;
}
