import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList circularList;

    @BeforeEach
    void init(){
        circularList = new CircularListImpl();
    }

    @Test
    void testInitiallyEmpty(){
        Assertions.assertTrue(circularList.isEmpty());
    }

    @Test
    void testAdd(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        Assertions.assertEquals(3, circularList.size());
    }

    @Test
    void testNextInitiallyEmpty(){
        Assertions.assertEquals(Optional.empty(),circularList.next());
    }

    @Test
    void testNextWithNonEmptyList(){
        Assertions.assertEquals(Optional.empty(),circularList.next());
        circularList.add(1);
        Assertions.assertEquals(Optional.of(1),circularList.next());
    }

    @Test
    void testNext(){
        Assertions.assertEquals(Optional.empty(),circularList.next());
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        Assertions.assertEquals(Optional.of(1),circularList.next());
        Assertions.assertEquals(Optional.of(2),circularList.next());
        Assertions.assertEquals(Optional.of(3),circularList.next());
        Assertions.assertEquals(Optional.of(1),circularList.next());
    }

    @Test
    void testNextWithAdd(){
        Assertions.assertEquals(Optional.empty(),circularList.next());
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.next();
        circularList.next();
        circularList.next();
        circularList.add(4);
        Assertions.assertEquals(Optional.of(4),circularList.next());
    }

    @Test
    void testPrevious(){
        Assertions.assertEquals(Optional.empty(),circularList.previous());
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        Assertions.assertEquals(Optional.of(1),circularList.previous());
        Assertions.assertEquals(Optional.of(3),circularList.previous());
        Assertions.assertEquals(Optional.of(2),circularList.previous());
        Assertions.assertEquals(Optional.of(1),circularList.previous());
    }

    @Test
    void testPreviousWithAdd(){
        Assertions.assertEquals(Optional.empty(),circularList.previous());
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.previous();
        circularList.previous();
        circularList.previous();
        circularList.previous();
        circularList.add(4);
        Assertions.assertEquals(Optional.of(4),circularList.previous());

    }

    @Test
    void testNextAndPrevious(){
        Assertions.assertEquals(Optional.empty(),circularList.next());
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        Assertions.assertEquals(Optional.of(1),circularList.next());
        Assertions.assertEquals(Optional.of(3),circularList.previous());
    }

    @Test
    void testReset(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.next();
        circularList.next();
        circularList.reset();
        Assertions.assertEquals(Optional.of(1), circularList.next());
    }

}
