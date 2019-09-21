package browser_Launch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Tables_Excel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		int a = 2;
		int d = 0;
		int c = 0;
		String E=null;

		while (a > 0) {
			int b = 0;
			while (a >= d) {
				if (a > 0) {
					b++;
					c = a * b;
					E=a+"*"+b+"="+c;
					System.out.println(E);
					if (b == 10) {
						break;
					}
					for (int i=0; i<=10; i++) {
						File f = new File("E:\\SeleniumClass\\Selenium_Prac\\Tables_list.xlsx");
						FileInputStream fis = new FileInputStream(f);
						XSSFWorkbook book = new XSSFWorkbook(fis);
						XSSFSheet sheet = book.getSheet("Tables");
						sheet.createRow(i).createCell(0).setCellValue(E);
						FileOutputStream fo = new FileOutputStream(f);
						book.write(fo);
						fo.flush();
						fo.close();
					}
				
				}

			}
			a--;
		}
	}
}
