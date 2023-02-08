package cinema.service;

import cinema.dtos.StatsDto;
import cinema.model.Cinema;

import java.util.List;

public interface StatsService {
   StatsDto computeStats(Cinema cinema);
}
