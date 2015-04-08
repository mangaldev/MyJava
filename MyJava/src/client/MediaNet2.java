package client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mdev on 4/6/15.
 */
public class MediaNet2 {

        static class Racer{
            int u;
            int a;

            @Override
            public String toString() {
                return "Racer{" +
                        "u=" + u +
                        ", a=" + a +
                        '}';
            }

            public Racer(int u, int a) {
                this.a = a;
                this.u = u;
            }
        }

        public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
            Scanner sc = new Scanner(System.in);

            int numRaces = sc.nextInt();
            List<Racer> list = new ArrayList<>();
            int count = 0;
            while(true){
                if(count == numRaces)
                    break;
                count++;
                int u = sc.nextInt();
                int a = sc.nextInt();
                list.add(new Racer(u,a));
            }
//            list.forEach(racer -> System.out.println("racer = " + racer));

            System.out.println(fun(list));

        }

    public static int fun(List<Racer> racers) {
        int s = racers.size();
        int result = 0;
        for (int i = 0; i < s; i++) {
            int min_num = 0;
            int max_num = 0;
            int min_den = 0;
            int max_den = 0;
            Racer a = racers.get(i);
            //System.out.println("Racer " + i);
            boolean isPossible = true;
            for (int j = 0; j < s && isPossible; j++) {
                if (i != j) {
                    Racer b = racers.get(j);
                    if (b.a > a.a) {
                        int num = a.u - b.u;
                        int den = b.a - a.a;
                        if (min_den == 0) {
                            min_num = num;
                            min_den = den;
                        } else if (min_num * den < min_den * num) {
                            min_num = num;
                            min_den = den;
                        }
                    } else if (a.a > b.a) {
                        int num = b.u - a.u;
                        int den = a.a - b.a;
                        if (max_den == 0) {
                            max_num = num;
                            max_den = den;
                        } else if (max_num * den > max_den * num) {
                            max_num = num;
                            max_den = den;
                        }
                    } else if (a.u < b.u) {
                        isPossible = false;
                    }
                    //System.out.println("min_num / min_den = " + min_num + " / " + min_den);
                    //System.out.println("max_num / max_den = " + max_num + " / " + max_den);
                    if (max_den == 0 && min_num < 0) {
                        isPossible = false;
                    } else if (max_den != 0 && min_den != 0 && max_num * min_den > max_den * min_num) {
                        isPossible = false;
                    }
                }
            }
            if (isPossible) {
                result++;
            }
        }
        return result;
    }


    }
