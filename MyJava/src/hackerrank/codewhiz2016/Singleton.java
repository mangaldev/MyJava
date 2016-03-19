package hackerrank.codewhiz2016;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;


class Singleton {

    public String str;
    private static Singleton self = new Singleton();
    private Singleton() {}


    public static Singleton getSingleInstance(){
        return self;
    }
}
