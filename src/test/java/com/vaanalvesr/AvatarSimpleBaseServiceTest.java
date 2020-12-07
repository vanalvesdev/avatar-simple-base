package com.vaanalvesr;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class AvatarSimpleBaseServiceTest {

    @Inject
    AvatarSimpleBaseServiceGrpc.AvatarSimpleBaseServiceBlockingStub stub;

    @Test
    void getAvatarTest() {
        AvatarsReply reply = stub.findAllAvatars(Empty.newBuilder().build());
        assertEquals(8, reply.getAvatarsCount());
        assertEquals("Aang", reply.getAvatars(1).getName());
        assertTrue(!reply.getAvatars(0).getElementsList().isEmpty());
        System.out.println(reply.toString());
    }
}
