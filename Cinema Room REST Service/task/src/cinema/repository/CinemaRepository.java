package cinema.repository;

import cinema.dtos.SeatDto;
import cinema.dtos.SimpleSeatDTO;
import cinema.model.Cinema;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class CinemaRepository {
    @Value("${cinema.columns}")
    int columns;
    @Value("${cinema.rows}")
    int rows;

    Cinema cinema;

    @PostConstruct
    void init() {
        cinema = new Cinema(rows, columns);
    }

    public Cinema getCinema() {
        return cinema;
    }


    public SeatDto purchase(int row, int column) {
        return cinema.book(row,column);
    }

    public SimpleSeatDTO returnTicket(String token) {
       return cinema.returnTicket(token);
    }
}
