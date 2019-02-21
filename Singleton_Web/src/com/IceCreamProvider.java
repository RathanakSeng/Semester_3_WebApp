package com;

public class IceCreamProvider {

    private IceCreamProvider() {}

    public static IceCreamProvider newFactory () {
        return new IceCreamProvider();
    }

    public BananaFlavor createBananaFlavor () {
        return new BananaFlavor();
    }

    public ChocolateFlavor createChocolateFlavor () {
        return new ChocolateFlavor();
    }

    public StrawBerryFlavor createStrawBerryFlavor () {
        return new StrawBerryFlavor();
    }
}
