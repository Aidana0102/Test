package org.example.controllers;

import jakarta.validation.Valid;
import org.example.dao.PaymentDao;
import org.example.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;



@Controller
@RequestMapping("/payments")
public class PaymentController {
        @Autowired
        private PaymentDao paymentDao;

    public PaymentController(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

//    @GetMapping()
//        public  String index(Model model){
//            model.addAttribute("people",paymentDao.index());
//            return "people/index";
//        }


        @GetMapping("/new")
        public String newPerson(Model model){
            model.addAttribute("person",new Payment());
            return "payments/mn";
        }



        @PostMapping()
        public String create (@ModelAttribute("person")  @Valid Payment person, BindingResult bindingResult){
            if(bindingResult.hasErrors())
                return "payments/mn";
            PaymentDao.save(person);
                return "redirect:/payments";
        }
}
