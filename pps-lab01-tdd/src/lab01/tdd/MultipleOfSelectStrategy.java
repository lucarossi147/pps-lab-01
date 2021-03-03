package lab01.tdd;

public class MultipleOfSelectStrategy implements SelectStrategy{

    private int ref;

    private MultipleOfSelectStrategy(final int ref){
        this.ref = ref;
    }

    public static MultipleOfSelectStrategy createMultipleOfSelectStrategy(final int ref) {
        return new MultipleOfSelectStrategy(ref);
    }

    @Override
    public boolean apply(int element) {
        return element % ref == 0;
    }
}
