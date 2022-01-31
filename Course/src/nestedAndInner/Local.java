package nestedAndInner;

public class Local {
    
    public void run(){
        
        class InnerLocal {
            int a;

            InnerLocal(int a){
                this.a = a;
            }

            public void print(){
                System.out.println(a);
            }   
        }
        
        InnerLocal l = new InnerLocal(10);
        l.print();
    }
}
