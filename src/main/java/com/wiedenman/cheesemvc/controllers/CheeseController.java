package com.wiedenman.cheesemvc.controllers;

import com.wiedenman.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *  Landon Wiedenman
 */
@Controller
@RequestMapping("cheese")  // Specifies that every following controller will be prepended with this
public class CheeseController {

    //static ArrayList<String> cheeses = new ArrayList<>();  // This is a static member of the cheese controller
    static HashMap<Integer, Cheese> cheeses = new HashMap<>();

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
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {

//        String cheeseName = requestParams.get("cheeseName");
//        String cheeseDescription = requestParams.get("cheeseDescription");

        Cheese newCheese = new Cheese(cheeseName, cheeseDescription);
        cheeses.put(newCheese.getCheeseId(), newCheese); // Adds cheese passed in from /cheese/add form
        return "redirect:"; // Redirects to root (/cheese)
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", cheeses);
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam ArrayList<Integer> cheeseKey) {

            for (Integer aCheese : cheeseKey) {
                cheeses.remove(aCheese);
            }

            return "redirect:";

    }

}
