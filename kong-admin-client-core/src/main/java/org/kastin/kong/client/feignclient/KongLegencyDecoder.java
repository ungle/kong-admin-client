package org.kastin.kong.client.feignclient;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import feign.Response;
import feign.Util;
import feign.codec.Decoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collections;

import org.kastin.kong.client.model.ResponseDataList;
/**
 * 
 * @author ungle
 * for a legacy problem existing in kong 1.x
 * To have compatibility with 1.x, set it as decoder when creating kong client
 */
public class KongLegencyDecoder implements Decoder {
    private final ObjectMapper mapper;

    public KongLegencyDecoder() {
        this(Collections.<Module>emptyList());
    }

    public KongLegencyDecoder(Iterable<Module> modules) {
        this(new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModules(modules));
    }

    public KongLegencyDecoder(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException {
        if (response.body() == null) {
            return null;
        }
        Reader reader = response.body().asReader(Util.UTF_8);
        if (!reader.markSupported()) {
            reader = new BufferedReader(reader, 1);
        }
        try {
            // Read the first byte to see if we have any data
            reader.mark(1);
            if (reader.read() == -1) {
                return null; // Eagerly returning null avoids "No content to map due to end-of-input"
            }
            reader.reset();

            if (type.getTypeName().contains("ApiDataList")) {
                ResponseDataList responseDataList = mapper.readValue(reader, ResponseDataList.class);
                return mapper.readValue(responseDataList.convertToFormatString(mapper), mapper.constructType(type));
            }
            return mapper.readValue(reader, mapper.constructType(type));
        } catch (RuntimeJsonMappingException e) {
            if (e.getCause() != null && e.getCause() instanceof IOException) {
                throw (IOException) e.getCause();
            }
            throw e;
        }
    }
}
