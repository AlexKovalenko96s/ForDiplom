package ua.kas.main;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

public class Test2 {

	public static void main(String[] args) throws IOException {
		int depth = 1; // Where depth is the range of the ip address
		int subDepth = 255; // subdepth is the subnet mask of the network
		int TIMEOUT = 500; // timeout is the maximum wait for another host for
							// the device
		/*
		 * User input will be better There exists a way to get LAN ip, but you
		 * used localhost address 127.0.0.1
		 */
		String ip = "192.168.0.1";
		String tmp = ip.substring(0, ip.lastIndexOf(".", ip.lastIndexOf(".") - 1)) + ".";
		ArrayList<InetAddress> lanMachines = new ArrayList<>();
		for (int j = 0; j < depth; j++) {
			for (int i = 1; i < subDepth; i++) {
				InetAddress a = InetAddress.getByName(tmp + j + "." + i);
				System.out.println(tmp + j + "." + i);
				if (a.isReachable(TIMEOUT))
					lanMachines.add(a);
			}
		}
		for (InetAddress ina : lanMachines) {
			System.out.println("Found: " + ina.toString());
		}
	}
}
