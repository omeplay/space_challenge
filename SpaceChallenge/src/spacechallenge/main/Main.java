package spacechallenge.main;
import java.io.FileNotFoundException;
import java.util.Scanner;

import spacechallenge.simulation.Simulation;

public class Main {
	public static final int RUN_U1 = 1;
	public static final int RUN_U2 = 2;
	public static final int EXIT = 3;

	public static void show_menu() {

		System.out.println("   MISION TO MARS   ");
		System.out.println("   ====== == ====   ");
		System.out.println("1. Run simulation U1 fleet.");
		System.out.println("2. Run simulation U2 fleet.");
		System.out.println("3. Exit.");

		System.out.println("\nSelect an option: ");

	}

	public static void run_fleet(int option_fleet){
		try {
		Simulation simulation = new Simulation();
		System.out.println("\n\n-------------\n");
		System.out.println("Runnig Simulation Fleet U"+option_fleet);
		simulation.loadItems(Simulation.PHASE_1);
		simulation.loadItems(Simulation.PHASE_2);

		simulation.load(option_fleet);

		System.out.println("TOTAL BUDGET FLEET: " + simulation.runSimulation() + " million");
		System.out.println("\n\n-------------\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("The file doesn't exist...");
		}
	}
	public static void option_menu() {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		while (running) {
			show_menu();			
			int guess = scanner.nextInt();
			switch (guess) {
			case Simulation.ROCKET_U1:
				run_fleet(guess);
				break;
			case Simulation.ROCKET_U2:
				run_fleet(guess);
				break;

			case EXIT:
				running = false;
				break;
			default:
				System.out.println("Option does not exist!");

			}
		}

	}

	public static void main(String[] args) {
			option_menu();
	}
}