package org.glassfish.jersey.client;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import javax.ws.rs.client.ClientFactory;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.HttpUrlConnector.ConnectionFactory;
import org.junit.Test;

public class HttpUrlConnectorTest {
   
	@Test
    public void testSSLConnection(){
    	JerseyClient client = (JerseyClient) ClientFactory.newClient();
    	ClientRequest request=client.target("https://localhost:8080").request().buildGet().request();
    	ConnectionFactory factory=new ConnectionFactory() {
			@Override
			public HttpURLConnection getConnection(URL endpointUrl) throws IOException {
				HttpURLConnection result=(HttpURLConnection) endpointUrl.openConnection();
				return wrapNoContentHttps(result);
			}
		};
    	HttpUrlConnector connector=new HttpUrlConnector(factory);
    	ClientResponse res=connector.apply(request);
    	assertEquals(Response.Status.NO_CONTENT,res.getStatusInfo());
    }

	protected HttpURLConnection wrapNoContentHttps(final HttpURLConnection result) {
		if (result instanceof HttpsURLConnection){
			return new HttpsURLConnection(result.getURL()) {
				private HttpsURLConnection delegate=(HttpsURLConnection) result;

				public String getHeaderFieldKey(int n) {
					return delegate.getHeaderFieldKey(n);
				}

				public String getHeaderField(int n) {
					return delegate.getHeaderField(n);
				}

				public void connect() throws IOException {
					delegate.connect();
				}

				public boolean getInstanceFollowRedirects() {
					return delegate.getInstanceFollowRedirects();
				}

				public int getConnectTimeout() {
					return delegate.getConnectTimeout();
				}

				public int getContentLength() {
					return delegate.getContentLength();
				}

				public long getContentLengthLong() {
					return delegate.getContentLengthLong();
				}

				public String getContentType() {
					return delegate.getContentType();
				}

				public long getHeaderFieldDate(String name, long Default) {
					return delegate.getHeaderFieldDate(name, Default);
				}

				public String getContentEncoding() {
					return delegate.getContentEncoding();
				}

				public void disconnect() {
					delegate.disconnect();
				}

				public long getExpiration() {
					return delegate.getExpiration();
				}

				public long getDate() {
					return delegate.getDate();
				}

				public InputStream getErrorStream() {
					return delegate.getErrorStream();
				}

				public long getLastModified() {
					return delegate.getLastModified();
				}

				public String getHeaderField(String name) {
					return delegate.getHeaderField(name);
				}

				public Map<String, List<String>> getHeaderFields() {
					return delegate.getHeaderFields();
				}

				public int getHeaderFieldInt(String name, int Default) {
					return delegate.getHeaderFieldInt(name, Default);
				}

				public long getHeaderFieldLong(String name, long Default) {
					return delegate.getHeaderFieldLong(name, Default);
				}

				public Object getContent() throws IOException {
					return delegate.getContent();
				}

				
				public Object getContent(@SuppressWarnings("rawtypes") Class[] classes) throws IOException {
					return delegate.getContent(classes);
				}

				public InputStream getInputStream() throws IOException {
					return delegate.getInputStream();
				}

				public boolean getDoInput() {
					return delegate.getDoInput();
				}

				public boolean getDoOutput() {
					return delegate.getDoOutput();
				}

				public boolean getAllowUserInteraction() {
					return delegate.getAllowUserInteraction();
				}

				public void addRequestProperty(String key, String value) {
					delegate.addRequestProperty(key, value);
				}

				public String getCipherSuite() {
					return delegate.getCipherSuite();
				}

				public boolean getDefaultUseCaches() {
					return delegate.getDefaultUseCaches();
				}

				public HostnameVerifier getHostnameVerifier() {
					return delegate.getHostnameVerifier();
				}

				public long getIfModifiedSince() {
					return delegate.getIfModifiedSince();
				}

				public Certificate[] getLocalCertificates() {
					return delegate.getLocalCertificates();
				}

				public Principal getLocalPrincipal() {
					return delegate.getLocalPrincipal();
				}

				public void setFixedLengthStreamingMode(int contentLength) {
					delegate.setFixedLengthStreamingMode(contentLength);
				}

				public void setChunkedStreamingMode(int chunklen) {
					delegate.setChunkedStreamingMode(chunklen);
				}

				public void setConnectTimeout(int timeout) {
					delegate.setConnectTimeout(timeout);
				}

				public OutputStream getOutputStream() throws IOException {
					return delegate.getOutputStream();
				}

				public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
					return delegate.getPeerPrincipal();
				}

				public void setFixedLengthStreamingMode(long contentLength) {
					delegate.setFixedLengthStreamingMode(contentLength);
				}

				public void setInstanceFollowRedirects(boolean followRedirects) {
					delegate.setInstanceFollowRedirects(followRedirects);
				}

				public void setRequestMethod(String method) throws ProtocolException {
					delegate.setRequestMethod(method);
				}

				public String getRequestMethod() {
					return delegate.getRequestMethod();
				}

				public int getResponseCode() throws IOException {
					return HttpURLConnection.HTTP_NO_CONTENT;
				}

				public void setReadTimeout(int timeout) {
					delegate.setReadTimeout(timeout);
				}

				public int getReadTimeout() {
					return delegate.getReadTimeout();
				}

				public URL getURL() {
					return delegate.getURL();
				}

				public String getResponseMessage() throws IOException {
					return delegate.getResponseMessage();
				}

				public boolean usingProxy() {
					return delegate.usingProxy();
				}

				public Permission getPermission() throws IOException {
					return delegate.getPermission();
				}

				public void setDoInput(boolean doinput) {
					delegate.setDoInput(doinput);
				}

				public void setDoOutput(boolean dooutput) {
					delegate.setDoOutput(dooutput);
				}

				public void setAllowUserInteraction(boolean allowuserinteraction) {
					delegate.setAllowUserInteraction(allowuserinteraction);
				}

				public void setUseCaches(boolean usecaches) {
					delegate.setUseCaches(usecaches);
				}

				public boolean getUseCaches() {
					return delegate.getUseCaches();
				}

				public void setIfModifiedSince(long ifmodifiedsince) {
					delegate.setIfModifiedSince(ifmodifiedsince);
				}

				public void setDefaultUseCaches(boolean defaultusecaches) {
					delegate.setDefaultUseCaches(defaultusecaches);
				}

				public String getRequestProperty(String key) {
					return delegate.getRequestProperty(key);
				}

				public Map<String, List<String>> getRequestProperties() {
					return delegate.getRequestProperties();
				}

				public SSLSocketFactory getSSLSocketFactory() {
					return delegate.getSSLSocketFactory();
				}

				public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
					return delegate.getServerCertificates();
				}

				public void setHostnameVerifier(HostnameVerifier v) {
					delegate.setHostnameVerifier(v);
				}

				public void setRequestProperty(String key, String value) {
					delegate.setRequestProperty(key, value);
				}

				public void setSSLSocketFactory(SSLSocketFactory sf) {
					delegate.setSSLSocketFactory(sf);
				}
				
			};
		}
		return result;
	}
	
	
}
