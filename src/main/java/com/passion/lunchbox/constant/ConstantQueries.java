package com.passion.lunchbox.constant;

public class ConstantQueries {

    private ConstantQueries(){
        throw new IllegalStateException("ConstantQueries class");
    }

    public static final String updatePasswordQuery = "update User set password=?2 where id=?1";
}
