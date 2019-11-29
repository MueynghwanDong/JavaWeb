package com.ssafy.day10.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InteAddrTest {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet = InetAddress.getByName("ssafy.com");
		System.out.println(inet.getHostAddress());
		InetAddress inet2 = InetAddress.getLocalHost();
		System.out.println(inet2.getHostAddress());
	}
}
