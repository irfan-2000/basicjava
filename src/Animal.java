public class Animal
{
    void speak()
    {
        System.out.println("Some generic animal sound");

    }

}


  class Dog extends Animal {
    void speak() {
        System.out.println("Woof! 🐶");
    }
}

  class Cat extends Animal {
    void speak() {
        System.out.println("Meow! 🐱");
    }
}
