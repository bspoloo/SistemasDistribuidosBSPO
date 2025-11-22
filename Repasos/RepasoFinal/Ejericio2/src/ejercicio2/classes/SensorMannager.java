/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2.classes;

import ejercicio2.enums.Status;
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

    public boolean addSensor(Sensor sensor) {
        Sensor existSensor = this.findById(sensor.getId());
        if (existSensor != null) {
            return false;
        }
        this.sensors.add(sensor);
        return true;
    }

    public Sensor findById(String id) {
        Sensor sensorFounded = null;
        for (Sensor sensor : this.sensors) {
            if (sensor.getId().equals(id)) {
                sensorFounded = sensor;
                break;
            }
        }
        return sensorFounded;
    }

    public Sensor getCriticStatus() {
        Status max = Status.HIGHER;
        Sensor sensorMax = null;
        for (Sensor sensor : this.sensors) {
            if (sensor.getStatus().equals(max)) {
                sensorMax = sensor;
                break;
            }
        }
        return sensorMax;
    }
}
