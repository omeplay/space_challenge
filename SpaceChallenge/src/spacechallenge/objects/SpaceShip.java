package spacechallenge.objects;

public Interface SpaceShip{
        boolean launch();
        boolean land();

        boolean canCarry(Item item);
        boolean carry(Item item);

        }