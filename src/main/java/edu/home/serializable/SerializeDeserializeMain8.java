package edu.home.serializable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/*Case 1: What if super class does not implement Externalizable:

If superclass does not implements externalizable , you need to serialize superclass 's fields in subclass that implements Externalizable.
*/
public class SerializeDeserializeMain8 {
    
    public static void main(final String[] args) {
        // Serialize
        Employee8 emp = new Employee8(101, "Arpit", "CS", "Indian");
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
            emp = (Employee8) in.readObject();
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

class Person8 {
    
    String name = "default";
    String nationality;
    
    public Person8() {
        System.out.println("Person:Constructor");
    }
    
    public Person8(final String name, final String nationality) {
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
    
}

class Employee8 extends Person8 implements Externalizable {
    
    int employeeId;
    String department;
    
    public Employee8() {
        
    }
    
    public Employee8(final int employeeId, final String name, final String department, final String nationality) {
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
        
        /*
         * since superclass does not implement externalizable, you need to
         * serialize super class field in this class itself
         */
        // superclass fields
        out.writeObject(name);
        out.writeObject(nationality);
        
        // its own fields
        out.writeInt(employeeId);
        out.writeObject(department);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        /*
         * since superclass does not implement externalizable, you need to
         * deserialize super class field in this class itself
         */
        // superclass fields
        name = (String) in.readObject();
        nationality = (String) in.readObject();
        
        // its own fields
        employeeId = in.readInt();
        department = (String) in.readObject();
        
    }
}
