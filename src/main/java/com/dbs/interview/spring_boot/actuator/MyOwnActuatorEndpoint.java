package com.dbs.interview.spring_boot.actuator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="myOwnActuator")
public class MyOwnActuatorEndpoint {
    @Value("${maintenance.value}")
    private boolean onMaintenance;

    @ReadOperation
    public String getReleaseNotes() {
        String result = "I am up and running";
        if (onMaintenance) {
            result = "I am onMaintenance";
        }
        return result;
    }
}
