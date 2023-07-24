import java.util.Random;

public class U1 extends Rocket {
    public U1() {
        super(100_000_000, 10_000, 18_000);
    }

    @Override
    public boolean launch() {
        double random = new Random().nextDouble();
        return random > 0.05 * ((double) getCurrentWeight() /getCargoLimit());
    }

    @Override
    public boolean land() {
        double random = new Random().nextDouble();
        return random > 0.01 * ((double) getCurrentWeight() /getCargoLimit());
    }
}
