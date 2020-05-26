	                       //ARNAV KUMAR MANDAL//
                                     //XYPHER//
 
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.io.*;
 
public class Solution{
//--------------------------MAIN---------------------------------------------------------------------//
	public static void main(String[] args) throws IOException {

	}
	
	
//--------------------------FAST IO objects/methods--------------------------------------------------//
	
	static Reader in= new Reader(System.in);
	static OutputWriter out = new OutputWriter(System.out);
	private static int ni(){int n = in.nextInt();return n;}
	private static long nl(){long n = in.nextLong();return n;}
	private double nd(){return Double.parseDouble(ns()); }
	private static String ns(){String s = in.nextString();return s;}
	private static int[] nai(int n){int[] a = new int[n];for(int i = 0;i < n;i++)a[i] = ni();return a;}
	private static long[] nal(int n){long[] a = new long[n];for(int i = 0;i < n;i++)a[i] = nl();return a;}
	private static StringBuilder sb(String s){StringBuilder S = new StringBuilder(s);return S;}
	private static HashSet<Integer> hsi(){HashSet<Integer> s = new HashSet<Integer>();return s;}
	private static HashSet<Long> hsl(){HashSet<Long> s = new HashSet<Long>();return s;}
	private static HashMap<Integer,Integer> hmii(){HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();return h;}
	private static HashMap<Long,Long> hmll(){HashMap<Long,Long> h = new HashMap<Long,Long>();return h;}
	private static HashMap<String,Integer> hmsi(){HashMap<String,Integer> h = new HashMap<String,Integer>();return h;}
	private static int[][] nmi(int n, int m){int A[][] = new int[n][m];for(int i=0;i<n;i++){for(int j=0;j<m;j++) {A[i][j] = ni();}}return A;}
	private static char[][] nmc(int n, int m){char A[][] = new char[n][m];for(int i=0;i<n;i++){StringBuilder s=sb(ns());for(int j=0;j<m;j++){A[i][j]=s.charAt(j);}}return A;}
	private static void op(Object o) {out.print(o);}
	private static void opl(Object o) {out.println(o);}
	private static void opai(int[] o){for(int a:o)op(a+" ");opl("");}
	private static void opad(double[] o){for(double a:o)op(a+" ");opl("");}
	private static void opal(long[] o){for(long a:o)op(a+" ");opl("");}
	private static void opac(char[] o){for(char a:o)op(a);opl("");}
	private static void opas(String[] o){for(String a:o)op(a+" ");opl("");}
	private static void opmi(int[][] o) {for(int i=0;i<o.length;i++)opai(o[i]);}
	private static void opml(long[][] o) {for(int i=0;i<o.length;i++)opal(o[i]);}
	private static void opmc(char[][] o) {for(int i=0;i<o.length;i++)opac(o[i]);}

//--------------------------FAST IO------------------------------------------------------------------//
	private static class Reader {
		private InputStream stream;
		private byte[] buf = new byte[4*1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		
		public Reader(InputStream stream) {
			this.stream = stream;
		}
		
		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}
		
		public int nextInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		
		public String nextString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
		
		public double nextDouble() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, nextInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E') {
						return res * Math.pow(10, nextInt());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		
		public long nextLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		
		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
		
		public String next() {
			return nextString();
		}
		
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
	private static class OutputWriter {
		private final PrintWriter writer;
		
		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}
		
		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}
		
		
		
		public void println(Object... objects) {
			print(objects);
			writer.println();
			writer.flush();
		}
		
		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0) {
					writer.print(' ');
				}
				writer.print(objects[i]);
			}
			writer.flush();
		}
		
		public void close() {
			writer.close();
		}
		
		public void flush() {
			writer.flush();
		}
	}
}  
