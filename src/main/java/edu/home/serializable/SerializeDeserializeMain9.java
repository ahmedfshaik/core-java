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
    
    public static void main(final String[] args) {
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
            final FileOutputStream fileOut = new FileOutputStream("employee.ser");
            final ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(emp);
            outStream.close();
            fileOut.close();
        } catch (final IOException i) {
            i.printStackTrace();
        }
        
        // Deserialize
        System.out.println("************");
        System.out.println("Deserializing");
        emp = null;
        try {
            final FileInputStream fileIn = new FileInputStream("employee.ser");
            final ObjectInputStream in = new ObjectInputStream(fileIn);
            emp = (Employee9) in.readObject();
            in.close();
            fileIn.close();
        } catch (final IOException i) {
            i.printStackTrace();
            return;
        } catch (final ClassNotFoundException c) {
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
    
    public Person9(final String name, final String nationality) {
        super();
        this.name = name;
        this.nationality = nationality;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public void setNationality(final String nationality) {
        this.nationality = nationality;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        
        out.writeObject(name);
        out.writeObject(nationality);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        nationality = (String) in.readObject();
        
    }
    
}

class Employee9 extends Person9 implements Externalizable {
    
    int employeeId;
    String department;
    
    public Employee9() {
        
    }
    
    public Employee9(final int employeeId, final String name, final String department, final String nationality) {
        super(name, nationality);
        this.employeeId = employeeId;
        this.department = department;
        System.out.println("Employee:Constructor");
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(final int employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(final String department) {
        this.department = department;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        
        super.writeExternal(out);
        out.writeInt(employeeId);
        out.writeObject(department);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        
        super.readExternal(in);
        employeeId = in.readInt();
        department = (String) in.readObject();
        
    }
}
