package com.example.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name = "checkpunch")
public class CheckPunch {

    	@Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Integer id;

        @Column(name="name")
    	private String name;

        @Column(name="checkTime")
        private String checkTime;
        @Column(name="location")
        private String location;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
          this.id = id;
        }

    	public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public String getCheckTime(){
            return checkTime;
        }

        public void setCheckTime(String checkTime){
            this.checkTime = checkTime;
        }

        public String getLocation(){
            return location;
        }

        public void setLocation(String location){
            this.location = location;
        }

    
}
