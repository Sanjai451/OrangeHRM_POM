package demo_DDT_prac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestIFrames {

	@Test
	public void testIFrame() {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.automationtesting.in/Frames.html");
		
//		driver.switchTo().frame(0); // index
//		driver.switchTo().frame("SingleFrame"); // name
//		driver.switchTo().frame("singleframe"); // id
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='Single']//iframe"))); // Webelement
		
		
		driver.findElement(By.cssSelector("[type='text']")).sendKeys("Sanjai");
	}
}
