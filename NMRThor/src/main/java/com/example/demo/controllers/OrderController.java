package com.example.demo.controllers;

import com.example.demo.models.*;
import com.example.demo.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    private IOrderRepo orderRepository;
    private IMotorhomeRepo motorhomeRepository;
    private IExtrasRepo extrasRepository;
    private ISeasonsRepo seasonsRepository;

    public OrderController(){
        orderRepository = new OrderRepoImpl();
        motorhomeRepository = new MotorhomeRepoImpl();
        extrasRepository = new ExtrasRepoImpl();
        seasonsRepository = new SeasonRepoImpl();
    }


    @GetMapping("/sales")
    public String sales (Model model){
        indexRead(model);
        model.addAttribute("activeOrders", orderRepository.readActive());
        model.addAttribute("endedOrders", orderRepository.readEnded());
        return "sales";
    }

    @GetMapping("/orderDetails")
    public String orderDetails(@RequestParam int ID, Model model){
        Order order = orderRepository.read(ID);
        List<Motorhome> mhList = order.getMotorhomesInOrder();
        List<Motorhome> mhInOrder = new ArrayList<Motorhome>();

        for(int i=0; i < mhList.size(); i++){
            Motorhome motorhome = motorhomeRepository.read(mhList.get(i).getID());
            mhInOrder.add(motorhome);
        }

        List<Extra> extraList = order.getExtrasList();
        List<Extra> exInOrder = new ArrayList<Extra>();

        for(int i=0; i<extraList.size(); i++){
            Extra extra = extrasRepository.read(extraList.get(i).getExtraID());
            exInOrder.add(extra);
        }

        int season = seasonsRepository.read(order.getSeason().getSeasonID()).getSeasonID();

        model.addAttribute("season", season);
        model.addAttribute("exInOrder", exInOrder);
        model.addAttribute("mhInOrder", mhInOrder);
        model.addAttribute("order", order);
        return "orderID";
    }

    @PostMapping("/orderUpdate")
    public String orderUpdate(@ModelAttribute Order order, Model model){
        orderRepository.update(order);
        return "homepage";
    }

    @GetMapping("/addSale")
    public String addSale(Model model){
        Order order = new Order();
        Customer customer = new Customer();

        Season season = new Season();
        order.setSeason(season);

        order.setCustomer(customer);
        ArrayList<Motorhome> mhlist = new ArrayList<Motorhome>();
        order.setMotorhomesInOrder(mhlist);
        ArrayList<Extra> exlist = new ArrayList<Extra>();
        order.setExtrasList(exlist);
        Location loc = new Location();
        order.setDropOffLocation(loc);
        Date startDate = new Date();
        Date endDate = new Date();
        order.setStartDate(startDate);
        order.setEndDate(endDate);

        seasonsRepository.readAll();

        model.addAttribute("order", order);
        return "addSale";
    }

    @PostMapping("/addSaleForm")
    public String addOrderSubmit(@ModelAttribute Order order, Model model){
        indexRead(model);
        orderRepository.create(order);
        return "homepage";
    }

    @GetMapping("/dropOff")
    public String dropOff(Model model){
        indexRead(model);
        model.addAttribute("activeOrders", orderRepository.readActive());
        return "dropOff";
    }

    @GetMapping("/dropOffDetails")
    public String dropOffDetails(@RequestParam int ID, Model model){
        Order order = orderRepository.read(ID);
        System.out.println(order.getDropOffLocation().getLocationID());
        System.out.println(order.getDropOffLocation().getLocationID());
        model.addAttribute("order", order);
        return "dropOffDetails";
    }

    @PostMapping("/dropOffForm")
    public String dropOffForm(@ModelAttribute Order order, Model model){
        System.out.println(order.getDropOffLocation().getLocationID());
        orderRepository.updateDropOff(order);
        return "homepage";
    }

    public void indexRead(Model model) {
        model.addAttribute("orders", orderRepository.readAll());
    }
}
