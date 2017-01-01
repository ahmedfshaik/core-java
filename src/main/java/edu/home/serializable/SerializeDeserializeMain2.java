package edu.home.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/*Case 1-What if an object has a reference to other objects

We have seen very simple case of serialization,now what if it also a reference to other objects.How will it serialized then? will reference object will also get serialized?.Yes,You don't have to explicitly serialize reference objects.When you serialize any object and if it contain any other object reference then Java serialization serialize that object's entire object graph.
For example:Lets say,Employee now has reference to address object and Address can have reference to some other object(e.g.Home) then when you serialize Employee object all other reference objects such as address and home will be automatically serialized. Lets create Address class  and add object of Address as a reference to above employee class.
*/
public class SerializeDeserializeMain2 {

	public static void main(String[] args) {
		Employee2 emp = new Employee2();
		emp.setEmployeeId(101);
		emp.setEmployeeName("Arpit");
		emp.setDepartment("CS");
		Address2 address = new Address2(88, "MG road", "Pune");
		emp.setAddress(address);
		// Serialize
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
		emp = null;
		try {
			FileInputStream fileIn = new FileInputStream("employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (Employee2) in.readObject();
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
		System.out.println("Deserialized Employee...");
		System.out.println("Emp id: " + emp.getEmployeeId());
		System.out.println("Name: " + emp.getEmployeeName());
		System.out.println("Department: " + emp.getDepartment());
		address = emp.getAddress();
		System.out.println("City :" + address.getCity());

	}

}

class Employee2 implements Serializable {

	private static final long serialVersionUID = 1L;
	private int employeeId;
	private String employeeName;
	private String department;
	private Address2 address;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Address2 getAddress() {
		return address;
	}

	public void setAddress(Address2 address) {
		this.address = address;
	}
}

class Address2 {

	private int homeNo;
	private String street;
	private String city;

	public Address2(int homeNo, String street, String city) {
		super();
		this.homeNo = homeNo;
		this.street = street;
		this.city = city;
	}

	public int getHomeNo() {
		return homeNo;
	}

	public void setHomeNo(int homeNo) {
		this.homeNo = homeNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
