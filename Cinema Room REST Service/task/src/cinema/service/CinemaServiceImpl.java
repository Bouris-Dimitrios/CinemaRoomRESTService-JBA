package cinema.service;

import cinema.dtos.SeatDto;
import cinema.dtos.SimpleSeatDTO;
import cinema.model.Cinema;

import cinema.repository.CinemaRepository;

import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaServcice{
    private final CinemaRepository repo;

    public CinemaServiceImpl(CinemaRepository repo) {
        this.repo = repo;
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
    public SimpleSeatDTO returnTicket(String token) {
       return repo.returnTicket(token);
    }
}
