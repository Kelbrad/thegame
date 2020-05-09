package net.sgysoft.thegame;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Class representing position of the piece on board. It's identified both by board's square (on which piece is standing)
 * and orientation (in which direction piece is facing).
 */
public class PiecePosition {

    private final Square square;
    private final Orientations orientation;

    public PiecePosition(Square square, Orientations orientation) {
        Preconditions.checkNotNull(square);
        Preconditions.checkNotNull(orientation);

        this.square = square;
        this.orientation = orientation;
    }

    public Square getSquare() {
        return square;
    }

    public Orientations getOrientation() {
        return orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PiecePosition position = (PiecePosition) o;

        return new EqualsBuilder()
                .append(square, position.square)
                .append(orientation, position.orientation)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(square)
                .append(orientation)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("square", square)
                .append("orientation", orientation)
                .toString();
    }

    public String toSimpleString() {
        return this.square.getCoordinate().toSimpleString() + " " + this.orientation.getCode();
    }

}
