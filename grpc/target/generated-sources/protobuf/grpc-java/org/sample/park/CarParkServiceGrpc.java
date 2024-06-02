package org.sample.park;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: CarPark.proto")
public final class CarParkServiceGrpc {

  private CarParkServiceGrpc() {}

  public static final String SERVICE_NAME = "park.CarParkService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<org.sample.park.CommandRequest,
      org.sample.park.CommandResponse> METHOD_PROCESS_COMMAND =
      io.grpc.MethodDescriptor.<org.sample.park.CommandRequest, org.sample.park.CommandResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "park.CarParkService", "ProcessCommand"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.sample.park.CommandRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              org.sample.park.CommandResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CarParkServiceStub newStub(io.grpc.Channel channel) {
    return new CarParkServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CarParkServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CarParkServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CarParkServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CarParkServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CarParkServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void processCommand(org.sample.park.CommandRequest request,
        io.grpc.stub.StreamObserver<org.sample.park.CommandResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PROCESS_COMMAND, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_PROCESS_COMMAND,
            asyncUnaryCall(
              new MethodHandlers<
                org.sample.park.CommandRequest,
                org.sample.park.CommandResponse>(
                  this, METHODID_PROCESS_COMMAND)))
          .build();
    }
  }

  /**
   */
  public static final class CarParkServiceStub extends io.grpc.stub.AbstractStub<CarParkServiceStub> {
    private CarParkServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CarParkServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarParkServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CarParkServiceStub(channel, callOptions);
    }

    /**
     */
    public void processCommand(org.sample.park.CommandRequest request,
        io.grpc.stub.StreamObserver<org.sample.park.CommandResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PROCESS_COMMAND, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CarParkServiceBlockingStub extends io.grpc.stub.AbstractStub<CarParkServiceBlockingStub> {
    private CarParkServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CarParkServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarParkServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CarParkServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.sample.park.CommandResponse processCommand(org.sample.park.CommandRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PROCESS_COMMAND, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CarParkServiceFutureStub extends io.grpc.stub.AbstractStub<CarParkServiceFutureStub> {
    private CarParkServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CarParkServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarParkServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CarParkServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.sample.park.CommandResponse> processCommand(
        org.sample.park.CommandRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PROCESS_COMMAND, getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS_COMMAND = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CarParkServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CarParkServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS_COMMAND:
          serviceImpl.processCommand((org.sample.park.CommandRequest) request,
              (io.grpc.stub.StreamObserver<org.sample.park.CommandResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class CarParkServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.sample.park.CarParkServiceProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CarParkServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CarParkServiceDescriptorSupplier())
              .addMethod(METHOD_PROCESS_COMMAND)
              .build();
        }
      }
    }
    return result;
  }
}
