package com.example.demo.controllers;
import com.example.demo.models.Motorhome;
import com.example.demo.repositories.IMotorhomeRepo;
import com.example.demo.repositories.MotorhomeRepoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MotorhomeController {

    private IMotorhomeRepo motorhomeRepository;

    public MotorhomeController() {
        motorhomeRepository = new MotorhomeRepoImpl();
    }

    public void indexRead(Model model) {
        model.addAttribute("motorhomes", motorhomeRepository.readAll());
    }


    @GetMapping("/")                                // Access to homepage
    public String homepage(Model model){
        indexRead(model);
        return "homepage";
    }

    @GetMapping("/deleteMotorhome")
    public String deleteMotorhome(@RequestParam int ID, Model model){

        Motorhome motorhome = motorhomeRepository.read(ID);
        motorhome.setActive(false);

        motorhomeRepository.update(motorhome);

        indexRead(model);
        return "motorhomes";
    }


    @GetMapping("/motorhomeDetails")
    public String motorhomeDetails(@RequestParam int ID, Model model){
        Motorhome motorhome = motorhomeRepository.read(ID);
        model.addAttribute("motorhome", motorhome);
        return "motorhomeID";
    }

    @PostMapping("/motorhomeUpdate")
    public String motorhomeUpdate(@ModelAttribute Motorhome motorhome, Model model){

        motorhomeRepository.update(motorhome);
        return "homepage";
    }


    @GetMapping("/motorhomes")
    public String motorhomes (Model model){         // Access to motorhomes subsection
        indexRead(model);
        return "motorhomes";
    }

    @GetMapping("/addMotorhome")                    // Access to create a motorhome
    public String addMotorhome(Model model) {
        Motorhome mHome = new Motorhome();
        model.addAttribute("motorhome", mHome);
        return "createMotorhome";
    }

    @PostMapping("/addMotorhomeForm")               //Creation form under the "add motorhome" section
    public String addMotorhomeSubmit(@ModelAttribute Motorhome motorhome, Model model) {
        indexRead(model);
        motorhomeRepository.create(motorhome);
        return "homepage";
    }


    @GetMapping("/maintenance")                     // Access to maintenance subsection
    public String maintenance (Model model){
        indexRead(model);
        return "maintenance";
    }


}
