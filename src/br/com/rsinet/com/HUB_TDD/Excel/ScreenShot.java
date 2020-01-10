package br.com.rsinet.com.HUB_TDD.Excel;

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

		public static void getScreenShots(WebDriver driver) throws Exception {
		    File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    File file = new File("Screenshots");

		    if(file.exists()){
		    FileUtils.copyFile(srcfile, new File("target/Print/" + "Screenshot_" + getTimeStamp() + ".png"));
		    }else {
			    System.out.println("Error");
		    }
		}
}
		
		
		
//	    public static void gerarScreenShot(WebDriver driver) {
//
//	        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	        File folder = new File("ScrenShoots");
//	       
//	            try {
//					FileUtils.copyFile(file, new File("target/Print/" + folder  + ".png"));
//				} catch (IOException e) {
//					System.out.println(e.getMessage());
//				}
//	   
//	    }
//}
