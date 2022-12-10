package org.kastin.kong.client.requests.plugins;

import java.util.Set;

import org.kastin.kong.client.requests.Request;

/**
 * 
 * @author ungle
 *
 */
public class AclRequest extends Request {
    private String group;
    private Set<String> tags;

    public AclRequest(String group, Set<String> tags) {
    	super();
        this.group = group;
        this.tags = tags;
    }

    public AclRequest(String group) {
    	super();
        this.group = group;
    }

    public AclRequest() {
    	super();
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
