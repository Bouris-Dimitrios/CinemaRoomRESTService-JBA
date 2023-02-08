package cinema.dtos;

import cinema.model.Cinema;


public class SimpleSeatDto {
    public static final SimpleSeatDto EMPTY = new SimpleSeatDto(-1,-1,-1);
    private int row;
    private int column;
    private int price;


    public SimpleSeatDto() {
    }

    public SimpleSeatDto(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;

    }

    public static SimpleSeatDto of(Cinema.Seat seat) {

        return new SimpleSeatDto(seat.getRow(), seat.getColumn(), seat.getPrice());
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
