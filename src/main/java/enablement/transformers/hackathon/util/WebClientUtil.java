package enablement.transformers.hackathon.util;

import com.gargoylesoftware.htmlunit.WebClient;

import java.io.Serializable;

public class WebClientUtil implements Serializable,Cloneable {

    private static final long serialVersionUID = 1L;
    private static volatile WebClient instance;

    private WebClientUtil() {
    }
    public static WebClient getInstance() {
        if (instance == null) {
            synchronized (WebClient.class) {
                if (instance == null) {
                    instance = new WebClient();
                }
            }
        }
        return instance;
    }
    protected Object readResolve() {
        return instance;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}

