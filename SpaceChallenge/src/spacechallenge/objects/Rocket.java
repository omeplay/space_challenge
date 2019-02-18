package spacechallenge.objects;

import java.util.ArrayList;
import java.util.List;

import spacechallenge.interfaces.SpaceShip;

public class Rocket implements SpaceShip {
    protected int cost;
    protected double weight;
    protected double maxCapacity;
    double launchExplosionChances;
    double landCrushChances;
    private List<Item> items;

    public Rocket(int cost, double weight, double maxCapacity) {
        this.cost = cost;
        this.weight = weight;
        this.maxCapacity = maxCapacity;
        launchExplosionChances = 0;
        launchExplosionChances = 0;
        items=new ArrayList<Item>();
    }

    public boolean canCarry(Item item){
        if(weight + item.getWeight() <= maxCapacity)
            return true;
        return false;
    }

    public void carry(Item item){
        weight+=item.getWeight();
        items.add(item);
    }

    @Override
    public boolean launch() {
        return false;
    }

    @Override
    public boolean land() {
        return false;
    }

    public int getCost(){
        return cost;
    }
}
