package tree;


import java.util.HashMap;
import java.util.Map;

public class TreeFromInPre {
    public TreeFromInPre() {
        super();
    }
    private static int iCount = 0;

    public static void main(String[] args) {
        String strInOrder = "DBEAFC";
        String strPreOrder = "ABDECF";
        //        Integer iCount = new Integer(0);
        Node oTreeRoot = //createTree(strInOrder,0,strInOrder.length(),strPreOrder);
            createTree(strInOrder, strPreOrder, 0, strPreOrder.length() - 1);
        printPreOrder(oTreeRoot);
    }
//DBE   A   FC
//
    public static Map<Character,Node> cache = new HashMap<>();


    public static Node createTree(String strIn,int startIn, int endIn,String strPre){
        if(strPre.length() == iCount)
            return null;
        Node newNode = null;
        char rootChar = strPre.charAt(iCount);
        iCount++;
        if(cache.containsKey(rootChar))
            newNode = cache.get(rootChar);
        else {
            newNode = new Node(rootChar);
            cache.put(rootChar,newNode);
        }

        int index = strIn.indexOf(rootChar); // 3
        newNode.left = createTree(strIn,startIn,index-1,strPre); //0,2
        newNode.right = createTree(strIn,index + 1,endIn,strPre); // 4,5
        return newNode;
    }


    private static Node createTree(String strInOrder, String strPreOrder,
                                   int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return null;
        int strCurrentCharIndex =
            strInOrder.indexOf(strPreOrder.charAt(iCount), startIndex);
        Node oNode = null;
        if (strCurrentCharIndex <= endIndex &&
            strCurrentCharIndex >= startIndex) {
            oNode = new Node(strInOrder.charAt(strCurrentCharIndex));
            iCount++;
        } else
            return null;
        if (endIndex == startIndex)
            return oNode;

        oNode.setLeft(createTree(strInOrder, strPreOrder, startIndex,
                                 strCurrentCharIndex - 1));
        oNode.setRight(createTree(strInOrder, strPreOrder,
                                  strCurrentCharIndex + 1, endIndex));
        return oNode;
    }

    private static void printPreOrder(Node oTreeRoot) {
        if (oTreeRoot == null)
            return;
        System.out.printf(" %c ", oTreeRoot.getData());
        printPreOrder(oTreeRoot.getLeft());
        printPreOrder(oTreeRoot.getRight());
    }
}

class Node {
    Node left = null;
    Node right = null;
    Object data = null;

    Node(Object o) {
        this.data = o;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
