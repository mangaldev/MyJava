package understanding;

/**
 * Created by mdev on 4/8/15.
 */
public class FinalVariableTest {



    public   int test1 = 5;

    public static void main(String[] args) {

        final FinalVariableTest test = new FinalVariableTest();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinalVariableTest)) return false;

        FinalVariableTest that = (FinalVariableTest) o;

        if (test1 != that.test1) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return test1;
    }
}
