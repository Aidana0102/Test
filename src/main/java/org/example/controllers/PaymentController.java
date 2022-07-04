package org.example.controllers;

import jakarta.validation.Valid;
import org.example.dao.PaymentDao;
import org.example.models.GKPO;
import org.example.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/payments")
public class PaymentController {
        @Autowired
        private final PaymentDao paymentDao;

    public PaymentController(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

//    @GetMapping()
//        public  String index(Model model){
//            model.addAttribute("payments",paymentDao.index());
//            return "people/index";
//        }






        @GetMapping("/mn")
        public String newPayment(Model model){
            model.addAttribute("payment",new Payment());
         List<GKPO> enums = Arrays.asList(GKPO.values());
            model.addAttribute("gkpo", enums);

            return "/payments/mn";
        }



        @PostMapping()
        public String create (@ModelAttribute("payment")  @Valid Payment payment,BindingResult bindingResult){
            if(bindingResult.hasErrors())
                return "/payments/mn";
            PaymentDao.save(payment);
                return "redirect:/payments";
        }

//
//        @GetMapping()
//     public  String payments (@ModelAttribute("payment") Payment payment, @ModelAttribute("gkpo")GKPO gkpo){
//        return"/payments/mn";
//        }
//

//    @PostMapping()
//    public ModelAndView upload(@RequestParam CommonsMultipartFile )
//







}
