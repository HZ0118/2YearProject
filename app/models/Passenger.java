package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
public class Passenger extends Model {
    @Id
    private int passenger_ID;
    private String name;
    private String address;
    private int age;
    private String nationality;
    private String mobile;

    @OneToMany
    private List<Booking> booking;

    public Passenger(){

    }

    public Passenger(int id, String name, String address, int age, String nationality, String mobile, List<Booking> booking){
        this.passenger_ID = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.nationality = nationality;
        this.mobile = mobile;
        this.booking = booking;
    }

    public static Finder<Integer, Passenger> find = new Finder<Integer, Passenger>(Passenger.class);

    public static List<Passenger> findAll(){
        return Passenger.find.all();
    }

    //get and set passenger id
    public int getPassengerID(){
        return passenger_ID;
    }

    public void setPassengerID(int id){
        this.passenger_ID = id;
    }

    //get and set name
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    //get and set address
    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    //get and set age
    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    //get and set nationality
    public String getNationality(){
        return nationality;
    }

    public void setNationality(String nationality){
        this.nationality = nationality;
    }

    //get and set mobile
    public String getMobile(){
        return mobile;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    //get and set booking
    public List<Booking> getBooking(){
        return booking;
    }

    public void setBooking(List<Booking> booking){
        this.booking = booking;
    }

}