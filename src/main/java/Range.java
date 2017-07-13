import java.util.Iterator;
import java.util.List;

public class Range {
    List<Long> list;

    public Range(List<Long> list) {
        this.list = list;
    }

    public boolean isBefore(Range otherRange) {
        return this.list.stream().allMatch(aLong -> otherRange.list.stream().allMatch(aLong1 -> aLong < aLong1));
    }

    public boolean isAfter(Range otherRange) {
        return this.list.stream().allMatch(aLong -> otherRange.list.stream().allMatch(aLong1 -> aLong >= aLong1));
    }

    public boolean isConcurrent(Range otherRange) {
        Long min = this.getLowerBound();
        Long max = this.getUpperBound();
        return otherRange.list.stream().anyMatch(oLong -> oLong > min && oLong < max);
    }

    public long getLowerBound() {
     return this.list.stream().min(Long::compare).get();
    }

    public long getUpperBound() {
        return this.list.stream().max(Long::compare).get();
    }

    public boolean contains(long value) {
        return this.list.stream().anyMatch(aLong -> aLong==value);
    }

    public List<Long> asList() {
        return this.list;
    }

    public Iterator<Long> asIterator() {
        return this.list.iterator();
    }


}