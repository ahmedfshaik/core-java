package edu.home.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsCollectionTest {
    
    public static void addAnimal(final List<Animal> animals) { // List<Animal>
                                                               // animals
        // = new
        // ArrayList<Dog>();
        // //compilation error
        animals.add(new Dog()); // ok
        animals.add(new Cat()); // Ok
    }
    
    public static void main(final String[] args) {
        final List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog()); // Ok
        // dogs.add(new Cat()); //C.E since generic types are protected at
        // compile time
        // addAnimal(dogs); //compilation error
        
        final List<Cat> cats = new ArrayList<>();
        cats.add(new Cat()); // Ok
        // cats.add(new Dog()); //C.E since generic types are protected at
        // compile time
        // addAnimal(cats); //compilation error
        
        final List<Animal> animals = new ArrayList<>();
        animals.add(new Dog()); // Ok
        animals.add(new Cat()); // Ok
        
        for (final Animal animal : animals) {
            System.out.println(animal);
        }
        addAnimal(animals); // Ok
        // addAnimal(cats); // not Ok
        // addAnimal(dogs); //not Ok
    }
}
