package io.github.ungle.kong.client.enums;

public enum HttpMethod {
    POST,
    GET,
    PUT,
    DELETE,
    HEAD,
    OPTIONS,
    PATCH,
    COPY,
    LINK,
    UNLINK,
    PURGE,
    LOCK,
    UNLOCK,
    PROPFIND,
    VIEW;
	
	public enum SessionAllowedMethod {
		GET,
		POST,
		DELETE;
	}
	
	public enum CORSAllowedMethod{
		GET, HEAD, PUT, PATCH, POST, DELETE, OPTIONS, TRACE, CONNECT;
		
	}
}
