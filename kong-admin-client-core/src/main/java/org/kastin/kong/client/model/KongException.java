package org.kastin.kong.client.model;

public class KongException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 491946898969392327L;
	private String kongCode;
    private int kongStatusCode;

    public KongException(String kongCode, int kongStatusCode, String message) {
        super(message);
        this.kongCode = kongCode;
        this.kongStatusCode = kongStatusCode;
    }

    public KongException() {
    }

    public KongException(String message) {
        super(message);
    }

    public KongException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getKongCode() {
        return kongCode;
    }

    public int getKongStatusCode() {
        return kongStatusCode;
    }
}
