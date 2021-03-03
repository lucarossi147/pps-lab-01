package lab01.tdd;

public class EqualsSelectStrategy implements SelectStrategy{

    private int ref;

    private EqualsSelectStrategy(final int ref){
        this.ref = ref;
    }

    public static EqualsSelectStrategy createEqualsSelectStrategy(final int ref) {
        return new EqualsSelectStrategy(ref);
    }

    @Override
    public boolean apply(int element) {
        return element == ref;
    }
}
