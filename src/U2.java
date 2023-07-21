class U2 extends Rocket {
    public U2() {
        super(120_000_000, 18_000, 29_000, 0.04, 0.08);
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