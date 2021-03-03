package lab01.tdd;

public class SelectStrategyFactoryImpl implements SelectStrategyFactory{
    @Override
    public EvenSelectStrategy getEvenSelectStrategyInstance() {
        return new EvenSelectStrategy();
    }

    @Override
    public EqualsSelectStrategy getEqualsSelectStrategyInstance(int equalTo) {
        return EqualsSelectStrategy.createEqualsSelectStrategy(equalTo);
    }

    @Override
    public MultipleOfSelectStrategy getMultipleOfSelectStrategyInstance(int multipleOf) {
        return MultipleOfSelectStrategy.createMultipleOfSelectStrategy(multipleOf);
    }
}
