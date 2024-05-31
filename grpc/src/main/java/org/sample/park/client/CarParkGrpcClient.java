package org.sample.park.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.sample.park.CarParkServiceGrpc;
import org.sample.park.CommandRequest;
import org.sample.park.CommandResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
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
        CommandRequest request = CommandRequest.newBuilder().setCommand(command).build();
        try {
            CommandResponse response = blockingStub.processCommand(request);
            return response.getResult();
        } catch (Exception e) {
            logger.error("gRPC request failed: {}", e.getMessage());
            throw new RuntimeException("gRPC request failed", e);
        }
    }
}
