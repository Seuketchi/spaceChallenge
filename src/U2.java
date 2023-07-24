import java.util.Random;

public class U2 extends Rocket {
    public U2() {
        super(120_000_000, 18_000, 29_000);
    }

    @Override
    public boolean launch() {
        double random = new Random().nextDouble();
        return random > 0.04 * ((double) getCurrentWeight() /getCargoLimit());
    }

    @Override
    public boolean land() {
        double random = new Random().nextDouble();
        return random > 0.08 * ((double) getCurrentWeight() /getCargoLimit());
    }
}
