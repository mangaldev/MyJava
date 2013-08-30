package client;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestAnnotation {
    public TestAnnotation() {
        super();
    }
    
    public static void main(String args[]) throws ClassNotFoundException {
        for(Method method: Class.forName("client.WebserviceImpl").getMethods()){
          System.out.println(method);
            if(method.isAnnotationPresent(client.Webservice.class)){
                for(Annotation anno : method.getDeclaredAnnotations()){
                  System.out.println(anno.toString());
                    Webservice oWebService = method.getAnnotation(Webservice.class);
                    System.out.println("Hurrayyyy Got webservice name   :  "+ oWebService.serviceName());
                }
            }
        }
    }
} 
