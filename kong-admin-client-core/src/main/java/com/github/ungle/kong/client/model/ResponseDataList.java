package com.github.ungle.kong.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ResponseDataList {
    private JsonNode data;
    private String next;
    @JsonProperty("node_id")
    private String nodeId;

    public ResponseDataList() {
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public JsonNode getData() {
        return data;
    }

    public void setData(JsonNode data) {
        this.data = data;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String convertToFormatString(ObjectMapper mapper) throws JsonProcessingException {
        if (data.isObject()) {
            ObjectNode objectNode = (ObjectNode) data;
            if (objectNode.isEmpty()) {
                data = mapper.createArrayNode();
            }
        }
        return mapper.writeValueAsString(this);
    }
}
