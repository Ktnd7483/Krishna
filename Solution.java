package sdbms;

import java.util.Scanner;

import Customexception.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		System.out.println("welcome to student Manegement System");
		System.out.println("-------------------------------------");
		Scanner ip=new Scanner(System.in);
		StudentManagementSystem sms=new SudentMagementSystemImp();
		while(true) {
			System.out.println("1.Add Student\n2.display student\n3.display all student\n4.remove Student\n5.remove All student"
					+ "\n6.update student\n7.count student\n8.sort student\n9.getStudentWithLowestMarks\n10.getStudentWithHighestMarks\n11.EXIT");
			System.out.println("enter your choice");
			int choice=ip.nextInt();
			switch (choice) {
			case 1: {
				sms.addStudent();
			break;
			}
			case 2: {
				sms.displayStudent();
				break;
			}
			case 3: {
				sms.displayAllStudent();
				break;
			}
			case 4: {
				sms.removeStudent();	
				break;
			}
			case 5: {
				sms.removeAllStudent();
				break;
			}
			case 6: {
				sms.updateStudent();
				break;
			}
			case 7: {
				sms.countStudent();
				break;
			}
			case 8: {
				sms.sortStudent();
				break;
			}
			case 9: {
				sms.getStudentWithLowestMarks();
				break;
			}
			case 10: {
				sms.getStudentWithHighestMarks();
				break;
			}
			case 11: {
				System.out.println("thank you");
				System.exit(0);
				break;
			}
			default:try {
				throw new InvalidChoiceException("Invalid choice, please enter valid choice");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}//end of switch
			System.out.println("----------------");
	}// end of while loop
}// end of main()
}// end of class
