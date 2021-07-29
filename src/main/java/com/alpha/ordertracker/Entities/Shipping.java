package com.alpha.ordertracker.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipping")
public class Shipping {


    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int id;

    @Column(name = "order_id")
    private int order_id;

    @Column(name = "shipping_courier")
    private String shipping_courier;

    @Column(name = "tracking_details")
    private String tracking_details;

    @Column(name = "reference_number")
    private String reference_number;


    public int getId() {
        return id;
    }

    public int getOrder_id(){
        return this.order_id;
    }
    
    public String getShipping_courier(){
        return this.shipping_courier;
    }

    public String getTracking_details(){
        return this.tracking_details;
    }

    public String getReference_number(){
        return this.reference_number;
    }

    public void setId(int id) {
        this.id = id;
      }


      public void setOrder_id(int order_id){
        this.order_id=order_id;
    }

      public void setShipping_courier(String shipping_courier){
          this.shipping_courier=shipping_courier;
      }

      public void setTracking_details(String tracking_details){
          this.tracking_details=tracking_details;
      }

      public void setReference_number(String reference_number){
          this.reference_number=reference_number;
      }
}
