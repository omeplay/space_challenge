package spacechallenge.objects;

import java.awt.print.Printable;

public class U1 extends Rocket{
    public static final int ROCKET_COST=100;
    public static final double ROCKET_WEIGHT=10000;
    public static final double MAX_WEIGHT=18000;

    public U1(){
        super(ROCKET_COST,ROCKET_WEIGHT,MAX_WEIGHT);
    }

    @Override
    public boolean land(){
        landCrushChances= 0.01 * (weight/maxCapacity);
        // comparando con un numero  random para devolver un true or false que dentro del rango  1-100
        if (landCrushChances<= Math.random()){
            // system.out.printl ("U1 Successfully landed")
            return true;
        }
        else
            // system.out.printl ("U1 KAABOOMMMM")
            return false;

    }

    @Override
    public boolean launch(){
        launchExplosionChances= 0.05 * (weight/maxCapacity);

        if (launchExplosionChances<= Math.random()){
            // system.out.printl ("U1 Successfully launched")
            return true;

        }
        else
            // system.out.printl ("U1 KAABOOMMMM")
            return false;
    }
}

