package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String rollDice() {

        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String play(@PathVariable Integer guess, Model vModel) {
        int rand = (int) (Math.random() * 6 + 1);

        boolean win = (rand == guess) ? true : false;

        vModel.addAttribute("guess", guess);
        vModel.addAttribute("rand", rand);
        vModel.addAttribute("win", win);

        return "roll-dice";
    }
}
