package browser_Launch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTables {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		File f = new File("Tables_list.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheetAt(0);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the max table value");
		int max = sc.nextInt();
		int r = 0;
		int a = 1;
		while (a <= max) {
			for (int i = 1; i <= 10; i++) {
				String value = a + "*" + i + "=" + a * i;
				System.out.println(value);
				sheet.createRow(r).createCell(0).setCellValue(value);
				r++;
			}
			a++;
		}
		FileOutputStream fo = new FileOutputStream(f);
		book.write(fo);
		fo.flush();
		book.close();

	}

}
