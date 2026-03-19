package demo_DDT_prac;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class LoginPageUsingJSON_ObjectRepo {

	@Test
	public void login() {
		try {
			String data = new String(Files.readAllBytes(
					Paths.get("./src/main/resources/objectRepository/LoginPage.json")
					));
			
//			JSONObject jsonObject = new JSONObject(data);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
