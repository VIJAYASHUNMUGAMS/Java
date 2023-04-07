package com.pkg.view;

import java.io.*;

class StreamClass {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			int x = 0, y = 0, z = 0;

			System.out.println("Enter x:");
			x = Integer.parseInt(br.readLine());
			System.out.println("Enter y:");
			y = Integer.parseInt(br.readLine());
			z = x + y;

			System.out.println("Z :" + z);
		
		} catch (NumberFormatException nfe) {
			System.out.println("Number form exce");
			// nfe.printStackTrace();
		} catch (Exception ex) {
			System.out.println("except");
			// nfe.printStackTrace();
		} finally {
			System.out.println("Finally");
			br.close();
			isr.close();			
		}
	}
}

