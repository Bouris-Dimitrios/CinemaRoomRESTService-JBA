package cinema.service;

import cinema.dtos.SeatDto;
import cinema.dtos.SimpleSeatDto;
import cinema.dtos.StatsDto;
import cinema.model.Cinema;

import cinema.repository.CinemaRepository;

import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaServcice{
    private final CinemaRepository repo;
    private final StatsService statsService;
    public CinemaServiceImpl(CinemaRepository repo, StatsService statsService) {
        this.repo = repo;
        this.statsService = statsService;
    }

    @Override
    public Cinema getCinema() {
        return repo.getCinema();
    }

    @Override
    public SeatDto purchase(int row, int column) {
        return repo.purchase(row ,column);
    }

    @Override
    public SimpleSeatDto returnTicket(String token) {
       return repo.returnTicket(token);
    }

    @Override
    public StatsDto getStats() {
        return statsService.computeStats(repo.getCinema());
    }
}
