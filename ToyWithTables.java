package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToyWithTables {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement elementTable = driver.findElement(By.id("table_id"));
		List<WebElement> rows = elementTable.findElements(By.tagName("tr"));
		System.out.println("Rows count: " + rows.size());
		List<WebElement> columns = rows.get(2).findElements(By.tagName("td"));
		System.out.println("Columns count: " + columns.size());
		System.out.println("Progress value of Learn to interact with Elements: " + columns.get(1).getText());

		List<WebElement> columns1 = rows.get(3).findElements(By.tagName("td"));
		columns1.get(2).findElement(By.tagName("input")).click();
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/main/resources/snaps/img001.jpg");
		FileUtils.copyFile(src, dest);

	}

}
