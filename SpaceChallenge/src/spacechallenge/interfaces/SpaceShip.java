package spacechallenge.interfaces;

import spacechallenge.objects.Item;

public interface SpaceShip{
        boolean launch();// devuelve true or false
        boolean land();

        boolean canCarry(Item item);
        void carry(Item item);

        }