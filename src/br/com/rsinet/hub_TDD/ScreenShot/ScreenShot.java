package br.com.rsinet.HUB_TDD.ScreenShot;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	@Rule
	public static String getTimeStamp() {
		String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
		return timestamp;
	}

	public static void getScreenShots(String caminho, WebDriver driver) throws Exception {
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File file = new File("Screenshots");

		if (file.exists()) {
			FileUtils.copyFile(srcfile, new File(caminho + "Screenshot_" + getTimeStamp() + ".png"));
		} else {
			System.out.println("Error");
		}
	}
}