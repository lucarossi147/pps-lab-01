package lab01.tdd;

public interface SelectStrategyFactory {

    EvenSelectStrategy getEvenSelectStrategyInstance();

    EqualsSelectStrategy getEqualsSelectStrategyInstance(int equalTo);

    MultipleOfSelectStrategy getMultipleOfSelectStrategyInstance(int multipleOf);
}
