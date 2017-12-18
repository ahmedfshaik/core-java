package edu.home.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*Case 3:What if you still want to save state of reference object(e.g above address object):
If you make address transient then during deserialization it will return null.
But what if you still want to have same state as when you have serialized address object.
Java serialization provides a mechnism such that if you have private methods with particular signature then they will get called during serialization and deserialization so we will override writeObject and readObject method of employee class and they will be called during serialization and deserialization of Employee object.
*/
public class SerializeDeserializeMain4 {
    
    public static void main(final String[] args) {
        Employee4 emp = new Employee4();
        emp.setEmployeeId(101);
        emp.setEmployeeName("Arpit");
        emp.setDepartment("CS");
        Address4 address = new Address4(88, "MG road", "Pune");
        emp.setAddress(address);
        // Serialize
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
        emp = null;
        try {
            final FileInputStream fileIn = new FileInputStream("employee.ser");
            final ObjectInputStream in = new ObjectInputStream(fileIn);
            emp = (Employee4) in.readObject();
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
        System.out.println("Deserialized Employee...");
        System.out.println("Emp id: " + emp.getEmployeeId());
        System.out.println("Name: " + emp.getEmployeeName());
        System.out.println("Department: " + emp.getDepartment());
        address = emp.getAddress();
        System.out.println("City :" + address.getCity());
        
    }
    
}

class Employee4 implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private int employeeId;
    private String employeeName;
    private String department;
    transient Address4 address;
    
    public int getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(final int employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getEmployeeName() {
        return employeeName;
    }
    
    public void setEmployeeName(final String employeeName) {
        this.employeeName = employeeName;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(final String department) {
        this.department = department;
    }
    
    public Address4 getAddress() {
        return address;
    }
    
    public void setAddress(final Address4 address) {
        this.address = address;
    }
    
    private void writeObject(final ObjectOutputStream os) throws IOException, ClassNotFoundException {
        try {
            os.defaultWriteObject();
            os.writeInt(address.getHomeNo());
            os.writeObject(address.getStreet());
            os.writeObject(address.getCity());
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
    
    private void readObject(final ObjectInputStream is) throws IOException, ClassNotFoundException {
        try {
            is.defaultReadObject();
            final int homeNo = is.readInt();
            final String street = (String) is.readObject();
            final String city = (String) is.readObject();
            address = new Address4(homeNo, street, city);
            
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
    
}

class Address4 {
    
    private int homeNo;
    private String street;
    private String city;
    
    public Address4(final int homeNo, final String street, final String city) {
        super();
        this.homeNo = homeNo;
        this.street = street;
        this.city = city;
    }
    
    public int getHomeNo() {
        return homeNo;
    }
    
    public void setHomeNo(final int homeNo) {
        this.homeNo = homeNo;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(final String street) {
        this.street = street;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(final String city) {
        this.city = city;
    }
}
