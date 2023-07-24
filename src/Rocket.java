public class Rocket implements Spaceship{
    private int cost;
    private int rocketWeight;
    private int maxWeight;
    private int currentWeight;


    public Rocket(int cost, int rocketWeight, int maxWeight) {
        this.cost = cost;
        this.rocketWeight = rocketWeight;
        this.maxWeight = maxWeight;
        this.currentWeight = rocketWeight;
     }


    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return currentWeight + item.getWeight() <= maxWeight;
    }

    @Override
    public void carry(Item item) {
        currentWeight += item.getWeight();
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getCargoLimit() {
        return maxWeight - rocketWeight;
    }

    public int getCost() {
        return cost;
    }
}
