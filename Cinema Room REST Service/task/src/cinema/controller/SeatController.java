package cinema.controller;


import cinema.service.CinemaServcice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {

    CinemaServcice cinemaServcice;
    ObjectMapper om = new ObjectMapper();
    public SeatController(CinemaServcice cinemaServcice) {
        this.cinemaServcice = cinemaServcice;
    }

    @GetMapping("/seats")
    public String getSeats() throws JsonProcessingException {
      return  om.writeValueAsString(cinemaServcice.getCinema());
    }

}
