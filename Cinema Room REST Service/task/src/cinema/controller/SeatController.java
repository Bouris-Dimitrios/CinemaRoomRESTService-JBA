package cinema.controller;


import cinema.dtos.SeatDto;
import cinema.dtos.SimpleSeatDTO;
import cinema.exceptions.SeatBookedException;
import cinema.exceptions.UuidNotIdentifiedException;
import cinema.exceptions.WrongColumnRowException;
import cinema.utils.SeatError;
import cinema.service.CinemaServcice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SeatController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SeatController.class);
    CinemaServcice cinemaServcice;
    ObjectMapper om = new ObjectMapper();

    public SeatController(CinemaServcice cinemaServcice) {
        this.cinemaServcice = cinemaServcice;
    }

    @GetMapping("/seats")
    public String getSeats() throws JsonProcessingException {
        return om.writeValueAsString(cinemaServcice.getCinema());
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchase(@RequestBody SimpleSeatDTO requestBody) throws JsonProcessingException {
        SeatDto result = null;
        try {
            result = cinemaServcice.purchase(requestBody.getRow(), requestBody.getColumn());
        } catch (SeatBookedException e) {
            return new ResponseEntity<>(om.writeValueAsString(SeatError.INSTANCE.bookedSeatError()), HttpStatus.BAD_REQUEST);
        } catch (WrongColumnRowException e1) {
            return new ResponseEntity<>(om.writeValueAsString(SeatError.INSTANCE.wrongColumnError()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(om.writeValueAsString(result), HttpStatus.OK);

    }

    @PostMapping("/return")
    public ResponseEntity<String> returnTicket(@RequestBody String tokenJson) throws JsonProcessingException {
        JsonNode parent = new ObjectMapper().readTree(tokenJson);
        String token = parent.path("token").asText();
        SimpleSeatDTO result = null;
        try {
            result = cinemaServcice.returnTicket(token);


        } catch (UuidNotIdentifiedException e) {
            return new ResponseEntity<>(om.writeValueAsString(SeatError.INSTANCE.wrongToken()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(om.writeValueAsString(Map.of("returned_ticket", result)), HttpStatus.OK);

    }
}
