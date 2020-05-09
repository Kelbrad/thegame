package net.sgysoft.thegame;

import com.google.common.base.Preconditions;
import net.sgysoft.thegame.exceptions.InvalidValueException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Class representing single square on the board
 */
public class Square {

    private Square left;
    private Square right;
    private Square top;
    private Square bottom;
    private final Coordinate coordinate;

    public Square(Coordinate coordinate) {
        Preconditions.checkNotNull(coordinate);
        this.coordinate = coordinate;
    }

    public void initSiblings(Square left, Square right, Square top, Square bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    public Square getLeft() {
        return left;
    }

    public Square getRight() {
        return right;
    }

    public Square getTop() {
        return top;
    }

    public Square getBottom() {
        return bottom;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Get next (sibling) square in specific orientation
     */
    public Square nextSquare(Orientations orientation) {

        Square nextSquare = null;
        if (orientation == Orientations.NORTH) {
            nextSquare = this.top;
        } else if (orientation == Orientations.EAST) {
            nextSquare = this.right;
        } else if (orientation == Orientations.SOUTH) {
            nextSquare = this.bottom;
        } else if (orientation == Orientations.WEST) {
            nextSquare = this.left;
        } else {
            throw new InvalidValueException("Unsupported orientation: [%s]", orientation);
        }

        return nextSquare == null ? this : nextSquare;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return new EqualsBuilder()
                .append(coordinate, square.coordinate)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(coordinate)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("position", coordinate)
                .toString();
    }

}
