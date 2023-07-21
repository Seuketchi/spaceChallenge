import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation { //reading item data and filling up the rockets

    public ArrayList<Item> loadItems(String filename) {
        ArrayList<Item> items = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileReader(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("=");

                if (parts.length == 2) {
                    String itemName = parts[0].trim(); //itemName
                    int itemWeight = Integer.parseInt(parts[1].trim()); //itemWeight
                    Item item = new Item(itemName, itemWeight);
                    items.add(item);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
        }
        return items;

    }

    public ArrayList<Rocket> loadRocket(ArrayList<Item> items, Rocket rocketType) {
        ArrayList<Rocket> rocket = new ArrayList<>();
        Rocket currentRocket = null;

        for (Item item : items) {
            if (currentRocket == null || !currentRocket.canCarry(item)) {
                currentRocket = rocketType.equals(new U1()) ? new U1() : new U2();
                rocket.add(currentRocket);
            }
            currentRocket.carry(item);
        }
        return rocket;
    }


    public int runSimulation(ArrayList<Rocket> rockets) {
        int totalBudget = 0;

        for (Rocket rocket : rockets) {
            totalBudget += rocket.getCost();

            while (!rocket.launch() || !rocket.land()) {
                totalBudget += rocket.getCost();
            }
        }
        return totalBudget;
    }

}
