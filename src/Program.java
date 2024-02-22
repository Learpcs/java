import java.lang.reflect.Array;
import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void dfs(int v, ArrayList<Integer>[] g) {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test >= 0) {
            int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
            --a; --b;
            ArrayList<Integer>[] g = new ArrayList[n];
            for (int i =0 ; i < n; ++i) {
                int l = sc.nextInt(), r = sc.nextInt();
                --l; --r;
                g[l].add(r);
                g[r].add(l);
            }
            java.util.function.BiFunction<Integer, Integer> dfs =
        }
    }
}
