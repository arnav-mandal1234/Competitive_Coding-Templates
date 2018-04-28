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


class Solution{
	
	int st[];
	 
    Solution(int arr[], int n)
    {
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
 
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        
        st = new int[max_size];
        
        build(arr, 0, n - 1, 0);
    }
    
    int build(int arr[], int ss, int se, int si)
    {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
 
        int mid = getMid(ss, se);
        
        st[si] = build(arr, ss, mid, si * 2 + 1) +
        		 build(arr, mid + 1, se, si * 2 + 2);
        
        return st[si];
    }
    
    void update(int ss, int se, int i, int diff, int si)
    {
        if (i < ss || i > se)
            return;
        
        st[si] = st[si] + diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            update(ss, mid, i, diff, 2 * si + 1);
            update(mid + 1, se, i, diff, 2 * si + 2);
        }
    }
    
    int get(int ss, int se, int qs, int qe, int si)
    {
        if (qs <= ss && qe >= se)
            return st[si];
        
        if (se < qs || ss > qe)
            return 0;
 
        int mid = getMid(ss, se);
        return get(ss, mid, qs, qe, 2 * si + 1) +
        	   get(mid + 1, se, qs, qe, 2 * si + 2);
    }
    
    int getMid(int s, int e) {
        return s + (e - s) / 2;
    }
   
	
//--------------------------MAIN---------------------------------------------------------------------//
	public static void main(String[] args) throws IOException {
		Reader a= new Reader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		//Scanner a = new Scanner(System.in);
				
				
	}
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
