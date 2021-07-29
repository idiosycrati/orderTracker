package com.alpha.ordertracker.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.alpha.ordertracker.Entities.Colors;
import com.alpha.ordertracker.Entities.GarmentMaterials;
import com.alpha.ordertracker.Entities.GarmentTypes;
import com.alpha.ordertracker.Entities.Orders;
import com.alpha.ordertracker.Entities.Shipping;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAO implements DAOInterface {


    Logger logger = LoggerFactory.getLogger(DAO.class);

    private EntityManager entityManager;


    
    @Autowired
    public DAO(EntityManager entityManager){

        this.entityManager=entityManager;
    }

// TODO: Colors

    @Override
    @Transactional
    public void addColors() {
        // TODO Auto-generated method stub

        
        Session currentSession= entityManager.unwrap(Session.class);

        Colors colors = new Colors();
        
        colors.setName("Maroon");
        // colors.setDescription(");

        currentSession.save(colors);


        
    }



    @Override
    public Colors getSingleColor() {
        // TODO Auto-generated method stub
        
        Session currentSession= entityManager.unwrap(Session.class);

        Query<Colors> colorQ = currentSession.createQuery("from Colors C where C.name= :name ", Colors.class);
        colorQ.setParameter("name","Maroon");
        Colors color = colorQ.getSingleResult();

    // logger.info(degrees.size()+" size");            

        return color;
        
    }

    
    @Override
    public List<Colors> findAllColors() {
          
        Session currentSession= entityManager.unwrap(Session.class);

        Query<Colors> colorQ = currentSession.createQuery("from Colors", Colors.class);
        List<Colors> colors = colorQ.getResultList();

    // logger.info(degrees.size()+" size");            

        return colors;
        
        
    }



 // TODO:Orders
    @Override
    public void addOrder(Orders receivedOrder) {
        // TODO Auto-generated method stub
        Logger logger = LoggerFactory.getLogger(DAO.class);

try {
    
        Session currentSession= entityManager.unwrap(Session.class);

        Orders order = new Orders();
        order.setColor_id(receivedOrder.getColor_id());
        order.setDate_received(receivedOrder.getDate_received());
        order.setGarment_material_id(receivedOrder.getGarment_material_id());
        order.setGarment_type_id(receivedOrder.getGarment_type_id());
        order.setOrder_number(receivedOrder.getOrder_number());
        order.setNotes(receivedOrder.getNotes());
        order.setDesign(receivedOrder.getDesign());
        currentSession.save(order);    
       
     

        logger.info( " *DAO.java* "+receivedOrder.getNotes()+" "+receivedOrder.getDate_received()+ " " +
         receivedOrder.getColor_id() +" "+receivedOrder.getGarment_material_id()+ " "+ receivedOrder.getGarment_type_id()+ " "+receivedOrder.getDesign()+" "+ receivedOrder.getOrder_number());
    } catch (Exception e) {
        logger.info("Error: "+e);

        logger.info( " *DAO.java* "+receivedOrder.getNotes()+" "+receivedOrder.getDate_received()+ " " +
         receivedOrder.getColor_id() +" "+receivedOrder.getGarment_material_id()+ " "+ receivedOrder.getGarment_type_id()+ " "+receivedOrder.getDesign()+" "+ receivedOrder.getOrder_number());

    }
      
    }



    @Override
    @Transactional
    public List<Orders> findAllOrders() {

        Session currentSession= entityManager.unwrap(Session.class);

        Query<Orders> ordersQ = currentSession.createQuery("from Orders where machine = 0 and is_done=0", Orders.class);
        List<Orders> orders = ordersQ.getResultList();
        return orders;
    
    }

    
    @Override
    @Transactional
    public void updateOrders_machine(int orderId,int machineId) {
        
        Session currentSession= entityManager.unwrap(Session.class);

        Query updateOrders = currentSession.createQuery("update Orders a set a.machine= :machineNum where a.id=:orderId");
        updateOrders.setParameter("machineNum", machineId);
        updateOrders.setParameter("orderId", orderId);
        updateOrders.executeUpdate();
    }

    @Override
    @Transactional
    public void updateOrderState_machine(int orderId, int state) {
        
        Session currentSession= entityManager.unwrap(Session.class);

        Query updateOrders = currentSession.createQuery("update Orders a set a.is_done= :isDone where a.id=:orderId");
        updateOrders.setParameter("isDone", state);
        updateOrders.setParameter("orderId", orderId);
        updateOrders.executeUpdate();
        
    }


    @Override
    public Orders findOnGoingOrderPerMachine(int machineId) {

        Session currentSession= entityManager.unwrap(Session.class);
        Orders orders = null;
        try {
            
       
        Query<Orders> ordersQ = currentSession.createQuery("from Orders where not machine = 0 and machine= :machineId and is_done=0", Orders.class);
        ordersQ.setParameter("machineId", machineId);

       orders = ordersQ.getSingleResult();
        return orders;

    } catch (Exception e) {
        logger.info("Error: "+e);
       return null;
    }
    }




//  TODO:Garment Types
    @Override
    public List<GarmentTypes> findAllGarmentTypes() {
        Session currentSession= entityManager.unwrap(Session.class);

        Query<GarmentTypes> garmentTypesQ = currentSession.createQuery("from GarmentTypes", GarmentTypes.class);
        List<GarmentTypes> garmentTypes = garmentTypesQ.getResultList();

        return garmentTypes;
    
    }


// TODO:Garment Materials

    @Override
    public List<GarmentMaterials> findAllGarmentMaterials() {


        Session currentSession= entityManager.unwrap(Session.class);

        Query<GarmentMaterials> garmentMaterialsQ = currentSession.createQuery("from GarmentMaterials", GarmentMaterials.class);
        List<GarmentMaterials> garmentMaterials = garmentMaterialsQ.getResultList();

        return garmentMaterials;
    

    }

// TODO: Shipping

    @Override
    public List<Orders> findAllToShipOrders() {
       
        
        Session currentSession= entityManager.unwrap(Session.class);
        // select * from orders where is_done=1 and orders.id NOT in(select order_id from shipping);
        Query<Orders> ordersQ = currentSession.createQuery("from Orders as a where a.machine = 1 and a.is_done=1 and a.id NOT in(select order_id from Shipping)", Orders.class);
        List<Orders> orders = ordersQ.getResultList();
        return orders;
    
    }

    @Override
    @Transactional
    public void addShipping(Shipping receivedShipping) {
       
        Logger logger = LoggerFactory.getLogger(DAO.class);

try {
    
        Session currentSession= entityManager.unwrap(Session.class);

       
      
        currentSession.save(receivedShipping);    
       
     
    } catch (Exception e) {
        logger.info("Error: "+e);

       
    }
    }

    @Override
    public List<Orders> findAllShippedOrders() {
       try {
           
      
        Session currentSession= entityManager.unwrap(Session.class);
      // select * from orders,shipping where is_done=1 and orders.id in(select order_id from shipping) and orders.id=shipping.order_id ;
        Query<Orders> ordersQ = currentSession.createQuery("from Orders as a where a.is_done=1 and a.id in(select b.order_id from Shipping as b where b.order_id=a.id)", Orders.class);
        List<Orders> orders = ordersQ.getResultList();
        return orders;
    } catch (Exception e) {
        //TODO: handle exception
        return null;
    }
      
    }



   







// 




   
    




 




}
