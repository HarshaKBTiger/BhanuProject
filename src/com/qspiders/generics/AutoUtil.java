package com.qspiders.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoUtil {

	public static String getProperty(String path,String key)
	{
		String v=null;
		Properties p=new Properties();
		try {
			p.load(new FileInputStream(new File(path)));
			v=p.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}
	public static void getPhoto(WebDriver driver,String folderpath,String name)
	{
	   String path=null;
	   String d=new Date().toString();
	   String dateTime=d.replaceAll(":", "_");
	   path=folderpath+name+dateTime+".png";
	   File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   try {
		FileUtils.copyFile(src, new File(folderpath));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	}
}
