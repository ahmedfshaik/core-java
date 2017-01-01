package edu.home.serializable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;


/*If you already have serializable,why you need externalizable at all!!:

When you serialize any object using serializable, apart from fields, all objects that belong to object map and that can be reached using instance variable will also be serialized .for example :
If you have Employee class and its superclass is person then it will serialize all superclass objects (such as person) until it reaches "Object" class.
Similarly if Employee has instance variable of address class then it will serialize whole object map of address also .
           Do you really want this much overhead when all you want to serialize is employeeId and  employeeName 
JVM uses reflection when you use serializable which is quite slow.
While serializing,information about class description which incluses description of its superclass and instance variable associated with that class also get stored in stream.Again this is also a performance issue

*/

public class SerializeDeserializeMain7 {

	public static void main(String[] args) {
		Employee7 emp = new Employee7();
		emp.setEmployeeId(101);
		emp.setEmployeeName("Arpit");
		emp.setDepartment("CS");

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
			emp = (Employee7) in.readObject();
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

	}

}

class Employee7 implements Externalizable {

	int employeeId;
	String employeeName;
	String department;
	String nationality;

	public Employee7() {

	}

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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		employeeId = in.readInt();
		employeeName = (String) in.readObject();

	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {

		out.writeInt(employeeId);
		out.writeObject(employeeName);
	}
}
