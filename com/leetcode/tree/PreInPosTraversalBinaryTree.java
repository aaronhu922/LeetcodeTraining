package com.leetcode.tree;

import java.util.*;

public class PreInPosTraversalBinaryTree {

    public static void preOrderTraversalUnRecur(Node head) {
        System.out.println("pre-order");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null)
                    stack.push(head.right);
                if (head.left != null) {
                    stack.push(head.left);
                }
            }

        }
        System.out.println();
    }

    /*
     * Double stack
     * */
    public static void postOrderTraversalUnRecur(Node head) {
        System.out.println("post-order");
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null)
                    stack1.push(head.right);

            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }

        }
        System.out.println();
    }

    public static void inOrderTraversalUnRecur(Node head) {
        System.out.println("in-order");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void widthTraversal(Node head) {
        System.out.print("width-order");
        if (head != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                System.out.print(cur.value + " ");
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
    }


    //TODO: 不用hashmap，用Node curEnd， nextEnd, int nodeCount, 来实现。
    public static int getMaxWidthOfTree(Node head) {
        System.out.print("width-order");
        if (head != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            Map<Node, Integer> levelMap = new HashMap<>();
            levelMap.put(head, 1);
            int curLevel = 1;
            int curLevelNodesCount = 0;
            int max = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                int curNodeLevel = levelMap.get(cur);

                if (curNodeLevel == curLevel) {
                    curLevelNodesCount++;
                } else {
                    max = Math.max(max, curLevelNodesCount);
                    curLevel++;
                    curLevelNodesCount = 1;
                }

                System.out.print(cur.value + " ");
                if (cur.left != null) {
                    levelMap.put(cur.left, curNodeLevel + 1);
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    levelMap.put(cur.right, curNodeLevel + 1);
                    queue.add(cur.right);
                }
            }
            return Math.max(max, curLevelNodesCount);
        }
        return 0;
    }

    //不用hashmap，用Node curEnd， nextEnd, int nodeCount, 来实现。
    public static int getMaxWidthOfTreeNoMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head;
        Node nextEnd = null; //最新的进队节点。
        int max = 0;
        int curLevelCount = 0;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            curLevelCount++;

            System.out.print(curr.value + " ");
            if (curr.left != null) {
                queue.add(curr.left);
                nextEnd = curr.left;
            }
            if (curr.right != null) {
                queue.add(curr.right);
                nextEnd = curr.right;
            }

            if (curEnd == curr) {
                curEnd = nextEnd;
                max = Math.max(max, curLevelCount);
                curLevelCount = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        PreInPosTraversalBinaryTree.inOrderTraversalUnRecur(bt.root);
        PreInPosTraversalBinaryTree.widthTraversal(bt.root);
        int width = PreInPosTraversalBinaryTree.getMaxWidthOfTree(bt.root);
        System.out.println("width is: " + width);

        int width1 = PreInPosTraversalBinaryTree.getMaxWidthOfTreeNoMap(bt.root);
        System.out.println("width1 is: " + width1);

    }

}

