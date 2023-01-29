package cinema.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Cinema {

    @JsonProperty("total_rows")
    private int rows;

    @JsonProperty("total_columns")
    private int columns;

    @JsonProperty("available_seats")
    private List<Seat> seats = new ArrayList<>();

    public Cinema(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < columns; j++) {
                seats.add(new Seat(i + 1, j + 1));
            }
        }
    }


    class Seat {

        private int row;

        private int column;

        public Seat(int row, int column) {
            this.row = row;
            this.column = column;

        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        @Override
        public String toString() {
            return "Seat{" +
                    "row=" + row +
                    ", column=" + column +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "Cinema{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", seats=" + seats +
                '}';
    }
}
