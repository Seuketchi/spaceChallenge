class U1 extends Rocket {
    public U1() {
        super(100_000_000, 10_000, 18_000, 0.05, 0.01);
    }

    @Override
    public boolean launch() {
        return !hasLaunchExplosion();
    }

    @Override
    public boolean land() {
        return !hasLandingCrash();
    }
}



