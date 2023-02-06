package ua.kharin.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kharin.springdemo.service.NumberService;

@RestController
public class NumberController {
    private final NumberService numberService;

    @Autowired
    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping(path = "/random")
    public int getRandomNumber(@RequestParam int from,
                               @RequestParam int to) {
        numberService.validateInputForRandom(from, to);
        return numberService.getRandom(from, to);
    }

}
