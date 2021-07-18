package com.alpha.ordertracker.Services;

import java.util.List;

import com.alpha.ordertracker.Entities.Colors;
import com.alpha.ordertracker.Entities.GarmentMaterials;
import com.alpha.ordertracker.Entities.GarmentTypes;
import com.alpha.ordertracker.Entities.Orders;

import org.springframework.stereotype.Service;


public interface Service1Inerface {

    public void addColors();
    public Colors getSingleColor();
    public List<Colors> findAllColors();



    public void addOrder(Orders receivedOrder);
    public List<Orders> findAllOrders();
    public void updateOrders_machine(int orderId,int machineId);
    public Orders findOnGoingOrderPerMachine(int machineId);



    public List<GarmentTypes> findAllGarmentTypes();



// Garment Materials
    public List<GarmentMaterials> findAllGarmentMaterials();


}
