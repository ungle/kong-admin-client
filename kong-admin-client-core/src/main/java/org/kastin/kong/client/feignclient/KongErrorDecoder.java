package org.kastin.kong.client.feignclient;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

import org.kastin.kong.client.model.KongException;
import org.kastin.kong.client.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Optional;

public class KongErrorDecoder implements ErrorDecoder {
    private static final Logger log = LoggerFactory.getLogger(KongErrorDecoder.class);

    private final ObjectMapper mapper;

    public KongErrorDecoder(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public KongErrorDecoder() {
        this.mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.body() == null) {
        	if(response.status() == 404) {
        		return new KongException("404", 404, "path not found");
        	}
            return new KongException("500", 500, "no msg error");
        }
        try {
            Reader reader = response.body().asReader(Util.UTF_8);
            if (!reader.markSupported()) {
                reader = new BufferedReader(reader, 1);
            }
            reader.mark(1);
            if (reader.read() == -1) {
                return null; // Eagerly returning null avoids "No content to map due to end-of-input"
            }
            reader.reset();
            ErrorResponse errorResponse = mapper.readValue(reader, ErrorResponse.class);
            return new KongException(Optional.ofNullable(String.valueOf(errorResponse.getCode())).orElse(String.valueOf(response.status())),
            		response.status(), errorResponse.getMessage());
        } catch (JsonParseException | JsonMappingException e) {
            log.error("decode error: " + e.getLocalizedMessage(), e);
            return e;
        } catch (IOException e) {
            log.error("io error: " + e.getLocalizedMessage(), e);
            return e;
        }

    }
}
