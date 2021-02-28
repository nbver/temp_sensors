package com.example.temp_sensors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SensorController {

    @Autowired
    SensorEntryRepository repository;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveValues(@RequestBody SensorEntry[] entries) {
        for (SensorEntry se : entries) {
            repository.save(se);
        }
        return new ResponseEntity<>("Показания внесены в базу данных", HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<double[]> getHistory(@RequestParam("id") int sensorId,
                                               @RequestParam("to") long to,
                                               @RequestParam("from") long from) {
        double[] result = repository.getValues(sensorId, from, to);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
