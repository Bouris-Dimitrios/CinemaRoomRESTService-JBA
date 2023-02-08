package cinema.model;

import java.util.UUID;

public class Seat {
    private int row;
    private int column;
    private int price;
    private UUID uuid;

    public Seat() {
    }

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.uuid = UUID.randomUUID();
    }

    public static Seat of(Cinema.Seat seat) {

        return new Seat(seat.getRow(), seat.getColumn(), seat.getPrice());
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

    public UUID getUuid() {
        return uuid;
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
