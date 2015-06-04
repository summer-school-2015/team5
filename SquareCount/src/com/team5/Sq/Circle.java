package com.team5.Sq;

/**
 * Created by User on 04/06/2015.
 */
public class Circle extends Fig{
    private Double r;

    public Circle(Double d,String s) {
        super(s);
        r=d;
    }

    @Override
    Double square (){
        return Math.PI*r*r;
    }
}
