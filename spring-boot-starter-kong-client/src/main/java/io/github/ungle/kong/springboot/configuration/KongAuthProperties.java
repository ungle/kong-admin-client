package io.github.ungle.kong.springboot.configuration;

/**
 * @author ungle
 */

public class KongAuthProperties {

    private BasicAuthProperties basicAuth;
    private KeyAuthProperties keyAuth;

    @Override
    public String toString() {
        return "KongAuthProperties{" +
                "basicAuth=" + basicAuth +
                ", keyAuth=" + keyAuth +
                '}';
    }

    public BasicAuthProperties getBasicAuth() {
        return basicAuth;
    }

    public void setBasicAuth(BasicAuthProperties basicAuth) {
        this.basicAuth = basicAuth;
    }

    public KeyAuthProperties getKeyAuth() {
        return keyAuth;
    }

    public void setKeyAuth(KeyAuthProperties keyAuth) {
        this.keyAuth = keyAuth;
    }

    public static class BasicAuthProperties {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "BasicAuthProperties{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    public static class KeyAuthProperties {
        private String headerName;
        private String apiKey;

        public String getHeaderName() {
            return headerName;
        }

        public void setHeaderName(String headerName) {
            this.headerName = headerName;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        @Override
        public String toString() {
            return "KeyAuthProperties{" +
                    "headerName='" + headerName + '\'' +
                    ", apiKey='" + apiKey + '\'' +
                    '}';
        }
    }
}
