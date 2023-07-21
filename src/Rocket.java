public class Rocket implements SpaceShip {
    private int cost;
    private int rocketWeight;
    private int maxWeight;
    private int currentWeight;
    private double chanceOfLaunchExplosion;
    private double chanceOfLandingCrash;

    public Rocket(int cost, int rocketWeight, int maxWeight, double chanceOfLaunchExplosion, double chanceOfLandingCrash) {
        this.cost = cost;
        this.rocketWeight = rocketWeight;
        this.maxWeight = maxWeight;
        this.currentWeight = rocketWeight;
        this.chanceOfLaunchExplosion = chanceOfLaunchExplosion;
        this.chanceOfLandingCrash = chanceOfLandingCrash;
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

    protected boolean hasLaunchExplosion() {
        double random = Math.random();
        return random <= chanceOfLaunchExplosion;
    }

    protected boolean hasLandingCrash() {
        double random = Math.random();
        return random <= chanceOfLandingCrash;
    }

    public int getCost() {
        return cost;
    }
}

