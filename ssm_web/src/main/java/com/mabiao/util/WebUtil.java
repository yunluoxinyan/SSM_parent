package com.mabiao.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
/**
 * @author created by mabiao on 2018/11/5
 */
public class WebUtil {


	public static String getIp(HttpServletRequest request) {

		String ip = request.getHeader("X-Forwarded-For");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");

		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");

		}
		if (ip == null || "".equals(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();

		}

		String[] ips;
		if (ip != null) {
			ips = ip.split(",");
			ip = ips[0];
		}
		return ip;
	}


	/**
	 获取本机IP
	 */
	public static List<String> getHostAddress() {
		List<String> list = new ArrayList<String>();
		try {
			Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip;
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = allNetInterfaces.nextElement();
				Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					ip = addresses.nextElement();
					if (ip != null && ip instanceof Inet4Address && !ip.getHostAddress().equals("127.0.0.1")) {
						list.add(ip.getHostAddress());
					}
				}
			}
		} catch (Exception e) {

		}
		return list;
	}

	/**
	 获取本机IP
	 */
	public static String getHostAddressOne() {
		List<String> list = getHostAddress();
		if (!BaseUtil.isNullOrEmpty(list)) {
			return list.get(0);
		}
		return "";
	}

	public static void main(String[] args) {
		String address = getHostAddressOne();
		System.out.println(address);
	}
}

