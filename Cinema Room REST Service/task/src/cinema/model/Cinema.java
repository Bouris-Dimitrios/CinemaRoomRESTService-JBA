package cinema.model;


import cinema.dtos.SeatDto;
import cinema.dtos.SimpleSeatDto;
import cinema.dtos.StatsDto;
import cinema.exceptions.SeatBookedException;
import cinema.exceptions.UuidNotIdentifiedException;
import cinema.exceptions.WrongColumnRowException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cinema {

    @JsonProperty("total_rows")
    private int rows;

    @JsonProperty("total_columns")
    private int columns;

    @JsonProperty("available_seats")
    private List<Seat> seats = new ArrayList<>();

    public Cinema(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < columns; j++) {
                seats.add(new Seat(i + 1, j + 1));
            }
        }
    }

    public SeatDto book(int row, int column) {

        if(row > this.rows || row < 0 || column > columns || column <0 ){
            throw new WrongColumnRowException("The number of a row or a column is out of bounds!");
        }
        int index =((row -1)* columns + column)-1;
        Seat seat = seats.get(index);

        if(seat.isBooked()){
            throw new SeatBookedException("The ticket has been already purchased!");
        }
        seat.setBooked(true);
        return SeatDto.of(seat);
    }

    public SimpleSeatDto returnTicket(String token) {
        for(Seat seat : seats){
            if(seat.getUuid().toString().equals(token)){
                seat.booked = false;
                return SimpleSeatDto.of(seat);
            }
        }
       throw new UuidNotIdentifiedException("Wrong token!");
    }


    public List<Seat> getSeats(){
        List<Seat> result = new ArrayList<>();
        for(Seat seat : seats){
            result.add (new Seat(seat));
        }
        return result;
    }

    @JsonIgnoreProperties(value = { "booked", "uuid" })
    public
    class Seat {

        private final int row;

        private final int column;

        private  boolean  booked;

        private final int price;

        private final UUID uuid;


        public Seat(int row, int column) {
            this.row = row;
            this.column = column;
            this.booked = false;
            if( row <= 4){
                price = 10;
            }else{
                price = 8;
            }
            this.uuid = UUID.randomUUID();
        }

        private Seat(Seat seat){
            this.row = seat.row;
            this.column = seat.column;
            this.booked = seat.booked;
            this.price = seat.price;
            this.uuid = seat.uuid;
        }
        public int getRow() {
            return row;
        }


        public int getColumn() {
            return column;
        }



        public boolean isBooked() {
            return booked;
        }

        public void setBooked(boolean booked) {
            this.booked = booked;
        }

        public int getPrice() {
            return price;
        }

        public UUID getUuid() {
            return uuid;
        }

        @Override
        public String toString() {
            return "Seat{" +
                    "row=" + row +
                    ", column=" + column +
                    ", booked=" + booked +
                    ", price=" + price +
                    ", uuid=" + uuid +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", seats=" + seats +
                '}';
    }
}
