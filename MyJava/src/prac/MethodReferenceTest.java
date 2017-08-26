package prac;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodReferenceTest {

    public static void main(String[] args) throws Exception {
        final Consumer<List<Integer>> consume = SomeConsumer::consume;
        final Callable<String> callable = SomeSupplier::supply;
        final Supplier<String> supply = SomeSupplier::supply;
        System.out.println("callable = " + callable.call());
        System.out.println("supply = " + supply.get());
        consume.accept(Collections.singletonList(1));

    }

    static class SomeConsumer {
        public static void consume(List<Integer> list) {
            System.out.println("list = " + list);
        }
    }

    static class SomeSupplier {
        public static String supply() {
            return "Something";
        }
    }
}
