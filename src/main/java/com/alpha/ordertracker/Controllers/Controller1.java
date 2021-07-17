package com.alpha.ordertracker.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller1 {

    
@RequestMapping("/")
public String index(){
    return "orders";
}

@RequestMapping("/takeOrder")
public String takeOrder(){
    return "takeOrder";
}


@RequestMapping("/shipping")
public String shipping(){
    return "shipping";
}

    
}
