package com.bmcl.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    List<Integer> list;
    ListAggregator aggregator;

    @BeforeEach
    public void setup(){
        list = Arrays.asList(1,2,4,2,5);
        aggregator = new ListAggregator();
    }

    @Test
    public void sum() {
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        class StubListDeduplicator implements GenericListDeduplicator{
            @Override public List<Integer> deduplicate(List<Integer> list) {
                return Arrays.asList(1,2,4,5);
            }
        }

        StubListDeduplicator deduplicator = new StubListDeduplicator();
        int distinct = aggregator.distinct(list, deduplicator);
        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void bug_report_7263(){
        List<Integer> bug_list_7263 = Arrays.asList(-1,-4,-5);
        int max = aggregator.max(bug_list_7263);
        Assertions.assertEquals(-1, max);
    }

    @Test
    public void bug_report_8726(){
        List<Integer> bug_list_8726 = Arrays.asList(1,2,4,2);
        class StubListDeduplicator implements GenericListDeduplicator{
            @Override public List<Integer> deduplicate(List<Integer> list) {
                return Arrays.asList(1,2,4);
            }
        }

        StubListDeduplicator deduplicator = new StubListDeduplicator();
        int distinct = aggregator.distinct(bug_list_8726, deduplicator);
        Assertions.assertEquals(3, distinct);
    }

    @Test
    public void MockDistinct(){
        List<Integer> bug_list_8726 = Arrays.asList(1,2,4,2);
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1,2,4));

        int distinct = aggregator.distinct(bug_list_8726, deduplicator);
        Assertions.assertEquals(3, distinct);
    }
}

