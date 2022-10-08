package com.bmcl.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    private GenericListFilter filter;

    public ListFilterer(GenericListFilter filter){
        this.filter = filter;
    }

    public List<Integer> filtering(List<Integer> list) {
        List<Integer> filteredList = new ArrayList<>();
        for (Integer number : list){
            if ((filter.accept(number))){
                filteredList.add(number);
            }
        }
        return filteredList;
    }
}
