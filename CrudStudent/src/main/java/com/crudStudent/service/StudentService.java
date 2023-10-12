package com.crudStudent.service;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.crudStudent.model.Student;

public interface StudentService {

//	public void uploadFile(MultipartFile file);
//
//	List<Student> getExcelDataAsList();
//
//	int saveExcelData(List<Student> students);
	
	
	public void readData( Workbook workbook) ;
	
	public void addStudent(Student student);

	public List<Student> getAll();
}
