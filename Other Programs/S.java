class A {
    void meth(){
        System.out.println("This is A");
    }
}
class B extends A{
    @Override
    void meth() {
        System.out.println("This is B");
    }

}

class C extends A {
    @Override
    void meth() {
        System.out.println("This is C");
    }

}
public class S {
    
    public static void main(String args[]){
        new A().meth();
        new B().meth();
        new C().meth();
        A a ;
        a=new A();
        a.meth();
        a = new B();
        a.meth();
        a = new C();
        a.meth();
    }


}
