package spacechallenge.simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import spacechallenge.objects.*;

public class Simulation {
	public static final String PHASE_1 = "phase-1.txt";
	public static final String PHASE_2 = "phase-2.txt";
	
	public static final int ROCKET_U1 = 1;
	public static final int ROCKET_U2 = 2;

	ArrayList<Rocket> fleet;
	ArrayList<Item> items;

	public Simulation() {
		fleet=new ArrayList<>();
		items = new ArrayList<>();
	}

	public ArrayList<Item> loadItems(String dir) throws FileNotFoundException {
		File file = new File(dir);
		Scanner scanner = new Scanner(file);
		String line;

		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			StringTokenizer token = new StringTokenizer(line, "=");

			Item item = new Item(token.nextToken(), Integer.parseInt(token.nextToken()));
			items.add(item);
		}
		return items;
	}

	public void load(int typeRocket) {
		Rocket rocket;
		if(typeRocket==ROCKET_U1)
			rocket = new U1();
		else
			rocket = new U2();
		for (Item item : items) {

			if (rocket.canCarry(item))
				rocket.carry(item);
			else {
				fleet.add(rocket);
				if(typeRocket==ROCKET_U1)
					rocket = new U1();
				else
					rocket = new U2();
				rocket.carry(item);
				
			}
		}
	}


	public double runSimulation(){
		double budget = 0;
		for (Rocket rocket : fleet) {
			do {
				budget += rocket.getCost();
			} while (!(rocket.land() && rocket.launch()));
		}
		return budget;
	}

}
