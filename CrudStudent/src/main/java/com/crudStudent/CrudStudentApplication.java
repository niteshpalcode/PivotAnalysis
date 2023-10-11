package com.crudStudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudStudentApplication.class, args);
		System.out.println("Application is running");
	}

}
