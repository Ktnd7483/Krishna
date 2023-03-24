package sdbms;

public class Student {
	private String id;
	private String name;
	private int age;
	private int marks;
	static int count=101;
	public Student(String name,int age,int marks ) {
		this.id="JSP"+count;
		this.name=name;
		this.age=age;
		this.marks=marks;
		count++;
	}	
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public int getMarks() {
		return marks;
	}
	public void setName(String name)	{
		this.name=name;
	}
	public void setAge(int age)	{
		this.age=age;
	}
	public void setMarks(int marks)	{
		this.marks=marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", marks=" + marks + "]";
	}
	
}
