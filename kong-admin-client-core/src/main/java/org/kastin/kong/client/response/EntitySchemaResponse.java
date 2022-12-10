package org.kastin.kong.client.response;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class EntitySchemaResponse {
	
	private List<ObjectNode> fields;

	public List<ObjectNode> getFields() {
		return fields;
	}

	public void setFields(List<ObjectNode> fields) {
		this.fields = fields;
	}
	
	public ObjectNode retrievePluginConfig() {
		return this.fields.stream().filter(t ->t.has("config")).findFirst().orElseGet(null);
	}
	
	public ObjectNode retrieveElement(String elementName) {
		return this.fields.stream().filter(t ->t.has(elementName)).findFirst().orElseGet(null);
	}
	
	

}
