package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class InputReader {
    BufferedReader in;
    StringTokenizer tokenizer = null;

    public InputReader() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }
    

    public String next() {
        try {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(in.readLine());
            }
            return tokenizer.nextToken();
        } catch (IOException e) {
            return null;
        }
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    
    public String nextLine()
    {
        try
        {
            return in.readLine();
        } catch (IOException e)
        {
            return null;
        }
    }


}
