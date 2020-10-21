package com.bit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 8080;
		DatagramSocket socket = null;
		DatagramPacket packet = null;
		byte[] buf = new byte[9];
		try {
			socket = new DatagramSocket(port);
			packet = new DatagramPacket(buf, buf.length);
			System.out.println("receiver waiting");
			socket.receive(packet);
			System.out.println("received");
			byte[] data = packet.getData();
			System.out.println(new String(data));
			System.out.println("receiver waiting");
			socket.receive(packet);
			System.out.println("received");
			data = packet.getData();
			System.out.println(new String(data));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
