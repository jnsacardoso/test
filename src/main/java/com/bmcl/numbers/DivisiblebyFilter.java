package com.bmcl.numbers;

public class DivisiblebyFilter implements GenericListFilter {
    private int divider;

    DivisiblebyFilter(int divider){
        this.divider = divider;
    }
    @Override
    public boolean accept(Integer number){
        if (number%divider == 0){
            return true;
        }else{
            return false;
        }
    }
}
