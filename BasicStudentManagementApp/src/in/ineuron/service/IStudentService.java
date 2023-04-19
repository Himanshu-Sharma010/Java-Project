package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {

	
	//operation to be implemented
		public  String addStudent(String sname, Integer sage, String saddress);
		
		public Student searchStudent(Integer sid);
		
		public String updateStudent(Integer sid, String sname, Integer sage, String saddress);
		
		public String deleteStudent(Integer sid);
	
}