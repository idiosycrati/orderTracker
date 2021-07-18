package com.alpha.ordertracker.Entities;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "order_number")
    private String order_number;

    
    @Column(name = "garment_type_id")
    private int garment_type_id;

    @Column(name = "garment_material_id")
    private int garment_material_id;
  
    @Column(name = "color_id")
    private int color_id;

    @Column(name = "notes")
    private String notes;

    @Column(name = "date_received")
    private Date date_received;

    @Column(name = "design")
    private String design;

    @Column(name = "time_processed")
    private int time_processed;

    @Column(name = "machine")
    private int machine;

    
    // @Column(name = "date_started")
    // private String date_started;


    public int getId() {
        return id;
    }

    public String getOrder_number() {
        return order_number;
    }

    public int getGarment_type_id() {
        return garment_type_id;
    }

    public int getGarment_material_id(){
        return garment_material_id;
    }

    public int getColor_id(){
        return color_id;
    }

    public String getNotes(){
        return notes;
    }

    public Date getDate_received(){
        return date_received;
    }

    public String getDesign(){
        return design;
    }

    public int getTime_processed(){
        return time_processed;
    }

    public void setId(int id) {
        this.id = id;
      }


      public void setOrder_number(String order_number) {
        this.order_number = order_number;
      }

      public void setGarment_type_id(int garment_type_id) {
        this.garment_type_id = garment_type_id;
      }

      public void setGarment_material_id(int garment_material_id) {
        this.garment_material_id = garment_material_id;
      }

      public void setColor_id(int colors) {
        this.color_id = colors;
      }

      public void setNotes(String notes) {
        this.notes = notes;
      }

      public void setDate_received(Date date_received) {
        this.date_received = date_received;
      }

      public void setDesign(String design) {
        this.design = design;
      }

      public void setTimeProcessed(int time_processed){
        this.time_processed = time_processed;
    }

// 













    
}
