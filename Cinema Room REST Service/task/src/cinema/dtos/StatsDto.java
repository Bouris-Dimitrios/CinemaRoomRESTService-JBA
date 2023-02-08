package cinema.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatsDto {
    @JsonProperty("current_income")
    private final int currentIncome;
    @JsonProperty("number_of_available_seats")
    private final int availableSeats;
    @JsonProperty("number_of_purchased_tickets")
    private final int numberOfPurchasedTickets;

    private StatsDto(int currentIncome, int availableSeats, int numberOfPurchasedTickets) {
        this.currentIncome = currentIncome;
        this.availableSeats = availableSeats;
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;

    }

    public static StatsDto of(int currentIncome, int availableSeats, int numberOfPurchasedTickets) {
        return new StatsDto(currentIncome, availableSeats, numberOfPurchasedTickets);
    }

    @Override
    public String toString() {
        return "StatsDto{" +
                "currentIncome=" + currentIncome +
                ", availableSeats=" + availableSeats +
                ", numberOfPurchasedTickets=" + numberOfPurchasedTickets +
                '}';
    }
}
