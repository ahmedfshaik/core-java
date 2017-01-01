package edu.home.serializable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/*Case 2: What if super class implements Externalizable:

If superclass implements externalizable ,then it will also have readExternal() and writeExternal() method so it will serialize its own fields in these methods

*/
public class SerializeDeserializeMain9 {

	public static void main(String[] args) {
		// Serialize
		Employee9 emp = new Employee9(101, "Arpit", "CS", "Indian");
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
			emp = (Employee9) in.readObject();
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

class Person9 implements Externalizable {

	String name = "default";
	String nationality;

	public Person9() {
		System.out.println("Person:Constructor");
	}

	public Person9(String name, String nationality) {
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

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {

		out.writeObject(name);
		out.writeObject(nationality);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		nationality = (String) in.readObject();

	}

}

class Employee9 extends Person9 implements Externalizable {

	int employeeId;
	String department;

	public Employee9() {

	}

	public Employee9(int employeeId, String name, String department, String nationality) {
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

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {

		super.writeExternal(out);
		out.writeInt(employeeId);
		out.writeObject(department);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

		super.readExternal(in);
		employeeId = in.readInt();
		department = (String) in.readObject();

	}
}
