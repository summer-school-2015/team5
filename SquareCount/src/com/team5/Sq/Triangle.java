package com.team5.Sq;

/**
 * Created by User on 04/06/2015.
 */
public class Triangle  extends Fig{
    private Double a;
    private Double c;

    public Triangle(Double d,Double e,String s) {
        super(s);
        a=d;
        c=e;
    }

    @Override
    Double square (){
        return a*c*0.5;
    }
}
