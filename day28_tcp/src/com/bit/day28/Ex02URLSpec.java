package com.bit.day28;

import java.net.MalformedURLException;
import java.net.URL;

public class Ex02URLSpec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// scheme : [//[user:password@]host[:port]][/]path[?query][#fragment]
		// ��������://ȣ��Ʈ:��Ʈ��ȣ/�н�?����#������
		String spec = "http://www.seoul.go.kr/news/news_tender.do#view/318319";
		URL url = null;
		
		try {
			url = new URL(spec);
			System.out.println(url.getProtocol()); // http
			System.out.println(url.getHost()); // www.seoul.go.kr
			System.out.println(url.getPort()); // -1
			System.out.println(url.getDefaultPort()); // 80
			// http; default port : 80; http�� �����ϱ� ���� 80�� ��Ʈ�� ���� ���´�.
			// https; default port : 443;
			System.out.println(url.getPath()); // /new/news_tender.do
			System.out.println(url.getQuery()); // null(URL Query != DB Query)
			System.out.println(url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
