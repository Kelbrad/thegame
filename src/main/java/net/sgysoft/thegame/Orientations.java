package net.sgysoft.thegame;

import net.sgysoft.thegame.exceptions.InvalidValueException;

/**
 * Orientation of the piece
 */
public enum Orientations {
    NORTH("N", 0),
    EAST("E", 1),
    SOUTH("S", 2),
    WEST("W", 3);

    private final String code;
    private final Integer index;

    Orientations(String code, Integer index) {
        this.code = code;
        this.index = index;
    }

    public String getCode() {
        return code;
    }

    private Orientations turn(final Integer diff) {

        Integer newIndex = this.index + diff;
        while (newIndex > 3) {
            newIndex = newIndex - 4;
        }
        while (newIndex < 0) {
            newIndex = newIndex + 4;
        }

        return getByIndex(newIndex);

    }

    private static Orientations getByIndex(Integer index) {
        for (Orientations orientations : Orientations.values()) {
            if (orientations.index.equals(index)) {
                return orientations;
            }
        }
        throw new InvalidValueException("Could not find orientation with index: [%s]", index);
    }

    public Orientations turnLeft() {
        return this.turn(-1);
    }

    public Orientations turnRight() {
        return this.turn(1);
    }

}
