package classPackage;

public class A {
    String name;
    String nameb;

    public A(String name) {
        this.name = name;
    }

    private A(String a, String b){
        name = a;
        nameb = b;
    }

    private void sayHello(String friendName) {
        System.out.println(name + " say hello to " + friendName);
    }

    protected void showMyName() {
        System.out.println("My name is " + name);
    }

    public void breathe() {
        System.out.println(" take breathe ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + nameb;
    }
}

