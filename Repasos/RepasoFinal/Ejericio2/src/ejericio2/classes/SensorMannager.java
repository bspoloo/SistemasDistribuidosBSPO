/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejericio2.classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Animetx
 */
public class SensorMannager {
    private List<Sensor> sensors;

    public SensorMannager() {
        this.sensors = new ArrayList<>();
    }
    public boolean addSensor(Sensor sensor){
        Sensor existSensor = this.findById(sensor.getId());
        if(existSensor != null) {
            return false;
        }
        this.sensors.add(sensor);
        return false;
    }
    
    public Sensor findById(String id) {
        Sensor sensorFounded = null;
        for(Sensor sensor : this.sensors) {
            if(sensor.getId().equals(id)) {
                sensorFounded = sensor;
                break;
            }
        }
        return sensorFounded;
    }
}
