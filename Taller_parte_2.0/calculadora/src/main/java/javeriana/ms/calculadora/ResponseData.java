package javeriana.ms.calculadora;

public class ResponseData {
    String response;
    String port;
    String dateInvocation;
    String user;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDateInvocation() {
        return dateInvocation;
    }

    public void setDateInvocation(String dateInvocation) {
        this.dateInvocation = dateInvocation;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ResponseData() {
    }

    @Override
    public String toString() {
        return "ResponseData [dateInvocation=" + dateInvocation + ", port=" + port + ", response=" + response
                + ", user=" + user + "]";
    }

}
