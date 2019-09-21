package browser_Launch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class FaceBook_crid {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		File f=new File("E:\\SeleniumClass\\Selenium_Prac\\Facebook_crid.properties");
		FileOutputStream File_out=new FileOutputStream(f);
		
		Properties prop=new Properties();
		//prop.load(fis);
		

		prop.setProperty("Username", "thejasai.prince@gmail.com");
		prop.setProperty("Password", "$@!thejagupthamucheli");
		
		prop.store(File_out, "");		
		FileInputStream file_input=new FileInputStream(f);
		prop=new Properties();
		
		prop.load(file_input);
		
		String username=prop.getProperty("Username");
		System.out.println("Username is : "+username);


	}

}
