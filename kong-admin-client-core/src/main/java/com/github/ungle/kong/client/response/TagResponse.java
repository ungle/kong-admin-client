package com.github.ungle.kong.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TagResponse {
    @JsonProperty("entity_name")
    private String entityName;
    @JsonProperty("entity_id")
    private String entityId;
    private String tag;

    public TagResponse(String entityName, String entityId, String tag) {
        this.entityName = entityName;
        this.entityId = entityId;
        this.tag = tag;
    }

    public TagResponse() {
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
