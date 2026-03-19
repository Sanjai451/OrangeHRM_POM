package demo_DDT_prac;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class GetDataFromCSV {
	String FILE_PATH = "./src/test/resources/orange_hrm_recruitment_vacancy_testdata/sample.csv";
	String SEPERATOR = ",";
	HashMap<String, String> data;
	
	public void readCSVData() {
		data = new HashMap<String, String>();
		data.put("username", "");
		data.put("password", "");
		data.put("url", "");
		data.put("browser", "");
		try {
			BufferedReader bufferedReader = 
					new BufferedReader(new FileReader(FILE_PATH));
			
			String line = "";
			
			while((line = bufferedReader.readLine()) != null) {
				String[] splittedData = line.split(SEPERATOR);
				System.out.println(splittedData[0] + " : " + splittedData[1]);
				data.put(splittedData[0] , splittedData[1]);
//				System.out.println(line);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void loginOrange() {
		readCSVData();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage loginPage = new LoginPage(driver);
		
		driver.get(data.get("url"));
		
		loginPage.login(data.get("username"), data.get("password"));
	}
}
