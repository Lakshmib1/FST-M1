package alchemy.activity;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Activity13_2a {

	public XSSFSheet Sheet;
	public XSSFRow Row;

	public void writeExcel(String Filepath) throws IOException {
		ArrayList<String[]> data = new ArrayList<String []>();
		XSSFWorkbook wbook = new XSSFWorkbook();
		Sheet = wbook.createSheet("sheet1");

		String[] heading = {"ID", "First Name", "Last Name", "Email", "Ph.No."};
		String[] row1 = {"1", "Satvik", "Shah", "satshah@example.com", "4537829158"};
		String[] row2 = {"2", "Avinash", "Kati", "avinashK@example.com", "4892184058"};
		String[] row3 = {"3", "Lahri", "Rath", "lahri.rath@example.com", "4528727830"};

		data.add(heading);
		data.add(row1);
		data.add(row2);
		data.add(row3);

		int rownum = 0;
		for (String[] rowdata : data) {
			Row = Sheet.createRow(rownum++);
			int cellnum = 0;
			for (String celldata : rowdata) {
				XSSFCell Cell = Row.createCell(cellnum++);
				Cell.setCellValue(celldata);
			}

		}

		FileOutputStream out;
		try {
			out = new FileOutputStream(new File(Filepath));
			wbook.write(out);
			out.close();
			wbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void readExcel(String Filepath) throws IOException {

		FileInputStream fs = new FileInputStream(Filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheetAt = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = Sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = (Row) rowIterator.next();

			Iterator<Cell> cellIterator = Row.iterator();
			while (cellIterator.hasNext()) {
				Cell cell = (Cell) cellIterator.next();
				switch (cell.getCellType()) {
				case NUMERIC: 
					System.out.print(cell.getNumericCellValue() + " \t ");
					break;
				case STRING: 
					System.out.print(cell.getStringCellValue() + " \t ");
					break;
				default:
					System.out.println("Invalid value");
					break;
				}

			}
			System.out.println("");
		}
		fs.close();
		workbook.close();

	}

	public static void main(String[] args) throws IOException {
		//Prepare the path of excel file
        String filePath = "src/test/resources/sample.xlsx";
 
        //Create an object of current class
        Activity13_2a objExcelFile = new Activity13_2a();
 
        //Write the file using file name, sheet name and the data to be filled
        objExcelFile.writeExcel(filePath);
        
        //Call read file method of the class to read data
        objExcelFile.readExcel(filePath);
	}
}
