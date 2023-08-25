package com.kentoes.kpi.webflux.helpers;

import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.UUID;

@Service
public class RandomStringHelperImpl implements RandomStringHelper {
    private UUID generateUuid() {
        return UUID.randomUUID();
    }

    private byte[] convertUUIDToBytes(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    @Override
    public String generate() {
        byte[] bytes = convertUUIDToBytes(generateUuid());
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}