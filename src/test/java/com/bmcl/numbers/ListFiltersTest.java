package com.bmcl.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListFiltersTest {
    List<Integer> list;

    @BeforeEach
    public void setup() {
        list = Arrays.asList(-1, 0, 2, 4, 7);
    }

    @Test
    public void positives(){
        ListFilterer positivefilter = new ListFilterer(new PositiveFilter());
        List<Integer> positiveList = positivefilter.filtering(list);
        List<Integer> expected = Arrays.asList(0,2,4,7);

        Assertions.assertEquals(expected, positiveList);

    }

    @Test
    public void dividedby(){
        int divider = 2;
        ListFilterer divideFilter = new ListFilterer(new DivisiblebyFilter(divider));
        List<Integer> divideList = divideFilter.filtering(list);
        List<Integer> expected = Arrays.asList(0,2,4);

        Assertions.assertEquals(expected, divideList);
    }

}
