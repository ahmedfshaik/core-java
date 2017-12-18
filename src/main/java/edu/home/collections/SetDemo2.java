package edu.home.collections;

import java.util.Set;
import java.util.TreeSet;

class Book implements Comparable<Book> {
    private final int id;
    private final String name;
    
    public Book(final int id, final String name) {
        super();
        this.id = id;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return id + " " + name;
    }
    
    /*
     * @Override
     * public int hashCode() {
     * System.out.println("*******");
     * final int prime = 31;
     * int result = 1;
     * result = prime * result + id;
     * result = prime * result + ((name == null) ? 0 : name.hashCode());
     * return result;
     * }
     * 
     * @Override
     * public boolean equals(Object obj) {
     * System.out.println("#######");
     * if (this == obj)
     * return true;
     * if (obj == null)
     * return false;
     * if (getClass() != obj.getClass())
     * return false;
     * Book other = (Book) obj;
     * if (id != other.id)
     * return false;
     * if (name == null) {
     * if (other.name != null)
     * return false;
     * } else if (!name.equals(other.name))
     * return false;
     * return true;
     * }
     */
    
    @Override
    public int compareTo(final Book b) {
        final Integer iRef1 = id;
        final Integer iRef2 = b.id;
        
        return iRef1.compareTo(iRef2);
    }
}

public class SetDemo2 {
    public static void main(final String[] args) {
        final Book b1 = new Book(1, "abc");
        final Book b2 = new Book(2, "xyz");
        final Book b3 = new Book(3, "pqr");
        final Book b4 = new Book(3, "pqr"); // duplicate
        
        // Set<Book> books = new HashSet<Book>();
        // Set<Book> books = new LinkedHashSet<Book>();
        final Set<Book> books = new TreeSet<>();
        
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        
        System.out.println(books.toString());
    }
}
