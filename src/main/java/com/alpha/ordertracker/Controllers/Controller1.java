package com.alpha.ordertracker.Controllers;

import com.alpha.ordertracker.Entities.Orders;
import com.alpha.ordertracker.Entities.Shipping;
import com.alpha.ordertracker.Services.Service1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class Controller1 {

    @Autowired
    Service1 service1;
    Logger logger = LoggerFactory.getLogger(Controller1.class);

@RequestMapping("/")
public String index(Model model){
        // service1.addColors();
        // service1.addOrder();
        //  logger.info("color "+service1.getSingleColor().getName());

        int machineId=1;

        model.addAttribute("orders", service1.findAllOrders());
        model.addAttribute("colors", service1.findAllColors());
        model.addAttribute("garmentTypes", service1.findAllGarmentTypes());
        model.addAttribute("garmentMaterials", service1.findAllGarmentMaterials());
        model.addAttribute("machineId", machineId);
        model.addAttribute("onGoing", service1.findOnGoingOrderPerMachine(machineId));

        logger.info((service1.findOnGoingOrderPerMachine(machineId) == null)+ " isNull");
    return "orders";
}


// TODO: ORDERS
@RequestMapping("/takeOrder")
public String takeOrder(Model model){

    model.addAttribute("colors", service1.findAllColors());
    model.addAttribute("garmentTypes", service1.findAllGarmentTypes());
    model.addAttribute("garmentMaterials", service1.findAllGarmentMaterials());
    
    model.addAttribute("orders", new Orders());

    return "takeOrder";
}

@RequestMapping("/saveOrder")
public String saveOrder(@ModelAttribute Orders receivedOrder ,Model model){

service1.addOrder(receivedOrder);

    return "redirect:takeOrder";
}

@RequestMapping("/updateOrderMachine")
public String updateOrderMachine(@RequestParam int orderId,@RequestParam int machineId, Model model){
    logger.info("oid "+orderId+" mid "+machineId);
    service1.updateOrders_machine(orderId, machineId);
    model.addAttribute("orders", service1.findAllOrders());
    

    return "orders :: ordersList";
}

@RequestMapping("/updateOrderState")
public String updateStateMachine(@RequestParam int orderId,@RequestParam int state, Model model){
    logger.info("oid "+orderId+" state "+state);
    service1.updateOrderState_machine(orderId, state);
    model.addAttribute("orders", service1.findAllOrders());
    

    return "orders :: ordersList";
}


@RequestMapping("/updateOrderOnGoing")
public String updateOrderOnGoing(@RequestParam int machineId, Model model){
    // logger.info("oid "+orderId+" mid "+machineId);
        model.addAttribute("onGoing", service1.findOnGoingOrderPerMachine(machineId));
        model.addAttribute("colors", service1.findAllColors());
        model.addAttribute("garmentTypes", service1.findAllGarmentTypes());
        model.addAttribute("garmentMaterials", service1.findAllGarmentMaterials());
        model.addAttribute("orders", service1.findAllOrders());

        // logger.info("putangina");


    return "orders :: onGoingDisp";
}









// TODO: SHIPPING
@RequestMapping("/shipping")
public String shipping(Model model){
    model.addAttribute("toships",service1.findAllToShipOrders());
    model.addAttribute("shipped", service1.findAllShippedOrders());
    return "shipping";
}

@RequestMapping("/saveShipping")
public String saveShipping(@ModelAttribute Shipping receivedShipping ,Model model){
//   logger.info(receivedShipping."putangina");
service1.addShipping(receivedShipping);

    return "redirect:shipping";
}



}
