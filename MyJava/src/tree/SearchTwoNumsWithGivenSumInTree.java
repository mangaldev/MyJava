package tree;

/**
 * Created by mdev on 3/30/15.
 */

public class SearchTwoNumsWithGivenSumInTree {

    public static void main(String[] args) {
        int[] input = {32,24,41,21,28,36,47,14,-1,25,31,-1,39,-1,-1};
        TreeHelper.Node root = TreeHelper.createTree(input);
        new Inorder1(root).start();
        new Inorder2(root).start();

    }
    static int givenNum = 66;
    static int p1= -1;
    static int p2= -1;
    static Object lock2 = new Object();
    static Object lock1 = new Object();

    static class Inorder1 extends Thread{

        TreeHelper.Node root;

        public Inorder1(TreeHelper.Node root) {
            this.root = root;
        }

        public void run(){
            try {
                inorder1(root);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void inorder1(TreeHelper.Node node) throws InterruptedException {
            if(node == null)
                return;
            inorder1(node.left);
            System.out.println("node.data = " + node.data);
                p1 = node.data;
            if(p2 == -1){
                synchronized (lock1)
                {
                    lock1.wait();
                }
            }
            if(p1+ p2 > 66){
                synchronized (lock2)
                {
                    lock2.notify();
                }
                synchronized (lock1) {
                    lock1.wait();
                }
            }
            else if(p1+ p2 == 66){
                System.out.println("GOt IT");
                System.out.println("p1 = " + p1);
                System.out.println("p2 = " + p2);
            }
            inorder1(node.right);
        }

    }

    static class Inorder2 extends Thread{

        TreeHelper.Node root;

        public Inorder2(TreeHelper.Node root) {
            this.root = root;
        }

        public void run(){
            try {
                inorder2(root);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void inorder2(TreeHelper.Node node) throws InterruptedException {
            if(node == null)
                return;
            inorder2(node.right);
            System.out.println("node.data = " + node.data);
            if(p2==-1) {
                p2 = node.data;
                synchronized (lock1) {
                    lock1.notify();
                }
            }

            if(p1+ p2 < 66){
                synchronized (lock1)
                {
                    lock1.notify();
                }
                synchronized (lock2) {
                    lock2.wait();
                }
            }
            else if(p1+ p2 == 66){
                System.out.println("GOt IT");
                System.out.println("p2 = " + p2);
                System.out.println("p1 = " + p1);
            }
            inorder2(node.left);
        }

    }


}
