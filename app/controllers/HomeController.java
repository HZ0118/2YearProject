package controllers;

import play.api.Environment;
import play.mvc.*;
import play.data.*;
import play.db.ebean.Transactional;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import views.html.*;

import models.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    private FormFactory FormFactory;

    @Inject
    public HomeController(FormFactory f){
        this.FormFactory = f;
    }

    public Result index() {
        return ok(index.render(getUserFromSession()));
    }

    public Result flights() {
        List<Flight> flightsList = Flight.findAll();
        return ok(list.render(flightsList));
    }

    @Security.Authenticated(Secured.class)
    public Result addFlight(){
        Form<Flight> addFlightForm = FormFactory.form(Flight.class);
        return ok(addFlight.render(addFlightForm, getUserFromSession()));
    }

    @Transactional
    @Security.Authenticated(Secured.class)
    public Result addFlightSubmit(){
        Form<Flight> newFlightForm = FormFactory.form(Flight.class).bindFromRequest();
        if(newFlightForm.hasErrors()){
            return badRequest(addFlight.render(newFlightForm, getUserFromSession()));
        }
        Flight newFlight = newFlightForm.get();
        //if(newFlight.getID()==null){
            newFlight.save();
        /*}
        else if(newFlight.getID() != null) {
            newFlight.update();
        }*/
        flash("success", "Flight " + newFlight.getID() + " has been created");
        return redirect(controllers.routes.HomeController.flights());
    }

    @Security.Authenticated(Secured.class)
    @With(AuthAdmin.class)
    @Transactional
    public Result deleteFlight(int id){
        Flight.find.ref(id).delete();
        flash("success", "Flight has been deleted");
        return redirect(routes.HomeController.flights());
    }

    /*@Transactional
    public Result updateFlight(int id){
        Flight f;
        Form<Flight> flightForm;
        try{
            f = Flight.find.byId(id);
            flightForm = formFactory.form(Flight.class).fill(f);
        } catch (Exception ex) {
            return badRequest("error");
        }
        return ok(addFlight.render(flightForm));
    }*/

    private User getUserFromSession(){
        return User.getUserById(session().get("email"));
    }
}




