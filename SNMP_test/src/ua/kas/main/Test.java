package ua.kas.main;

import java.io.IOException;
import java.net.InetAddress;

public class Test {

	public static void scanAddresses(String subnet, int timeOut) {
		for (int endofAddr = 99; endofAddr < 255; endofAddr++) {
			try {
				String addr = subnet + "." + endofAddr;
				if (InetAddress.getByName(addr).isReachable(timeOut))
					System.out.println(addr + " found");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		scanAddresses("192.168.0", 200);
	}
}