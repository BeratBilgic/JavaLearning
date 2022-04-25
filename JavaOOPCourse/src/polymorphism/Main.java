package polymorphism;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal("animal"); 
        Animal bird1 = new Bird("Limon");
        Animal dog1 = new Dog("Karabaş");
        Animal horse1 = new Horse("Şahbatur");
        
        animal1.speak();
        bird1.speak();
        dog1.speak();
        horse1.speak();
    }
}
