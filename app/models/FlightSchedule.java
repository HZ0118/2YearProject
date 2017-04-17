package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
public class FlightSchedule extends Model {
    @Id
    private int flight_ID;
    private String flight_date;
    private String departure_time;
    private String arrival_time;

    @ManyToOne
    private Aircraft aircraft;

    @ManyToOne
    private Route routes;

    @OneToMany
    private List<Booking> booking;

    public FlightSchedule(){

    }

    public FlightSchedule(int id, String flight_date, String departure_time, String arrival_time, Aircraft aircraft, Route routes, List<Booking> booking){
        this.flight_ID = id;
        this.flight_date = flight_date;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.aircraft = aircraft;
        this.routes = routes;
        this.booking = booking;
    }

    public static Finder<Integer, FlightSchedule> find = new Finder<Integer,FlightSchedule>(FlightSchedule.class);

    public static List<FlightSchedule> findAll(){
        return FlightSchedule.find.all();
    }

    //get and set flight id
    public int getFlightID(){
        return flight_ID;
    }

    public void setFlightID(int id){
        this.flight_ID = id;
    }

    //get and set flight date
    public String getFlightDate(){
        return flight_date;
    }

    public void setFlightDate(String flight_date){
        this.flight_date = flight_date;
    }

    //get and set departure_time
    public String getDepTime(){
        return departure_time;
    }

    public void setDepTime(String departure_time){
        this.departure_time = departure_time;
    }

    //Get and set arrival_time
    public String getArrTime(){
        return arrival_time;
    }

    public void setArrTime(String arrival_time){
        this.arrival_time = arrival_time;
    }

    //get and set aircraft
    public Aircraft getAircraft(){
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft){
        this.aircraft = aircraft;
    }

    //get and set routes
    public Route getRoutes(){
        return routes;
    }

    public void setRoutes(Route routes){
        this.routes = routes;
    }

    //get and set booking
    public List<Booking> getBooking(){
        return booking;
    }

    public void setBooking(List<Booking> booking){
        this.booking = booking;
    }

}