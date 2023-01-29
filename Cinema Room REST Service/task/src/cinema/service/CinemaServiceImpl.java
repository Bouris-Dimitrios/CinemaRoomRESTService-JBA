package cinema.service;

import cinema.model.Cinema;

import cinema.repository.CinemaRepository;

import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaServcice{
    private CinemaRepository repo;

    public CinemaServiceImpl(CinemaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Cinema getCinema() {
        return repo.getCinema();
    }
}
