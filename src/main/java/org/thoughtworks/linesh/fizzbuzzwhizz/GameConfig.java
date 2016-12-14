package org.thoughtworks.linesh.fizzbuzzwhizz;

public class GameConfig {
    private int firstSpecial;

    public GameConfig setFirstSpecial(int firstSpecial) {
        this.firstSpecial = firstSpecial;
        return this;
    }

    public int getFirstSpecial() {
        return firstSpecial;
    }
}
