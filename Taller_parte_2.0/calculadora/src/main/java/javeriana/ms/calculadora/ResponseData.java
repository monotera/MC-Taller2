package javeriana.ms.calculadora;

public class ResponseData {
    String response;
    String port;
    String invocationDate;
    String user;
    String operation;

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

    public String getInvocationDate() {
        return invocationDate;
    }

    public void setInvocationDate(String invocationDate) {
        this.invocationDate = invocationDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public ResponseData() {
    }

    public ResponseData(String response, String port, String invocationDate, String user, String operation) {
        this.response = response;
        this.port = port;
        this.invocationDate = invocationDate;
        this.user = user;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "ResponseData [invocationDate=" + invocationDate + ", port=" + port + ", response=" + response
                + ", user=" + user + "]";
    }

}
