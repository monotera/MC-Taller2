package javeriana.ms.subtraction;

public class DataPersistence {
    String user;
    String dateInvocation;
    String port;
    String response;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDateInvocation() {
        return dateInvocation;
    }

    public void setDateInvocation(String dateInvocation) {
        this.dateInvocation = dateInvocation;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public DataPersistence() {
    }
}
