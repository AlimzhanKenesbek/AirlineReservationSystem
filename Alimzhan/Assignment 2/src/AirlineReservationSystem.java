import java.util.*;
import java.util.stream.Collectors;

abstract class AbstractEntity {
    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();
}

class Flight extends AbstractEntity {
    private String flightNumber;
    private String destination;
    private String departureTime;
    private double price;

    public Flight(String flightNumber, String destination, String departureTime, double price) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.price = price;
    }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Flight{" + "flightNumber='" + flightNumber + '\'' + ", destination='" + destination + '\'' + ", departureTime='" + departureTime + '\'' + ", price=" + price + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Flight flight = (Flight) obj;
        return flightNumber.equals(flight.flightNumber);
    }

    @Override
    public int hashCode() { return Objects.hash(flightNumber); }
}

class Passenger extends AbstractEntity {
    private int id;
    private String name;
    private int age;
    private String passportNumber;

    public Passenger(int id, String name, int age, String passportNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.passportNumber = passportNumber;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    @Override
    public String toString() {
        return "Passenger{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", passportNumber='" + passportNumber + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Passenger passenger = (Passenger) obj;
        return id == passenger.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}

class Reservation extends AbstractEntity {
    private String reservationId;
    private Flight flight;
    private Passenger passenger;
    private String seatNumber;

    public Reservation(String reservationId, Flight flight, Passenger passenger, String seatNumber) {
        this.reservationId = reservationId;
        this.flight = flight;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
    }

    public String getReservationId() { return reservationId; }
    public void setReservationId(String reservationId) { this.reservationId = reservationId; }
    public Flight getFlight() { return flight; }
    public void setFlight(Flight flight) { this.flight = flight; }
    public Passenger getPassenger() { return passenger; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }
    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    @Override
    public String toString() {
        return "Reservation{" + "reservationId='" + reservationId + '\'' + ", flight=" + flight + ", passenger=" + passenger + ", seatNumber='" + seatNumber + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Reservation that = (Reservation) obj;
        return reservationId.equals(that.reservationId);
    }

    @Override
    public int hashCode() { return Objects.hash(reservationId); }
}

public class AirlineReservationSystem {
    public static void main(String[] args) {
        List<Flight> flights = Arrays.asList(
                new Flight("FL123", "New York", "10:00 AM", 300.0),
                new Flight("FL456", "Los Angeles", "2:00 PM", 400.0),
                new Flight("FL789", "Chicago", "6:00 PM", 350.0)
        );

        List<Flight> filteredFlights = flights.stream().filter(f -> f.getPrice() < 400).collect(Collectors.toList());
        flights.sort(Comparator.comparingDouble(Flight::getPrice));

        Passenger passenger1 = new Passenger(1, "Alice", 28, "P123456");
        Passenger passenger2 = new Passenger(2, "Bob", 35, "P654321");

        Reservation reservation1 = new Reservation("R001", flights.get(0), passenger1, "12A");
        Reservation reservation2 = new Reservation("R002", flights.get(1), passenger2, "15B");

        filteredFlights.forEach(System.out::println);
        flights.forEach(System.out::println);
        System.out.println(reservation1);
        System.out.println(reservation2);
        System.out.println(passenger1.equals(passenger2));
    }
}
