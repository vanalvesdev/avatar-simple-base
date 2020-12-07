package com.vaanalvesr;

import io.grpc.ManagedChannel;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.grpc.annotation.GrpcChannel;
import io.micronaut.grpc.server.GrpcServerChannel;

@Factory
public class Clients {

    @Bean
    AvatarSimpleBaseServiceGrpc.AvatarSimpleBaseServiceBlockingStub blockingStub(
            @GrpcChannel(GrpcServerChannel.NAME) ManagedChannel channel) {
        return AvatarSimpleBaseServiceGrpc.newBlockingStub(channel);
    }
}
