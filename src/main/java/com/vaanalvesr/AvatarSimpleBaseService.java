package com.vaanalvesr;

import io.grpc.stub.StreamObserver;
import io.micronaut.grpc.annotation.GrpcService;

@GrpcService
public class AvatarSimpleBaseService extends AvatarSimpleBaseServiceGrpc.AvatarSimpleBaseServiceImplBase {

    AvatarRepository repository;

    public AvatarSimpleBaseService(AvatarRepository repository) {
        this.repository = repository;
    }

    @Override
    public void findAllNations(Empty request, StreamObserver<NationsReply> responseObserver) {
        NationsReply reply = NationsReply.newBuilder().addAllNations(repository.getNations()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void findAllElements(Empty request, StreamObserver<ElementsReply> responseObserver) {
        ElementsReply reply = ElementsReply.newBuilder().addAllElements(repository.getElements()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void findAllAvatars(Empty request, StreamObserver<AvatarsReply> responseObserver) {
        AvatarsReply reply = AvatarsReply.newBuilder().addAllAvatars(repository.getAvatars()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
