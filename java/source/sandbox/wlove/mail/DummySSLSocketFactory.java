package sandbox.wlove.mail;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

import com.sun.net.ssl.SSLContext;
import com.sun.net.ssl.TrustManager;

@SuppressWarnings("deprecation")
public class DummySSLSocketFactory
    extends SSLSocketFactory
{
    private SSLSocketFactory factory;

    public DummySSLSocketFactory()
    {
        System.out.println("DummySocketFactory instantiated");
        try
        {
            SSLContext sslcontext = SSLContext.getInstance("TLS");
            sslcontext.init(null, // No KeyManager required
                new TrustManager[]
                {
                    new DummyTrustManager()
                },
                new java.security.SecureRandom());
            factory = sslcontext.getSocketFactory();
        }
        catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }

    public static synchronized SocketFactory getDefault()
    {
        return new DummySSLSocketFactory();
    }

    @Override
    public Socket createSocket(Socket socket, String s, int i, boolean flag) throws IOException
    {
        return factory.createSocket(socket, s, i, flag);
    }

    @Override
    public Socket createSocket(InetAddress inaddr, int i, InetAddress inaddr1, int j)
        throws IOException
    {
        return factory.createSocket(inaddr, i, inaddr1, j);
    }

    @Override
    public Socket createSocket(InetAddress inaddr, int i) throws IOException
    {
        return factory.createSocket(inaddr, i);
    }

    @Override
    public Socket createSocket(String s, int i, InetAddress inaddr, int j) throws IOException
    {
        return factory.createSocket(s, i, inaddr, j);
    }

    @Override
    public Socket createSocket(String s, int i) throws IOException
    {
        return factory.createSocket(s, i);
    }

    @Override
    public String[] getDefaultCipherSuites()
    {
        return factory.getSupportedCipherSuites();
    }

    @Override
    public String[] getSupportedCipherSuites()
    {
        return factory.getSupportedCipherSuites();
    }
}
