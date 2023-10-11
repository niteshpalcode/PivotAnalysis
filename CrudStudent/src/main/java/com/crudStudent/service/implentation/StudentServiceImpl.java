package com.crudStudent.service.implentation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.crudStudent.model.Student;
import com.crudStudent.repository.StudentRepository;
import com.crudStudent.service.StudentService;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.util.StringUtils;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public void readData(Workbook workbook) {
		// TODO Auto-generated method stub
		Sheet sheet = workbook.getSheetAt(0);

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			Student student = new Student();
			student.setId((int) row.getCell(0).getNumericCellValue());
			System.out.print( row.getCell(0).getNumericCellValue()+" ");
			student.setFirstName(row.getCell(1).getStringCellValue());
			System.out.print( row.getCell(1).getStringCellValue()+" ");
			if(row.getCell(2).getStringCellValue().equals("")) {
				System.out.println("here");
//				student.setLastName(null);
				System.out.print( row.getCell(2).getStringCellValue()+" ");
			}else {
				System.out.println("there");
				student.setLastName(row.getCell(2).getStringCellValue());
				System.out.print( row.getCell(2).getStringCellValue()+" ");
			}
			
			
			student.setAge((int) row.getCell(03).getNumericCellValue());
			System.out.print(row.getCell(03).getNumericCellValue()+" ");
			studentRepository.save(student);
			System.out.println(" Saved");
		}

	}

//	@Value("${app.upload.file:${user.home}}")
//	 public String uploadDir;
//	public String EXCEL_FILE_PATH;

//	Workbook workbook;
//	
//
//	@Override
//	public void uploadFile(MultipartFile file) {
//		 try {
//	            Path copyLocation = Paths
//	                .get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
//	            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            throw new RuntimeException("Could not store file " + file.getOriginalFilename()
//	                + ". Please try again!");
//	        }
//		
//	}
//
//	@Override
//	public List<Student> getExcelDataAsList() {
//		// TODO Auto-generated method stub
//		List<String> list = new ArrayList<String>();
//		DataFormatter dataFormatter = new DataFormatter();
//		try {
//			try {
//				workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));
//			} catch (InvalidFormatException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (EncryptedDocumentException | IOException e) {
//			e.printStackTrace();
//		}
//		Sheet sheet = workbook.getSheetAt(0); 	
//		int noOfColumns = sheet.getRow(0).getLastCellNum();
//		for (Row row : sheet) {
//			for (Cell 	 cell : row) {
//				String cellValue = dataFormatter.formatCellValue(cell);
//				list.add(cellValue);
//			}
//		}
//		List<Student> invList = createList(list, noOfColumns);
//		
//
//		return invList;
//	}
//	private List<Student> createList(List<String> excelData, int noOfColumns) {
//
//		ArrayList<Student> invList = new ArrayList<Student>();
//
//		int i = noOfColumns;
//		do {
//			Student inv = new Student();
//
//			inv.setId(Integer.valueOf(excelData.get(i)));
//			inv.setFirstName(excelData.get(i + 1));
//			inv.setLastName(excelData.get(i + 2));
//			inv.setAge(Integer.valueOf(excelData.get(i + 3)));
//
//			invList.add(inv);
//			i = i + (noOfColumns);
//
//		} while (i < excelData.size());
//		return invList;
//	}
//
//	@Override
//	public int saveExcelData(List<Student> students) {
//		students = studentRepository.saveAll(students);
//		return students.size();
//	}

//	@Override
//	public void readData(File file) throws IOException {
//		// TODO Auto-generated method stub
//		FileInputStream file1 = new FileInputStream(file);
//		XSSFWorkbook workbook = new XSSFWorkbook(file1);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		Iterator<Row> rowIterator = sheet.iterator();
//		while (rowIterator.hasNext()) {
//
//			Row row = rowIterator.next();
//			Iterator<Cell> cellIterator = row.cellIterator();
//			while (cellIterator.hasNext()) {
//
//				Cell cell = cellIterator.next();
//				switch (cell.getCellType()) {
//				case Cell.CELL_TYPE_NUMERIC:
//					System.out.print(cell.getNumericCellValue() + " ");
//					break;
//				case Cell.CELL_TYPE_STRING:
//					System.out.print(cell.getStringCellValue() + " ");
//					break;
//
//				}
//			
//			}
//			System.out.println();
//			
//		}
//		
//		
//	}

}
