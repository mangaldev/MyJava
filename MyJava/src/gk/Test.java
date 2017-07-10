package gk;

/**
 * Created by mdev on 9/5/16.
 */


class Test extends B{

    public int x = 5;

    public Test() {
        x = 6;
    }

    public static void main(String[] args) {
        new Test();

    }

    public void callMe() {
        System.out.println(x);
    }
}

class B{
    public B(){
        System.out.println("Calling B");
        callMe();
    }

    public void callMe(){
        System.out.println("B callme ");
    }
}