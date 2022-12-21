package io.github.ungle.kong.client.enums;

public enum JWTAlgorithm {
	HS256, HS384, HS512, RS256, RS384, RS512, ES256, ES384;

	
	public static String getAliasName(JWTAlgorithm algorithm) {
		if(algorithm.name().startsWith("HS")) {
			return algorithm.name().replaceAll("HS", "HMAC");
		} else if (algorithm.name().startsWith("ES")) {
			return algorithm.name().replace("ES", "ECDSA");
		} else {
			return algorithm.name().replace("RS", "RSA");
		}
	}
	
	

	public static boolean needSecret(JWTAlgorithm algorithm) {
		if (algorithm.name().startsWith("HS")) {
			return true;
		}
		return false;
	}

}
