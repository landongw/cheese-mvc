package com.wiedenman.cheesemvc.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 *  Landon Wiedenman
 */
@Controller
@RequestMapping("cheese")  // Specifies that every following controller will be proceeded with this
public class CheeseController {

    static ArrayList<String> cheeses = new ArrayList<>();  // This is a static member of the cheese controller

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";  // Points to the template by name
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)  // Displays form
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }


//    Use parameters with HttpServletRequest method

//    @RequestMapping(value = "add", method = RequestMethod.POST) // Process form
//    public String processAddCheeseForm(@HttpServletRequest request) {
//
//        String cheeseName = request.getParameter("cheesename");
//    }

    @RequestMapping(value = "add", method = RequestMethod.POST) // Process form
    public String processAddCheeseForm(@RequestParam String cheeseName) {

        cheeses.add(cheeseName); // Adds cheese passed in from /add form
        return "redirect:"; // Redirects to root (/cheese)
    }
}
