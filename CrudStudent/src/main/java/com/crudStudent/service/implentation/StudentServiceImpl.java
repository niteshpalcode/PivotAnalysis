package com.crudStudent.service.implentation;

import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudStudent.model.Student;
import com.crudStudent.repository.StudentRepository;
import com.crudStudent.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;
	XSSFWorkbook workbook1 = new XSSFWorkbook();
	XSSFSheet sheet1 = workbook1.createSheet("student Details");

	@Override
	public void readData(Workbook workbook) {
		// TODO Auto-generated method stub
		Sheet sheet = workbook.getSheetAt(0);
		
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
		    Row row = sheet.getRow(i);
		    int rollNumber = (int) row.getCell(7).getNumericCellValue();
		    
		    Optional<Student> existingStudentOptional = studentRepository.findByRollNumber(rollNumber);
		    
		    if (existingStudentOptional.isPresent()) {
		        System.out.println("Student with roll number " + rollNumber + " already exists. Skipping.");
		        continue; 
		    }

		    
		    Student student = new Student();
		    student.setFirstName(row.getCell(1).getStringCellValue());
		    Cell c1 = row.getCell(2);
		    if (c1 != null) {
		        student.setLastName(row.getCell(2).getStringCellValue());
		    } else {
		        student.setLastName(null);
		    }
		    student.setAge((int) row.getCell(3).getNumericCellValue());
		    student.setGender(row.getCell(4).getStringCellValue());
		    student.setEmail(row.getCell(5).getStringCellValue());
		    student.setStandard((int) row.getCell(6).getNumericCellValue());
		    student.setRollNumber(rollNumber);
		    
		  
		    studentRepository.save(student);
		    System.out.println("Student with roll number " + rollNumber + " saved.");
		}

	}

////			student.setId((int) row.getCell(0).getNumericCellValue());
//			System.out.print( row.getCell(0).getNumericCellValue()+" ");
//			student.setFirstName(row.getCell(1).getStringCellValue());
//			System.out.print( row.getCell(1).getStringCellValue()+" ");
//			Cell c1=row.getCell(2);
//			if(c1 != null) {
//			/*if(!row.getCell(2).getStringCellValue().isBlank()) {*/
//			
//				
//				student.setLastName(row.getCell(2).getStringCellValue());
//				System.out.print( row.getCell(2).getStringCellValue()+" ");
//			}else {
//				//System.out.println("there");
//				student.setLastName(null);
//				System.out.print("null");
//				//System.out.print( row.getCell(2).getStringCellValue()+" ");
//			}
//			
//			
//			student.setAge((int) row.getCell(03).getNumericCellValue());
//			System.out.print(row.getCell(03).getNumericCellValue()+" ");
//			student.setGender(row.getCell(4).getStringCellValue());
//			student.setEmail(row.getCell(5).getStringCellValue());
//			student.setStandard((int)row.getCell(6).getNumericCellValue());
//			
//			
//			studentRepository.save(student);
//			System.out.println(" Saved");
//		}
//
//	}

	@Override
	public void addStudent(Student student) {
		Optional<Student> existingStudentOptional = studentRepository.findByRollNumber(student.getRollNumber());
	    
	    if (existingStudentOptional.isPresent()) {
	        System.out.println("Student with roll number " + student.getRollNumber() + " already exists.");
	        
	    }else {
	    	studentRepository.save(student);

			System.out.println("saved!!");
	    }
		
	}

	@Override
	public List<Student> getAll() {
		System.out.println("Before Find all");
		List<Student> list=studentRepository.findAll();
		System.out.println("After Find all");
		return list;
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
