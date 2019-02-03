/**
 * 
 */
package com.raghavi.insurance.utility;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * @author Raghavi Kirouchenaradjou
 *
 */
public class SendEmail {

	public static void sendEmail(String userEmail, String message) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("contactapplication2018@gmail.com", "springmvc"));
			email.setSSLOnConnect(true);
			email.setFrom("no-reply@msis.neu.edu"); // This user email does not
													// exist
			email.setSubject("Insurance Company - Sanctioned!!! ");
			email.setMsg(message); // Retrieve email from the DAO and send this
			email.addTo(userEmail);
			email.send();
		} catch (EmailException e) {
			System.out.println("Email cannot be sent");
		}
	}
}
