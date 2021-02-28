package com.example.temp_sensors;

import lombok.ToString;

import javax.persistence.*;

@Entity(name = "temp_entry")
@ToString
public class SensorEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "sensor_id")
    private int sensorId;

    @Column(name = "object_id")
    private int objectId;

    @Column(name = "time")
    private long time;

    @Column(name = "value")
    private double value;

    public SensorEntry(){}

    public SensorEntry(int objectId, int sensorId, long time, double value) {
        this.sensorId = sensorId;
        this.objectId = objectId;
        this.time = time;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
