public class test {
    public static void main(String[] args) {

        B.test();

        B b = new B();
        b.test();

        // A a = new B();
        // a.test();
        
    }
}

class A{
    
}

class B extends A{
    static void test(){

    }
}