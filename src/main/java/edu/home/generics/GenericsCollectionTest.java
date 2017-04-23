package edu.home.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsCollectionTest {

    public static void addAnimal(List<Animal> animals){ //List<Animal> animals = new ArrayList<Dog>(); //compilation error
        animals.add(new Dog()); //ok
        animals.add(new Cat()); //Ok
      }

      public static void main(String[] args){
        List<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog()); //Ok
        //dogs.add(new Cat()); //C.E since generic types are protected at compile time
        //addAnimal(dogs); //compilation error

        List<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat()); //Ok
       // cats.add(new Dog()); //C.E since generic types are protected at compile time
       // addAnimal(cats); //compilation error

        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog()); //Ok
        animals.add(new Cat()); //Ok
        
        for (Animal animal: animals) {
            System.out.println(animal);
        }
        addAnimal(animals); //Ok
        //addAnimal(cats); // not Ok
        //addAnimal(dogs); //not Ok
      }
}
