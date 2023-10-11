package com.crudStudent.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import com.crudStudent.model.Student;

public interface StudentService {

//	public void uploadFile(MultipartFile file);
//
//	List<Student> getExcelDataAsList();
//
//	int saveExcelData(List<Student> students);
	
	
	public void readData( Workbook workbook) ;
}
