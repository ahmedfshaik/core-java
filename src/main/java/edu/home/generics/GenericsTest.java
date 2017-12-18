package edu.home.generics;

public class GenericsTest {
    
    public static void main(final String[] args) {
        final Dog[] dogs = new Dog[3];
        dogs[0] = new Dog(); // Ok
        // dogs[1] = new Cat(); //C.E since arrays are protected at compile time
        addDog(dogs); // Ok
        
        final Cat[] cats = new Cat[3];
        cats[0] = new Cat(); // Ok
        // cats[1] = new Dog(); //C.E since arrays are protected at compile time
        addCat(cats); // Ok
        
        final Animal[] animals = new Animal[3];
        animals[0] = new Dog(); // Ok
        animals[1] = new Cat(); // Ok
        addAnimal(animals); // Ok
        
    }
    
    public static void addDog(final Animal[] animals) {
        animals[1] = new Dog(); // ok
        animals[2] = new Cat(); // The code is compiled but throws
                                // ArrayStoreException
        
    }
    
    public static void addCat(final Animal[] animals) {
        
        animals[1] = new Cat(); // ok
        animals[2] = new Dog(); // throws ArrayStoreException
        
    }
    
    public static void addAnimal(final Animal[] animals) {
        
        animals[1] = new Dog(); // ok
        animals[2] = new Cat(); // ok
        
    }
}
