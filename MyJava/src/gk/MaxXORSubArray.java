package gk;

/**
 * Created by mdev on 8/20/16.
 */
public class MaxXORSubArray {
    static TrieNode root = new TrieNode(-1);

    private static String getBinaryStringIn32Bits(int num) {
        String binaryString = "";
        int len = Integer.toBinaryString(num).length();
        for (int i = len; i < 32; i++) binaryString += "0";
        binaryString += Integer.toBinaryString(num);
        return binaryString;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{8, 1, 2, 12, 7, 6};
//        int[] arr = new int[]{1, 2, 3, 4};
        int[] arr = new int[]{4, 6};
        int maxXOR = -1;
        int currentXOR = 0;
        for (int ele : arr) {
            currentXOR = currentXOR ^ ele;
            insertIntoTrie(currentXOR);
            int xor = getMaxXor(currentXOR);
            if (xor > maxXOR)
                maxXOR = xor;
        }
        System.out.println(maxXOR);

    }

    public static int getMaxXor(int num) {
        String binaryNum = getBinaryStringIn32Bits(num);
        TrieNode current = root;
        String result = "";
        for (int i = 0; i < binaryNum.length(); i++) {
            int currentBit = binaryNum.charAt(i) - '0';
            if (currentBit == 0)
                current = current.right != null ? current.right : current.left;
            else
                current = current.left != null ? current.left : current.right;
            result += current.bit;
        }
        return num ^ Integer.parseInt(result, 2);
    }

    public static void insertIntoTrie(int num) {
        String binaryNum = getBinaryStringIn32Bits(num);
        TrieNode current = root;
        for (int i = 0; i < binaryNum.length(); i++) {
            int currentBit = binaryNum.charAt(i) - '0';
            if (currentBit == 1)
                current = current.right == null ? TrieNode.giveRightNode(current) : current.right;
            else
                current = current.left == null ? TrieNode.giveLeftNode(current) : current.left;
        }
    }

    static class TrieNode {
        int bit;
        TrieNode left;
        TrieNode right;

        public TrieNode(int bit) {
            this.bit = bit;
        }

        public static TrieNode giveRightNode(TrieNode parentTrieNode) {
            TrieNode trieNode = new TrieNode(1);
            parentTrieNode.right = trieNode;
            return trieNode;
        }

        public static TrieNode giveLeftNode(TrieNode parentTrieNode) {
            TrieNode trieNode = new TrieNode(0);
            parentTrieNode.left = trieNode;
            return trieNode;
        }
    }
}
