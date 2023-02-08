package cinema.dtos;

import cinema.model.Cinema;

import java.util.UUID;


public class SimpleSeatDTO {
    public static final SimpleSeatDTO EMPTY = new SimpleSeatDTO(-1,-1,-1);
    private int row;
    private int column;
    private int price;


    public SimpleSeatDTO() {
    }

    public SimpleSeatDTO(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;

    }

    public static SimpleSeatDTO of(Cinema.Seat seat) {

        return new SimpleSeatDTO(seat.getRow(), seat.getColumn(), seat.getPrice());
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "SeatDto{" +
                "row=" + row +
                ", column=" + column +
                ", price=" + price +
                '}';
    }
}
