package spacechallenge.objects;


public class U2 extends Rocket{
    public static final int ROCKET_COST=120;
    public static final double ROCKET_WEIGHT=18000;
    public static final double MAX_WEIGHT=29000;


    public U2(){

        super(ROCKET_COST,ROCKET_WEIGHT,MAX_WEIGHT);

    }
    @Override
    public boolean land(){
        landCrushChances= 0.08 * (weight/maxCapacity);
        if (landCrushChances<= Math.random()){
            // system.out.printl ("U2 Successfully landed")
            return true;
        }
        else
            // system.out.printl ("U2 KAABOOMMMM")
            return false;
    }
    @Override
    public boolean launch(){
        launchExplosionChances= 0.04 * (weight/maxCapacity);
        if (launchExplosionChances<= Math.random()){
            // system.out.printl ("U2 Successfully launched")
            return true;
        }
        else
            // system.out.printl ("U2 KAABOOMMMM")
            return false;
    }

}
