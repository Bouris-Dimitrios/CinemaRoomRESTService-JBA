package cinema.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "INSTANCE" })
public class SeatError {
    private static final String WRONG_COLUMN = "The number of a row or a column is out of bounds!" ;
    private static final String BOOKED_SEAT = "The ticket has been already purchased!";
    private static final String WRONG_TOKEN = "Wrong token!";
    private static final String UNAUTHORIZED = "The password is wrong!";

    
    public static  SeatError INSTANCE = new SeatError();
   
    private  String error;

    private SeatError() {
        this.error = "";
    }

    public synchronized SeatError  wrongColumnError(){
        error = WRONG_COLUMN;
        return this;
    }

    public synchronized SeatError  bookedSeatError(){
        error = BOOKED_SEAT;
        return this;

    }

    public synchronized SeatError  unauthorized(){
        error = UNAUTHORIZED;
        return this;

    }

    public String getError() {
        return error;
    }

    public synchronized SeatError wrongToken() {
        error = WRONG_TOKEN;
        return this;
    }
}
