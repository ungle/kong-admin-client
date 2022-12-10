package com.github.ungle.kong.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiDataList<T> {

    private List<T> data;
    private String next;

    @JsonProperty("node_id")
    private String nodeId;


    public ApiDataList() {
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String findOffset() {
        if (next == null || next.isEmpty()) {
            return null;
        }
        try {
            String offset = null;
            URL url = new URL(next);
            String[] queries = url.getQuery().split("&");
            for (String query : queries) {
                if (query.startsWith("offset=")) {
                    offset = query.replaceAll("offset=", "");
                    break;
                }
            }
            return offset;

        } catch (Exception e) {
            throw new IllegalArgumentException("could not obtain offset: " + next);
        }

    }
}
