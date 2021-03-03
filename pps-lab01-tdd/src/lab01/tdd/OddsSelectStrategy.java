package lab01.tdd;

public class OddsSelectStrategy implements SelectStrategy{

    @Override
    public boolean apply(int element) {
        return element % 2 == 1;
    }
}
