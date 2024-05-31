package org.sample.park.controller;

import org.sample.park.client.CarParkGrpcClient;
import org.sample.park.model.CommandRequest;
import org.sample.park.model.CommandResponse;
import org.sample.park.service.CommandResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/park")
public class CarParkController {

    @Autowired
    private CarParkGrpcClient carParkGrpcClient;

    @Autowired
    private CommandResultService commandResultService;

    @PostMapping("/test")
    public CommandResponse testEndpoint(@RequestBody CommandRequest request) {
        String command = request.getCommand();
        String grpcResponse = carParkGrpcClient.processCommand(command);

        // Save the command and result to the database
        commandResultService.saveCommandResult(command, grpcResponse);

        return new CommandResponse(grpcResponse);
    }
}
