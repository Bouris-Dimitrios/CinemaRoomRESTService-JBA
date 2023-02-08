package cinema.service;

import cinema.dtos.SeatDto;
import cinema.dtos.SimpleSeatDto;
import cinema.dtos.StatsDto;
import cinema.model.Cinema;

public interface CinemaServcice {
    Cinema getCinema();

    SeatDto purchase(int row, int column);

    SimpleSeatDto returnTicket(String token);

    StatsDto getStats();
}
