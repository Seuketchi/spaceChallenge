import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();

        //read items in each phase
        ArrayList<Item> phase1Items = simulation.loadItems("src/phase1.txt");
        ArrayList<Item> phase2Items =simulation.loadItems("src/phase2.txt");

        //load items in each phase
        ArrayList<Rocket> u1Phase1Rockets = simulation.loadU1(phase1Items);
        ArrayList<Rocket> u1Phase2Rockets = simulation.loadU1(phase2Items);

        //calculate budget for each phase and each rocket
        int u1Phase1Budget = simulation.runSimulation(u1Phase1Rockets);
        System.out.println("Total budget required for Phase-1 with U1 rockets: $" + u1Phase1Budget);

        int u1Phase2Budget = simulation.runSimulation(u1Phase2Rockets);
        System.out.println("Total budget required for Phase-2 with U1 rockets: $" + u1Phase2Budget);

        ArrayList<Rocket> u2Phase1Rockets = simulation.loadU2(phase1Items);
        ArrayList<Rocket> u2Phase2Rockets = simulation.loadU2(phase2Items);

        int u2Phase1Budget = simulation.runSimulation(u2Phase1Rockets);
        System.out.println("Total budget required for Phase-1 with U2 rockets: $" + u2Phase1Budget);

        int u2Phase2Budget = simulation.runSimulation(u2Phase2Rockets);
        System.out.println("Total budget required for Phase-2 with U2 rockets: $" + u2Phase2Budget);
    }
}
