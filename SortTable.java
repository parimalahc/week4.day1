package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement elementTable = driver.findElement(By.id("table_id"));
		List<WebElement> rows = elementTable.findElements(By.tagName("tr"));
		List<String> names = new ArrayList<String>();
		for (int i = 1; i < rows.size(); i++) {
			WebElement currentRow = rows.get(i);
			List<WebElement> columns = currentRow.findElements(By.tagName("td"));
			names.add(columns.get(1).getText());
		}
		Collections.sort(names);
		System.out.println(names);

		rows.get(0).findElement(By.xpath("//th[contains(@aria-label,'Name')]")).click();

		List<WebElement> rows1 = elementTable.findElements(By.tagName("tr"));
		List<String> names1 = new ArrayList<String>();
		for (int i = 1; i < rows1.size(); i++) {
			WebElement currentRow1 = rows1.get(i);
			List<WebElement> columns1 = currentRow1.findElements(By.tagName("td"));
			names1.add(columns1.get(1).getText());
		}
		System.out.println(names1);

		if (names.equals(names1)) {
			System.out.println("Sorting functionality is working fine in the table");
		}
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/main/resources/snaps/img002.jpg");
		FileUtils.copyFile(src, dest);

	}

}
