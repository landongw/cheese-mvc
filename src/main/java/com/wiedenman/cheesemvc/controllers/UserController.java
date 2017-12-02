package com.wiedenman.cheesemvc.controllers;

import com.wiedenman.cheesemvc.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;

/**
 *  Landon Wiedenman
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "index")
    public String index(Model model) {
        model.addAttribute("users", UserData.getAll());
        model.addAttribute("title", "Cheesy Users");

        return "user/index";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String singleUser(Model model, @PathVariable int id) {

        User user = UserData.getById(id);
        String formattedDate = user.getCreationDate().format(DateTimeFormatter.ofPattern("MMMM dd,  yyyy"));
        model.addAttribute("user", user);
        model.addAttribute("formattedDate", formattedDate);
        return "user/single";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)  // Displays form
    public String displayAddUser(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());

        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST) // Process form
    public String processAddUser(@ModelAttribute @Valid User newUser,
                                 Errors errors, Model model) {

        String password = newUser.getPassword();
        String verify = newUser.getVerify();
        model.addAttribute("title", "Add User");

        if (password == null || password.length() == 0) {
            model.addAttribute("passnullerror", "Required! ");
            if (verify == null || verify.length() == 0) {
                model.addAttribute("verifynullerror", "Required! ");
            } return "user/add";

        } if (!password.equals(verify)) {
            model.addAttribute("passmatcherror", "Passwords must match. ");
            newUser.setPassword("");  // Redundant (good) as the password element in html also removes it
            return "user/add";

        } else if (errors.hasErrors()) {
            return "user/add";

        }

        UserData.put(newUser.getId(), newUser);
        return "redirect:index";
    }
}
