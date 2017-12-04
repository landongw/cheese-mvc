package com.wiedenman.cheesemvc.controllers;

import com.wiedenman.cheesemvc.models.Cheese;
import com.wiedenman.cheesemvc.models.CheeseRating;
import com.wiedenman.cheesemvc.models.CheeseType;
import com.wiedenman.cheesemvc.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 *  Landon Wiedenman
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)  // Displays form
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        model.addAttribute("cheeseRatings", CheeseRating.values());
        return "cheese/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST) // Process form
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("cheeseTypes", CheeseType.values());
            model.addAttribute("cheeseRatings", CheeseRating.values());
            return "cheese/add";
        }

        cheeseDao.save(newCheese);
        return "redirect:"; // Redirects to root (/cheese)
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", cheeseDao.findAll());
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam ArrayList<Integer> cheeseKey) {

            for (Integer aCheeseId : cheeseKey) {
                cheeseDao.delete(aCheeseId);
            }

            return "redirect:";

    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int id) {

        Cheese cheeseToEdit = cheeseDao.findOne(id);
        model.addAttribute("cheese", cheeseToEdit);
        model.addAttribute("cheeseTypes", CheeseType.values());
        model.addAttribute("cheeseRatings", CheeseRating.values());
        return "cheese/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Cheese cheeseToEdit,
                                  Errors errors,
                                  Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("edit cheese", cheeseToEdit);
            model.addAttribute("cheeseTypes", CheeseType.values());
            model.addAttribute("cheeseRatings", CheeseRating.values());
            return "cheese/edit";
        }

        Cheese editedCheese = cheeseDao.findOne(cheeseToEdit.getId());
        editedCheese.setName(cheeseToEdit.getName());
        editedCheese.setDescription(cheeseToEdit.getDescription());
        editedCheese.setType(cheeseToEdit.getType());
        editedCheese.setRating(cheeseToEdit.getRating());
        return "redirect:";
    }

}
