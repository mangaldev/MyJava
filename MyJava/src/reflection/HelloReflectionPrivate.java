package reflection;

import greedy.AAA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.System.in;

public class HelloReflectionPrivate {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        BufferedReader br=new BufferedReader(new InputStreamReader(in));
        Object bbbbb = new AAAAA().new BBBBB();
        ((AAAAA.BBBBB) bbbbb).getttttttttttt();

    }

    public void checkPrime(int... num){
        int index = 0;
        while(index < num.length){
            if(isPrime(num[index]))  {
                if(index == num.length - 1)
                    System.out.print(num);
                else
                    System.out.print(num+" ");
            }
        }
        System.out.println();
    }

    private boolean isPrime(int i) {
        return true;
    }

    static class AAAAA {
        private class BBBBB {
            private String getttttttttttt(){
                return "GET";
            }
        }
    }

}

