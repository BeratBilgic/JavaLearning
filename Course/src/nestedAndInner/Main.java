package nestedAndInner;

public class Main {
    public static void main(String[] args) {
        //NonStatic a = new NonStatic();
        //NonStatic.Inner a1 = a.new Inner();
        // a1.run();

        //Static.Inner b = new Static.Inner();
        //b.run();

        //Local l = new Local();
        //l.run();

        Anonymus anon = new Anonymus(){
            public void run(){
                System.out.println("anon.run");
            }
        };
        anon.run();
    }
}
