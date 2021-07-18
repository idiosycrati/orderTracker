package com.alpha.ordertracker.DAO;

import java.util.List;

import com.alpha.ordertracker.Entities.Colors;
import com.alpha.ordertracker.Entities.GarmentMaterials;
import com.alpha.ordertracker.Entities.GarmentTypes;
import com.alpha.ordertracker.Entities.Orders;

public interface DAOInterface {
    
// Colors
 public void addColors();
 public Colors getSingleColor();
 public List<Colors> findAllColors();




//  Orders
 public void addOrder(Orders receivedOrder);
 public List<Orders> findAllOrders();
 public void updateOrders_machine(int orderId,int machineNum); 
 public Orders findOnGoingOrderPerMachine(int machineId);

// Garment Types 
public List<GarmentTypes> findAllGarmentTypes();



// Garment Materials
public List<GarmentMaterials> findAllGarmentMaterials();

}
