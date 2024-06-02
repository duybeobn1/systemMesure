package org.sample.park.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import org.sample.park.CommandRequest;
import org.sample.park.CommandResponse;
import org.sample.park.CarParkServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CarParkGrpcClient {

    private static final Logger logger = LoggerFactory.getLogger(CarParkGrpcClient.class);
    private final CarParkServiceGrpc.CarParkServiceBlockingStub blockingStub;

    public CarParkGrpcClient() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        blockingStub = CarParkServiceGrpc.newBlockingStub(channel);
    }

    public String processCommand(String command) {
        CommandRequest request = CommandRequest.newBuilder()
                .setCommand(command)
                .build();
        logger.info("Sending CommandRequest to gRPC server with command: {}", command);
        try {
            CommandResponse response = blockingStub.processCommand(request);
            logger.info("Received response from gRPC server: {}", response.getResult());
            return response.getResult();
        } catch (StatusRuntimeException e) {
            logger.error("gRPC request failed: {}", e.getStatus(), e);
            return "gRPC request failed: " + e.getStatus();
        } catch (Exception e) {
            logger.error("Unexpected error during gRPC request", e);
            return "Unexpected error: " + e.getMessage();
        }
    }
}