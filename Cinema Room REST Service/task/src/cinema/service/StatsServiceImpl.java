package cinema.service;

import cinema.dtos.StatsDto;
import cinema.model.Cinema;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsServiceImpl implements StatsService {
    @Override
    public StatsDto computeStats(Cinema cinema) {
        List<Cinema.Seat> seats = cinema.getSeats();
        int currentIncome = computeCurrentIncome(seats);
        int availableSeats = computeAvailableSeats(seats);
        int numberOfPurchasedTickets = computeNumberOfPurchaseTickets(seats);
        return StatsDto.of(currentIncome, availableSeats, numberOfPurchasedTickets);
    }

    private int computeNumberOfPurchaseTickets(List<Cinema.Seat> seats) {
        return (int) seats
                .stream()
                .filter(Cinema.Seat::isBooked)
                .count();
    }

    private int computeAvailableSeats(List<Cinema.Seat> seats) {
        return (int) seats
                .stream()
                .filter(s -> !s.isBooked())
                .count();
    }

    private int computeCurrentIncome(List<Cinema.Seat> seats) {
        return seats
                .stream()
                .filter(Cinema.Seat::isBooked)
                .map(Cinema.Seat::getPrice)
                .reduce(0, Integer::sum);
    }
}
