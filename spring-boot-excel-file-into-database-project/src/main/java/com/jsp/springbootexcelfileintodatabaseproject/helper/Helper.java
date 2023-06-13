package com.jsp.springbootexcelfileintodatabaseproject.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.springbootexcelfileintodatabaseproject.dto.Student;


public class Helper {

	// to check that file is of excel type or not
			public static boolean checkExcelFormat(MultipartFile file) {
				
				// to get content type of file
				String contentType = file.getContentType();
				// content type of excel:- application/vnd.openxmlformats-officedocument.spreadsheetml.sheet
				if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
					return true;
				}else {
					return false;
				}
			}
			
			// convert excel sheet to list of students
			// Data is taken by inputStream 
			public static List<Student> convertExcelToListOfStudent(InputStream inputStream){
				
				List<Student> list = new ArrayList<>();
				
				try {
				// to read the file, we use apache-poi-Ooxml library
					//  XSSFWorkbook is a class, we create a object of it.
					// here workbook is a sheet,which is upload on Back-end through Api
					XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
					
					XSSFSheet sheet =workbook.getSheet("StudentData");
					
					int rowNumber = 0;
					Iterator<Row> iterator = sheet.iterator();
					
					while(iterator.hasNext()) {
						Row row = iterator.next();
						
						if(rowNumber==0) {
							rowNumber++;
							continue;
						}
						Iterator<Cell> cells = row.iterator();
						
						int cid =0;
						
						Student student = new Student();
						
						while(cells.hasNext()) {
							Cell cell = cells.next();
							switch(cid) {
							case 0:
								student.setStudentId((int)cell.getNumericCellValue());
							break;
							
							case 1:
								student.setStudentName(cell.getStringCellValue());
							break;
							
							case 2:
								student.setStudentEmail(cell.getStringCellValue());
							break;
							
							case 3:
								student.setStudentPhone((long)cell.getNumericCellValue());
							break;
							
							case 4:
								student.setStudentMarks((int)cell.getNumericCellValue());
							break;
							
							default:
								break;
							}
							cid++;
						}
						
						list.add(student);
					}
					
				}catch(Exception e){
					// it is used to if there is any error in code then we know that
					e.printStackTrace();
				}
				return list;
			}
}
