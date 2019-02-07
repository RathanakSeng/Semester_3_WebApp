package user.authentication;

public class User {
    private String name;
    private String ipAddr;
    private String protocol;
    private String URI;

    public String getName() {
        return name;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getURI() {
        return URI;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    @Override
    public String toString() {
        return name + " - IPAddress: " + ipAddr + " - Protocol: " + protocol + " - URI: " + URI + "\n\n";
    }
}
