package net.sgysoft.thegame;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Class representing entire board
 */
public class Board {

    private static final Logger LOGGER = LoggerFactory.getLogger(Board.class);

    private final Square[][] squares;

    private PiecePosition currentPosition;
    private List<PiecePosition> positionTrace = new LinkedList<>();

    public Board(Integer size) {

        Preconditions.checkNotNull(size);
        Preconditions.checkArgument(size >= 1);

        this.squares = this.initBoard(size);
        this.setCurrentPosition(
                new PiecePosition(
                        this.getSquare(Coordinate.START),
                        Orientations.NORTH
                )
        );

    }

    private Square getSquare(Coordinate coordinate) {
        return this.squares[coordinate.getY()][coordinate.getX()];
    }

    private Square[][] initBoard(Integer size) {

        Square[][] squares = new Square[size][];
        for (Integer row = 0; row < size; row++) {
            squares[row] = new Square[size];
            for (Integer column = 0; column < size; column++) {
                squares[row][column] = new Square(new Coordinate(column, row));
            }
        }

        for (Integer row = 0; row < size; row++) {
            for (Integer column = 0; column < size; column++) {

                Square square = squares[row][column];
                Square left = column.equals(0) ? null : squares[row][column - 1];
                Square right = column.equals(size - 1) ? null : squares[row][column + 1];
                Square top = row.equals(size - 1) ? null : squares[row + 1][column];
                Square bottom = row.equals(0) ? null : squares[row - 1][column];

                square.initSiblings(left, right, top, bottom);

            }
        }

        return squares;

    }

    private void setCurrentPosition(PiecePosition position) {
        this.positionTrace.add(position);
        this.currentPosition = position;
    }

    public PiecePosition executeCommand(Commands command) {
        this.setCurrentPosition(
                command.executeCommand(this.currentPosition)
        );
        LOGGER.debug("Executed command [{}] new Position [{}]", command.getCode(), this.currentPosition.toSimpleString());
        return this.currentPosition;
    }

    public PiecePosition executeCommands(Commands[] commands) {
        for (Commands command: commands) {
            this.executeCommand(command);
        }
        return this.currentPosition;
    }

}
