import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        LocalDateTime timeBegin = LocalDateTime.now();
        LocalDateTime timeEnd = timeBegin.plusHours(2);

        Stream<Terminal> myTerminal = airport.getTerminals().stream();
        Stream<Flight> myFlight = myTerminal.flatMap(terminal -> terminal.getFlights().stream());

        return myFlight.filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .filter(flight -> LocalDateTime.ofInstant(flight.getDate().toInstant(), ZoneId.systemDefault())
                .isAfter(timeBegin) & LocalDateTime.ofInstant(flight.getDate().toInstant(), ZoneId.systemDefault()).isBefore(timeEnd))
                .collect(Collectors.toList());
    }

}