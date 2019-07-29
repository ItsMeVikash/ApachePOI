package Apache.POI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcelMain {
	private static final String FILE_PATH = "C:\\Users\\91821\\eclipse-workspace\\Apache POI\\src\\main\\resources\\new.xlsx";

	public static void main(String args[]) {

		List<StudentModel> studentList = getStudentsListFromExcel();
		for (StudentModel studentModel : studentList) {
			System.out.println(studentModel.toString());
		}
		
	}

	private static List<StudentModel> getStudentsListFromExcel() {
		List<StudentModel> studentList = new ArrayList<StudentModel>();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(FILE_PATH);
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(fis);
			int numberOfSheets = workbook.getNumberOfSheets();
			for (int i = 0; i < numberOfSheets; i++) {
				Sheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) {
					StudentModel student = new StudentModel();
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();

					// Iterating over each cell (column wise) in a particular row.
					while (cellIterator.hasNext()) {

						Cell cell =cellIterator.next();
						if (cell.getColumnIndex() == 0) {
							student.setName(cell.getStringCellValue());
						}
						// Cell with index 2 contains marks in Science
						else if (cell.getColumnIndex() == 1) {
							student.setCity(cell.getStringCellValue());
						}
						// Cell with index 3 contains marks in English
						else if (cell.getColumnIndex() == 2) {
							student.setCompany(cell.getStringCellValue());
						}

					}
					// end iterating a row, add all the elements of a row in list
					studentList.add(student);
				}
			}

			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return studentList;
	}

}