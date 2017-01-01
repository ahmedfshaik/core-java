package edu.home.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDeserializeMain1 {

	public static void main(String[] args) {
		Employee1 emp = new Employee1();
		emp.setEmployeeId(101);
		emp.setEmployeeName("Arpit");
		emp.setDepartment("CS");
		try {
			FileOutputStream fileOut = new FileOutputStream("employee.ser");
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			outStream.writeObject(emp);
			outStream.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		Employee1 empD = null;
		try {
			FileInputStream fileIn = new FileInputStream("employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			empD = (Employee1) in.readObject();
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
		System.out.println("Emp id: " + empD.getEmployeeId());
		System.out.println("Name: " + empD.getEmployeeName());
		System.out.println("Department: " + empD.getDepartment());
	}

}

class Employee1 implements Serializable {
	private static final long serialVersionUID = 1L;
	int employeeId;
	String employeeName;
	String department;

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
}
