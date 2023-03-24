package sdbms;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import CustomSorting.SortStudetentByAge;
import CustomSorting.SortStudetentById;
import CustomSorting.SortStudetentByMarks;
import CustomSorting.SortStudetentByName;
import Customexception.InvalidChoiceException;
import Customexception.StudentNotFoundException;

public class SudentMagementSystemImp implements StudentManagementSystem {
	Scanner ip=new Scanner(System.in);
	Map <String,Student> db = new LinkedHashMap<String,Student>();
	@Override
	public void addStudent(){
		System.out.println("enter Student age");
		int age=ip.nextInt();
		System.out.println("enter Student name");
		String name=ip.next();
		System.out.println("enter Student marks");
		int marks=ip.nextInt();
		
		Student std=new Student(name, age, marks);
		db.put(std.getId(), std);
		System.out.println("Student record inserted successfully");
		System.out.println("Student Id is "+std.getId());
	}
	@Override
	public void displayStudent() {
		System.out.println("enter the Student id");
		 String id=ip.next();//String id=ip.nextLine().toUpperCase();
		id=id.toUpperCase();
		
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("Id: "+std.getId());
			System.out.println("Age: "+std.getAge());
			System.out.println("Name: "+std.getName());
//			System.out.println(std);->printing ref var as toString() is Overridden
		}
		else{
			try {
				String message="Student with Id "+id+"  is not Found";
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void displayAllStudent() {
		if(db.size()!=0) {
		Set<String> keys=db.keySet();
		for (String key : keys) {
			System.out.println(db.get(key ));
		}
		}
		else {
			String message="Student records Not Available to Display";
			try {
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}@Override
	public void removeStudent() {
		System.out.println("enter student ID");
		String id=ip.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("student record found");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student record deleted successfully");
		}
		else {
				String message="Student records with Id "+id+" Not available";
				try {
					throw new StudentNotFoundException(message);
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	@Override
	public void removeAllStudent() {
		if(db.size()!=0) {
		System.out.println("Student Record Available: "+db.size());
		db.clear();
		System.out.println(" All Student Record deleted Successfully");
		System.out.println("Student Record Available: "+db.size());
		}
		else {
			String message="Student Database is Empty!";
			try {
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void updateStudent() {
		System.out.println(" enter Student id ");
		String id=ip.next().toUpperCase();
		
		if(db.containsKey(id)) {
			Student s1=db.get(id);
			System.err.println("1.update age\n2.update name\n3.update marks");
			System.out.println("enter choice:");
			int choice=ip.nextInt();
			switch(choice) {
			case 1:
				System.out.println("enter student age");
				int age =ip.nextInt();
				s1.setAge(age);//s1.setAge()
			break;
			case 2:
				System.out.println("enter student name");
				String name =ip.next();
				s1.setName(name);
			break;
			case 3:
				System.out.println("enter student marks");
				int marks =ip.nextInt();
				s1.setMarks(marks);
			break;
			default:
				try {
				String msg="invalid choice, enter valid choice:";
				throw new InvalidChoiceException(msg);
				}
				catch(Exception e) {
				System.out.println(e.getMessage());
				}
			}
		}
		else{
			try {
				String msg="Student with di"+id+" is not found:";
				throw new StudentNotFoundException(msg);
				}
				catch(Exception e) {
				System.out.println(e.getMessage());
				}
			}
		}
	@Override
	public void countStudent() {
		System.out.println("No of Student Record: "+db.size());
	}
	@Override
	public void sortStudent() {
		if(db.size()>=2) {
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key:keys) {
			Student std=db.get(key);
			list.add(std);
		}
		System.out.println("1.sortbyid\n2.sortbyname\n3.sortbyage\n4.sortbyamrks\nenter choicde: ");
		int choice =ip.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(list,new SortStudetentById());
			display(list);
			break;	
		case 2:
			Collections.sort(list,new SortStudetentByName());
			display(list);
			break;
		case 3:
			Collections.sort(list,new SortStudetentByAge());
			display(list);
			break;
		case 4:
			Collections.sort(list,new SortStudetentByMarks());
			display(list);
			break;	
		}
	}
		else {
			String message="No sufficient student objects to compare";
			try {
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
		private static void display(List<Student> list) {
			for(Student s:list) {
				System.out.println(s);
			}
		}
	@Override
	public void getStudentWithLowestMarks() {
		if(db.size()>=2) {
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key:keys) {
			list.add(db.get(key));
		}
		Collections.sort(list,new SortStudetentByMarks());
		System.out.println(list.get(0));
	}
		else {
			String message="No sufficient student objects to compare";
			try {
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void getStudentWithHighestMarks() {
		if(db.size()>=2) {
		Set<String> keys=db.keySet();
		List<Student> list=new ArrayList<Student>();
		for(String key:keys) {
			list.add(db.get(key));
		}
		Collections.sort(list,new SortStudetentByMarks());
		System.out.println(list.get(list.size()-1));
		}
		else{
			String message="No sufficient student objects to compare";
			try {
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
}
}

