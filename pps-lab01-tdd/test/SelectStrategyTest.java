import lab01.tdd.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class SelectStrategyTest {
    CircularList circularList;
    CircularList differentCircularList;
    SelectStrategyFactory selectStrategyFactory;
    @BeforeEach
    void init(){
        selectStrategyFactory = new SelectStrategyFactoryImpl();
        circularList = new CircularListImpl();
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.add(4);
        circularList.add(5);
        circularList.add(6);
        circularList.add(7);
        circularList.add(8);
        circularList.add(9);
        circularList.add(10);
        differentCircularList = new CircularListImpl();
        differentCircularList.add(3);
        differentCircularList.add(9);
        differentCircularList.add(7);
    }

    @Test
    void testNextNotInList(){
        Assertions.assertEquals(Optional.empty(), differentCircularList.next(new EvenSelectStrategy()));
    }

    @Test
    void testNextEven(){
        Assertions.assertEquals(Optional.of(2), circularList.next(selectStrategyFactory.getEvenSelectStrategyInstance()));
        Assertions.assertEquals(Optional.empty(), differentCircularList.next(selectStrategyFactory.getEvenSelectStrategyInstance()));
    }

    @Test
    void testNextOdd(){
        Assertions.assertEquals(Optional.of(1), circularList.next(new OddsSelectStrategy()));
        Assertions.assertEquals(Optional.of(3), differentCircularList.next(new OddsSelectStrategy()));
    }

    @Test
    void testNextMultipleOf(){
        Assertions.assertEquals(Optional.of(2), circularList.next(selectStrategyFactory.getMultipleOfSelectStrategyInstance(2)));
        Assertions.assertEquals(Optional.of(3), circularList.next(selectStrategyFactory.getMultipleOfSelectStrategyInstance(3)));
    }

    @Test
    void testEquals(){
        Assertions.assertEquals(Optional.of(2), circularList.next(selectStrategyFactory.getEqualsSelectStrategyInstance(2)));
        Assertions.assertEquals(Optional.of(3), circularList.next(selectStrategyFactory.getEqualsSelectStrategyInstance(3)));
        Assertions.assertEquals(Optional.empty(), differentCircularList.next(selectStrategyFactory.getEqualsSelectStrategyInstance(2)));
        Assertions.assertEquals(Optional.of(3), differentCircularList.next(selectStrategyFactory.getEqualsSelectStrategyInstance(3)));
    }
}
