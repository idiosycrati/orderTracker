package com.alpha.ordertracker.Services;

import java.util.List;

import com.alpha.ordertracker.DAO.DAO;
import com.alpha.ordertracker.Entities.Colors;
import com.alpha.ordertracker.Entities.GarmentMaterials;
import com.alpha.ordertracker.Entities.GarmentTypes;
import com.alpha.ordertracker.Entities.Orders;
import com.alpha.ordertracker.Entities.Shipping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service1 implements Service1Inerface {

    @Autowired
    private DAO dao;

    @Override
    public void addColors() {
    
        dao.addColors();
        
    }

    @Override
    public Colors getSingleColor() {
        // TODO Auto-generated method stub


        return dao.getSingleColor();
    }

    @Override
    public List<Colors> findAllColors() {
        // TODO Auto-generated method stub
        return dao.findAllColors();
    }
    


    @Override
    public List<Orders> findAllOrders() {
        // TODO Auto-generated method stub

       
        return dao.findAllOrders();
    }

    @Override
    public void addOrder(Orders receivedOrder) {
        dao.addOrder(receivedOrder);
        
    }

    @Override
    public void updateOrderState_machine(int orderId, int state) {
    dao.updateOrderState_machine(orderId, state);
    }

    @Override
    public void updateOrders_machine(int orderId, int machineId) {
        dao.updateOrders_machine(orderId, machineId);
        
    }

    @Override
    public Orders findOnGoingOrderPerMachine(int machineId) {
      
        return dao.findOnGoingOrderPerMachine(machineId);
    }



    @Override
    public List<GarmentTypes> findAllGarmentTypes() {
    
        return dao.findAllGarmentTypes();
    }

    @Override
    public List<GarmentMaterials> findAllGarmentMaterials() {
      
        return dao.findAllGarmentMaterials();
    }

    @Override
    public List<Orders> findAllToShipOrders() {
       
        return dao.findAllToShipOrders();
    }

    @Override
    public void addShipping(Shipping receivedShipping) {
      
    dao.addShipping(receivedShipping);
        
    }

    @Override
    public List<Orders> findAllShippedOrders() {
        // TODO Auto-generated method stub
        return dao.findAllShippedOrders();
    }

  


   

    

}
