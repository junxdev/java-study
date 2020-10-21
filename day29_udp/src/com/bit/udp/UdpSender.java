package com.bit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class UdpSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String msg = "Hello UDP";
		byte[] ip = {(byte)192, (byte)168, (byte)0, (byte)148};
		int port = 8080;
		
		DatagramSocket socket = null;
		DatagramPacket packet = null;
		try {
			socket = new DatagramSocket();
			InetAddress address = InetAddress.getByAddress(ip);
			packet = new DatagramPacket(msg.getBytes(), msg.length(), address, port);
			socket.send(packet);
			packet = new DatagramPacket("한글".getBytes(), "한글".getBytes().length, address, port);
			socket.send(packet);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(socket != null) {
				socket.close();
			}
		}
	}

}
