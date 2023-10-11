package com.crudStudent.controller;



import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.crudStudent.model.Student;
import com.crudStudent.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService service;
	
	
	@GetMapping("/viewpage")
	public String viewPage() {
		System.out.println("View Page");
		return "getdata";
	}
	
	
	@PostMapping("/readdata")
	public String readExcel(@RequestParam("file") MultipartFile file) {
		System.out.println("Method Hit.");
		try {
			Workbook workbook= new XSSFWorkbook(file.getInputStream());
			
			service.readData(workbook);
			System.out.println(workbook);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Successfully");
		
		return "excelData";
	}
	
	
	
	
//	@PostMapping("/addStudent")
//	public String readData(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
//		System.out.println("Method hit");
//
//        service.uploadFile(file);
//
//        redirectAttributes.addFlashAttribute("message",
//            "You have successfully uploaded '"+ file.getOriginalFilename()+"' !");
//    
//		System.out.println("File Added");
//		return"excelData";
//	}
//	 @GetMapping("/saveData")
//	    public String saveExcelData(Model model) {
//	    	
//	    	List<Student> excelDataAsList =service.getExcelDataAsList();
//	    	int noOfRecords =service.saveExcelData(excelDataAsList);
//	    	model.addAttribute("noOfRecords",noOfRecords);
//	    	return "excelData";
//	    }
}
