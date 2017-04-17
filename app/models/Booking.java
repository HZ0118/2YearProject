package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
public class Booking extends Model {
    private int booking_ID;
    private String booking_date;
    private String departure_date;
    private String ticket_type;
    
    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private FlightSchedule flight_schedule;

    public Booking(){

    }

    public Booking(int id, String booking_date, String departure_date, String ticket_type, Passenger passenger, FlightSchedule flight_schedule){
        this.booking_ID = id;
        this.booking_date = booking_date;
        this.departure_date = departure_date;
        this.ticket_type = ticket_type;
        this.passenger = passenger;
        this.flight_schedule = flight_schedule;
    }

    public static Finder<Integer, Booking> find = new Finder<Integer, Booking>(Booking.class);

    public static List<Booking> findAll() {
        return Booking.find.all();
    }

    //get and set booking_ID
    public int getBookingID(){
        return booking_ID;
    }

    public void setBookingID(int id){
        this.booking_ID = id;
    }

    //get and set booking_date
    public String getBookingDate(){
        return booking_date;
    }

    public void setBookingDate(String booking_date){
        this.booking_date = booking_date;
    }

    //get and set departure_date
    public String getDepDate(){
        return departure_date;
    }

    public void setDepDate(String departure_date){
        this.departure_date = departure_date;
    }

    //get and set ticket_type
    public String getTicketType(){
        return ticket_type;
    }

    public void setTicketType(String ticket_type){
        this.ticket_type = ticket_type;
    }

    //get and set passenger
    public Passenger getPassenger(){
        return passenger;
    }

    public void setPassenger(Passenger passenger){
        this.passenger = passenger;
    }

    //get and set flight_schedule
    public FlightSchedule getFlightSchedule(){
        return flight_schedule;
    }

    public void setFlightSchedule(FlightSchedule flight_schedule){
        this.flight_schedule = flight_schedule;
    }

}