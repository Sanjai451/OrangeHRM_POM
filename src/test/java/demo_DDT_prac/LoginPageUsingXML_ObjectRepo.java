package demo_DDT_prac;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.annotations.Test;
import org.w3c.dom.Document;

public class LoginPageUsingXML_ObjectRepo {
	@Test
	public void loginUsingXML() {
		try {
			File file = new File("./src/main/resources/objectRepository/loginPageData.xml");
			Document document = DocumentBuilderFactory
				.newInstance()
				.newDocumentBuilder()
				.parse(file);
			
			String usernameLocator = document.getElementsByTagName("usernameField").item(0).getTextContent().split(":")[1];
			String passwordLocator = document.getElementsByTagName("passwordField").item(0).getTextContent().split(":")[1];
			String loginButtonLocator = document.getElementsByTagName("loginButtonField").item(0).getTextContent().split(":")[1];
			
			System.out.println(usernameLocator + " " + passwordLocator + " " + loginButtonLocator);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
