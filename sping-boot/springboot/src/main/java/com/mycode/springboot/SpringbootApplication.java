package com.mycode.springboot;

// import java.util.Iterator;
// import java.util.List;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

// import com.mycode.springboot.dao.StudentDAO;
// import com.mycode.springboot.entity.Student;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	// it is a hook allow to run code after spring boot application load
	// @Bean
	// public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
	// 	return runner -> {
	// 		// createStudent(studentDAO);
	// 		// readStudent(studentDAO);
	// 		// updateStudent(studentDAO);
	// 		// deleteStudent(studentDAO);
	// 	};
	// }

	// private void deleteStudent(StudentDAO studentDAO) {
	// 	System.out.println("To be delete student");
	// 	studentDAO.delete(13);
	// }

	// private void updateStudent(StudentDAO studentDAO) {
	// 	System.out.println("Retrieve the student");
	// 	Student student = studentDAO.findById(12);

	// 	System.out.println("updating the students");
	// 	student.setFirstName("Scooby");
	// 	student.setLastName("Dobby");
	// 	student.setEmail("scooby.dobby@info.com");

	// 	studentDAO.update(student);

	// 	System.out.println("Updated student:" + student);
	// }

	// private void readStudent(StudentDAO studentDAO) {
	// 	System.out.println("Retrieve the student");
		
	// 	Student newStudent = studentDAO.findById(13);

	// 	System.out.println("Found student" + newStudent);

	// 	List<Student> students = studentDAO.findAll();

	// 	System.out.println("Retrieve all the students");

	// 	Iterator it = students.iterator();

	// 	while(it.hasNext()) {
	// 		System.out.println(it.next());
	// 	}

	// 	System.out.println("Retrieve the students by first name");

	// 	List<Student> filterStudents = studentDAO.findByName("James");
		
	// 	it = filterStudents.iterator();

	// 	while(it.hasNext()) {
	// 		System.out.println(it.next());
	// 	}
	// }

	// private void createStudent(StudentDAO studentDAO) {
	// 	System.out.println("Creating the student");
		
	// 	Student student = new Student("Jaff", "Falk", "jaff.falk@info.com");

	// 	// save the student object
	// 	studentDAO.save(student);

	// 	System.out.println("Created student id: " + student.getId());
	// }

}
