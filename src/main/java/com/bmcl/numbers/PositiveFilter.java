package com.bmcl.numbers;

public class PositiveFilter implements GenericListFilter {
    @Override
    public boolean accept(Integer number){
        if (number>=0){
            return true;
        }else{
            return false;
        }
    }
}
