package com.apple;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class stringProblem {

	public static Properties prop = new Properties();
	public static String str = null;
	public static char c;
	
	@BeforeClass
	public void load() throws IOException{
		
		File file1 = new File("SearchParams.properties");
		FileInputStream fis = new FileInputStream(file1);
		prop.load(fis);
		str = prop.getProperty("teststring");
		c = prop.getProperty("character").charAt(0);
	}
	
	@Test
	public static void removeCharIterate(){
		String str1 = str;
		try{
			Assert.assertTrue((str1 != null),"String is Null");
			for(int i =0; i< str1.length(); i++){
				if(str1.charAt(i) == c)
					str1 = str1.replace(String.valueOf(c),"");
			}
			System.out.println("ITERATION : Updated String After removing characters : "+str1);
		}
		catch(Throwable e){
			Assert.fail("Length of String null");
		}
	}
  
	@Test
	public static void removeCharOneline(){
		String str2 = str;
		try{
			Assert.assertTrue((str2 != null),"String is Null");
			System.out.println("ONE LINE CODE : Updated String After removing characters : "+str2.replaceAll(String.valueOf(c), ""));
		}
		catch(Throwable e){
			Assert.fail("Length of String null");
		}
	}
}
