
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;


class RangeTest {
    Range standardRange;
    Range fakeRange;

    @BeforeEach
    void create() {
        standardRange = new Range(Arrays.asList(1L, 5L));
    }

    @Test
    void isBeforeTrue() {
        fakeRange = new Range(Arrays.asList(6L, 7L));
        assertThat(standardRange.isBefore(fakeRange), is(true));
    }

    @Test
    void isBeforeFalse() {
        fakeRange = new Range(Arrays.asList(1L, 4L));
        assertThat(standardRange.isBefore(fakeRange), is(false));
    }

    @Test
    void isAfterTrue() {
        fakeRange = new Range(Arrays.asList(-3L, -4L));
        assertThat(standardRange.isAfter(fakeRange), is(true));
    }
    @Test
    void isAfterFalse() {
        fakeRange = new Range(Arrays.asList(8L, 9L));
        assertThat(standardRange.isAfter(fakeRange), is(false));
    }

    @Test
    void isConcurrentTrue() {
        fakeRange = new Range(Arrays.asList(3L, 9L));
        assertThat(standardRange.isConcurrent(fakeRange), is(true));
    }
    @Test
    void isConcurrentFalse() {
        fakeRange = new Range(Arrays.asList(10L, 9L));
        assertThat(standardRange.isConcurrent(fakeRange), is(false));
    }

    @Test
    void getLowerBoundTrue() {
        assertThat(standardRange.getLowerBound(), is(1L));
    }
    @Test
    void getLowerBoundFalse() {
        assertThat(standardRange.getLowerBound(), not(2L));
    }

    @Test
    void getUpperBoundTrue() {
        assertThat(standardRange.getUpperBound(), is(5L));
    }
    @Test
    void getUpperBoundFalse() {
        assertThat(standardRange.getUpperBound(), not(4L));
    }

    @Test
    void containsTrue() {
        assertThat(standardRange.contains(5), is(true));
    }
    @Test
    void containsFalse() {
        assertThat(standardRange.contains(4), is(false));
    }

    @Test
    void asList() {
        assertThat(standardRange.asList(), is(java.util.List.class));
        assertThat(standardRange.asList(), not(java.util.Deque.class));
    }

    @Test
    void asIteratorClass() {
        assertThat(standardRange.asIterator(), is(java.util.Iterator.class));
        assertThat(standardRange.asIterator(), not(java.util.Iterator.class));
    }
    @Test
    void asIteratorNext() {
        assertThat(standardRange.asIterator().next(), is(1L));
        assertThat(standardRange.asIterator().next(), not(2L));
    }

}