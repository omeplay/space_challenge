package spacechallenge.interfaces;

import spacechallenge.objects.Item;

public interface SpaceShip{
        boolean launch();
        boolean land();

        boolean canCarry(Item item);
        void carry(Item item);

        }