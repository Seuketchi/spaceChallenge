import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Supplier;


public class Simulation {
    public ArrayList<Item> loadItems(String filename) {
        ArrayList<Item> items = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileReader(filename));
            while (scanner.hasNextLine()) {
                String eachItem = scanner.nextLine();
                String[] separateValue = eachItem.split("=");

                Item item = new Item(itemName(separateValue), itemWeight(separateValue));
                items.add(item);

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Item does not exist!");
        }
        return items;
    }

    public String itemName(String[] separateValue) {
        String itemName = null;
        if (separateValue.length == 2) {
            itemName = separateValue[0].trim();
        }
        return itemName;
    }

    public int itemWeight(String[] separateValue) {
        int itemWeight = 0;
        if (separateValue.length == 2) {
            itemWeight = Integer.parseInt(separateValue[1].trim());
        }
        return itemWeight;
    }

    public ArrayList<Rocket> loadRocket(ArrayList<Item> items, Supplier<Rocket> createRocket) {
        ArrayList<Rocket> rocket = new ArrayList<>();
        Rocket currentRocket = null;
        for (Item item : items) {
            if (currentRocket == null || !currentRocket.canCarry(item)) {
                currentRocket = createRocket.get();
                rocket.add(currentRocket);
            }
            currentRocket.carry(item);
        }
        return rocket;
    }
    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        return loadRocket(items, U1::new);
    }
    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        return loadRocket(items, U2::new);
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
