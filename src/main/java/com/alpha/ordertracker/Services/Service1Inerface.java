package com.alpha.ordertracker.Services;

import java.util.List;

import com.alpha.ordertracker.Entities.Colors;
import com.alpha.ordertracker.Entities.GarmentMaterials;
import com.alpha.ordertracker.Entities.GarmentTypes;
import com.alpha.ordertracker.Entities.Orders;
import com.alpha.ordertracker.Entities.Shipping;

import org.springframework.stereotype.Service;


public interface Service1Inerface {

    public void addColors();
    public Colors getSingleColor();
    public List<Colors> findAllColors();


// Orders
    public void addOrder(Orders receivedOrder);
    public List<Orders> findAllOrders();
    public void updateOrders_machine(int orderId,int machineId);
    public Orders findOnGoingOrderPerMachine(int machineId);
    public void updateOrderState_machine(int orderId,int state); 


// Garment Type
    public List<GarmentTypes> findAllGarmentTypes();



// Garment Materials
    public List<GarmentMaterials> findAllGarmentMaterials();


// Shipping
public List<Orders> findAllToShipOrders();
public void addShipping(Shipping receivedShipping);
public List<Orders> findAllShippedOrders();


}
