package com.mabiao.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionParams;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpClientUtil {

	//private static Logger log = Logger.getLogger(HttpClientUtil.class);

	public static String getDataFromUrl(String url, String encoding) {
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setContentCharset(encoding);
		httpClient.getParams().setParameter(HttpConnectionParams.CONNECTION_TIMEOUT, 1000);
		httpClient.getParams().setParameter(HttpConnectionParams.SO_TIMEOUT, 1000);

		PostMethod post = new PostMethod(url);
		try {
			int statusCode = httpClient.executeMethod(post);
			if (statusCode != HttpStatus.SC_OK) {
				return "ERROR";
			}
			//return post.getResponseBodyAsString();
			InputStream inputStream = post.getResponseBodyAsStream();
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream, encoding));
			StringBuffer sb = new StringBuffer();
			String line = null;
			while ((line = bufferReader.readLine()) != null) {
				sb.append(line);
			}
			bufferReader.close();
			return sb.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			//log.error("getDataFromUrl has an error! url:"+url, ex );
			return "ERROR";
		}
	}

	public static String getDataFromUrl1(String url, String encoding) {
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setContentCharset(encoding);
		PostMethod post = new PostMethod(url);
		try {
			int statusCode = httpClient.executeMethod(post);
			if (statusCode != HttpStatus.SC_OK) {
				return "ERROR";
			}
			//return post.getResponseBodyAsString();
			InputStream inputStream = post.getResponseBodyAsStream();
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream, encoding));
			StringBuffer sb = new StringBuffer();
			String line = null;
			while ((line = bufferReader.readLine()) != null) {
				sb.append(line);
			}
			bufferReader.close();
			return sb.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return "ERROR";
		}
	}
}
