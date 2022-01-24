package Interface;

public class Main {
    public static void main(String[] args) {
        Building building1 = new Building();
        Human human1 = new Human(165,65);
        
        System.out.println(human1.heightCentimeter());
        System.out.println(human1.heightMetre());
        System.out.println(human1.heightKilometer());
        System.out.println(building1.heightMetre());
    }
}
