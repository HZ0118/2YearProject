package controllers;

import controllers.*;
import controllers.routes;
import play.api.Environment;
import play.mvc.*;
import play.data.*;

import javax.inject.Inject;

import views.html.*;
import models.users.*;

public class SignupController extends Controller {
    
    private FormFactory formFactory;

    @Inject
    public SignupController(FormFactory f) {
        this.formFactory = f;
    }

    public Result signup(){
        Form<User> addUserForm = formFactory.form(User.class);
        return ok(signup.render(addUserForm, User.getUserById(session().get("email"))));
    }

    public Result signupSubmit() {
        Form<User> newSignupForm = formFactory.form(User.class).bindFromRequest();
        if(newSignupForm.hasErrors()){
            return badRequest(signup.render(newSignupForm, User.getUserById(session().get("email"))));
        }
        User newUser = newSignupForm.get();
        newUser.save();
        flash("success", "User " + newUser.getName() + " has been created");
        return redirect(controllers.routes.LoginController.login());
    }

}