package cinema.service;

import cinema.dtos.SeatDto;
import cinema.dtos.SimpleSeatDTO;
import cinema.model.Cinema;

public interface CinemaServcice {
    Cinema getCinema();

    SeatDto purchase(int row, int column);

    SimpleSeatDTO returnTicket(String token);
}
