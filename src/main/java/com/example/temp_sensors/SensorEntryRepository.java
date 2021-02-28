package com.example.temp_sensors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SensorEntryRepository extends JpaRepository<SensorEntry, Long> {

    SensorEntry save(SensorEntry sensorEntry);

    @Query(value = "select te.value from temp_entry te " +
            "where te.sensor_id =?1 and te.time between ?2 and ?3", nativeQuery = true)
    double[] getValues(int sensorId, long from, long to);

}
