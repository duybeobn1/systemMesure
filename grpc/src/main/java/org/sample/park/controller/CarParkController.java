package org.sample.park.controller;

import org.sample.park.client.CarParkGrpcClient;
import org.sample.park.model.CommandRequest;
import org.sample.park.model.CommandResult;
import org.sample.park.repository.CommandResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/park")
public class CarParkController {

    @Autowired
    private CarParkGrpcClient carParkGrpcClient;

    @Autowired
    private CommandResultRepository commandResultRepository;

    @GetMapping("/test")
    public ResponseEntity<String> getTestEndpoint() {
        return new ResponseEntity<>("GET endpoint is working!", HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<String> testEndpoint(@RequestBody CommandRequest request) {   
        try {
            String command = request.getCommand();
            String result = carParkGrpcClient.processCommand(command);
            CommandResult commandResult = new CommandResult();
            commandResult.setCommand(command);
            commandResult.setResult(result);
            commandResultRepository.save(commandResult);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to process command: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
