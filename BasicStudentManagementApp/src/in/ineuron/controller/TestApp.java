package in.ineuron.controller;




import java.util.Scanner;



import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;





import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class TestApp {
    public static void main(String[] args) {
    	
    	Scanner in = new Scanner(System.in);
    	
    	while (true) {
    		System.out.println("\nWelcome to Student Management System!!");
    		System.out.println("1. Add a student");
    		System.out.println("2. Update a student");
    		System.out.println("3. Delete a student");
    		System.out.println("4. Display details of a student");
    		System.out.println("5. Exit");
    	
		    System.out.println("Enter the choice:");
		    int ch = in.nextInt();
		    if(ch==1) {
              insertOperation();
		    }
		    else if (ch==2) {
				updateOperation();
			}
		    else if(ch==3) {
		    	deleteOperation();
		    }
		    else if (ch==4) {
			selectOperation();
			}
		    else if (ch==5) {
				System.out.println("Exiting Successfully!!");
				
			    System.exit(0);
		    }
		    else {
		    	System.out.println("Invalid try enter right number");
		    }
		}
	}




	    
	
	
	
	
	
	
	
	
	private static void updateOperation() {
		Scanner sc = null;
		IStudentService stdService = StudentServiceFactory.getIStudentService();
		
		
		
		
		
		//variables used
		String sname = null;
		String saddress = null;
		Integer sage = null;
		
		sc = new Scanner(System.in);
		
		//id
		System.out.println("Enter the id of student:");
		Integer sid = sc.nextInt();
		
		Student std = stdService.searchStudent(sid);
		
		if(std!=null) {
		//name
		System.out.println("Do you want to update the student name[yes/no]:");
		String optionName = sc.next();
		
		if(optionName.equalsIgnoreCase("yes")) {
			System.out.println("Enter the name of student:");
			 sname = sc.next();
			
		}else {
			sname= null;
		}
		
		
		
		
		//address
		System.out.println("Do you want to update the student address[yes/no]:");
		String optionAddress = sc.next();
		if(optionAddress.equalsIgnoreCase("yes")) {
			System.out.println("Enter the address of student:");
			 saddress = sc.next();
			
		}else {
			saddress= null;
		}
	
		
		
		//age
		 System.out.println("Do you want to update the student age[yes/no]:");
			String optionAge = sc.next();

			if(optionAge.equalsIgnoreCase("yes")) {
				System.out.println("Enter the age of student:");
				 sage = sc.nextInt();
				
			}else {
				sage= null;
			}
			
		
		
		String msg = stdService.updateStudent(sid, sname, sage, saddress);
		 if(msg.equalsIgnoreCase("Success")) {
        	 System.out.println("record updated successfully");
         }else {
			System.out.println("record updation failed");
		}
		 
		 
		}else {
			System.out.println("record not available for given id "+sid+" for updation");
		}
	}
	
	
	
	
	private static void deleteOperation() {
		Scanner sc = null;
	    IStudentService	stdService = StudentServiceFactory.getIStudentService();
		
		 sc  = new Scanner(System.in);
	        System.out.print("Enter the id of student:");
	        Integer sid = sc.nextInt();
	         String msg =  stdService.deleteStudent(sid);
	         if(msg.equalsIgnoreCase("Success")) {
	        	 System.out.println("record deleted successfully");
	         }else if (msg.equalsIgnoreCase("not found")) {
	        	 System.out.println("record is not available for given id::"+" "+sid);
				
			}
	         else {
				System.out.println("record deletion failed");
			}
//	         sc.close();
	}
	
	
	
	private static void selectOperation() {
		Scanner sc = null;
	    IStudentService	stdService = StudentServiceFactory.getIStudentService();
		
		 sc  = new Scanner(System.in);
	        System.out.print("Enter the id of student:");
	        Integer sid = sc.nextInt();
	        
	        Student std  =   stdService.searchStudent(sid);
	        
	        if(std!=null) {
	        	System.out.println("sid\tsname\tsage\tsaddress");
	        	System.out.println(std.getSid()+"\t"+std.getSname()+"\t"+std.getSage()+"\t"+std.getSaddress());
	        }
	        else {
				System.out.println("record not found for given id::"+sid);
			}
	}
		
	
	
	
	    private static void insertOperation() {
			Scanner sc = null;
			IStudentService stdService = StudentServiceFactory.getIStudentService();
			
	        sc  = new Scanner(System.in);
	        System.out.print("Enter the name of student:");
	        String sname = sc.next();
	        
	        System.out.print("Enter the age of student:");
	        Integer sage = sc.nextInt();
	        
	        System.out.print("Enter the address of student:");
	        String saddress = sc.next();
	        
			String msg = stdService.addStudent(sname, sage, saddress);
			
			if(msg.equalsIgnoreCase("Success")) {
				System.out.println("record inserted successfully");
			}
			else {
				System.out.println("record insertion failed.....");
			}
			
			
		}
	}


