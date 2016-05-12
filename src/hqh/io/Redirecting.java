package hqh.io;

import java.io.*;
/*
 This program attaches standard input to a file, and redirects standard output and standard
error to another file.
 * */
class Redirecting {
	public static void main(String[] args) {
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream("Redirecting.java"));
			// Produces deprecation message:
			PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));
			System.setIn(in);
			System.setOut(out);
			System.setErr(out);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s;
			while ((s = br.readLine()) != null)
				System.out.println(s);
			out.close(); // Remember this!
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}