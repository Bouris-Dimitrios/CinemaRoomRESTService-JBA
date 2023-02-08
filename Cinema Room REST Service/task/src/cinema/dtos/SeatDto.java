package cinema.dtos;

import cinema.model.Cinema;

import java.util.UUID;

public class SeatDto {
    public static final SeatDto EMPTY = new SeatDto(-1,-1,-1, UUID.randomUUID());

    SimpleSeatDto ticket;
    private UUID token;

    public SeatDto() {
    }

    public SeatDto(int row, int column, int price, UUID uuid) {
        ticket = new SimpleSeatDto(row, column, price);
        this.token = uuid;
    }

    public static SeatDto of(Cinema.Seat seat) {

        return new SeatDto(seat.getRow(), seat.getColumn(), seat.getPrice(), seat.getUuid());
    }

    public SimpleSeatDto getTicket() {
        return ticket;
    }

    public UUID getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "SeatDto{" +
                "ticket=" + ticket +
                ", token=" + token +
                '}';
    }
}
