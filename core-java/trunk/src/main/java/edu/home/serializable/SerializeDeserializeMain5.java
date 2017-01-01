package edu.home.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*Case 4: What  if superclass is Serializable?
If superclass is serialzable then all its subclasses are automatically serializable.

Case 5:What if superclass is not Serializable?
If super class is not serializable then we have to handle it quite differently.
If superclass is not serializable then it must have no argument constructor.

Case 6-What if superclass is Serializable but you don't want subclass to be Serializable
If you don't want subclass to serializable then you need to implement writeObject() and readObject() method and need to throw NotSerializableException from this methods.

Case 7-Can you Serialize static variables?
No,you can't.As you know static variable are at class level not at object level and you serialize a object so you can't serialize static variables.
*/
public class SerializeDeserializeMain5 {

	public static void main(String[] args) {
		// Serialize
		Employee5 emp = new Employee5(101, "Arpit", "CS", "Indian");
		System.out.println("Before serializing");
		System.out.println("Emp id: " + emp.getEmployeeId());
		System.out.println("Name: " + emp.getName());
		System.out.println("Department: " + emp.getDepartment());
		System.out.println("Nationality: " + emp.getNationality());
		System.out.println("************");
		System.out.println("Serializing");
		try {
			FileOutputStream fileOut = new FileOutputStream("employee.ser");
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			outStream.writeObject(emp);
			outStream.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		// Deserialize
		System.out.println("************");
		System.out.println("Deserializing");
		emp = null;
		try {
			FileInputStream fileIn = new FileInputStream("employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (Employee5) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("After serializing");
		System.out.println("Emp id: " + emp.getEmployeeId());
		System.out.println("Name: " + emp.getName());
		System.out.println("Department: " + emp.getDepartment());
		System.out.println("Nationality: " + emp.getNationality());
	}

}

class Person5 {

	String name = "default";
	String nationality;

	public Person5() {
		System.out.println("Person:Constructor");
	}

	public Person5(String name, String nationality) {
		super();
		this.name = name;
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}

class Employee5 extends Person5 implements Serializable {
	private static final long serialVersionUID = 1L;
	int employeeId;
	String department;

	public Employee5(int employeeId, String name, String department, String nationality) {
		super(name, nationality);
		this.employeeId = employeeId;
		this.department = department;
		System.out.println("Employee:Constructor");
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
