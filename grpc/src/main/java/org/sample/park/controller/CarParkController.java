package org.sample.park.controller;

import org.sample.park.client.CarParkGrpcClient;
import org.sample.park.service.CommandResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/park")
public class CarParkController {

    @Autowired
    private CarParkGrpcClient carParkGrpcClient;

    @Autowired
    private CommandResultService commandResultService;

    @PostMapping("/test")
    public String testEndpoint(@RequestBody Map<String, String> command) {
        String cmd = command.get("command");
        String result = carParkGrpcClient.processCommand(cmd);
        commandResultService.saveResult(result);
        return result;
    }
}
