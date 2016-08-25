package org.maxsoft.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
	public class Node{
		Node left;
		Node right;
		int data;
		public Node(int data) {
			this.left = null;
			this.right = null;
			this.data = data;
		}
	}
	
	/**
	 * 通过给定的数组建立二叉树
	 * @param a
	 * @return
	 */
	public Node buildTree(int[] a){
		LinkedList<Node> list = new LinkedList<Node>();
		for (int i = 0; i < a.length; i++) {
			list.add(new Node(a[i]));
		}
		int len = list.size();
		int parent = (len/2)-1;//计算二叉树中的双亲节点数
		for (int i = 0; i < parent; i++) {
			list.get(i).left = list.get(i*2+1);
			list.get(i).right = list.get(i*2+2);
		}
		
		//最后的节点特殊处理
		list.get(parent).left = list.get(parent*2+1);
		if(len%2==1){ //判断树的最后节点是否存在右孩子
			list.get(parent).right = list.get(parent*2+2);
		}
		
		return list.get(0);
	}
	
	/**
	 * 先序遍历
	 * @param root
	 */
	public void preOrder(Node root){
		System.out.print(" " + root.data);
		if(root.left != null){
			preOrder(root.left);
		}
		if(root.right != null){
			preOrder(root.right);
		}
	}
	
	/**
	 * 中序遍历
	 * @param root
	 */
	public void midOrder(Node root){
		if(root.left != null){
			midOrder(root.left);
		}
		System.out.print(" " + root.data);
		if(root.right != null){
			midOrder(root.right);
		}
	}
	
	/**
	 * 后续遍历
	 * @param root
	 */
	public void posOrder(Node root){
		if(root.left != null){
			posOrder(root.left);
		}
		if(root.right != null){
			posOrder(root.right);
		}
		System.out.print(" "+root.data);
	}
	
	/**
	 * 获取树的深度
	 * @param root
	 * @return
	 */
	public int getTreeDeep(Node root){
		if(root == null) return 0;
		
		Node left = root.left;
		int leftdeep = 0;
		if(left != null) {
			leftdeep = getTreeDeep(left);
		}
		
		Node right = root.right;
		int rightdeep = 0;
		if(right != null){
			rightdeep = getTreeDeep(right);
		}
		
		if(leftdeep > rightdeep){
			return leftdeep+1;
		}
		return rightdeep+1;
	}
	
	/**
	 * 获取树的最大宽度
	 * @param root
	 * @return
	 */
    public int getTreeWidth(Node root) {
        if (root == null)
            return 0;

        Queue<Node> queue = new ArrayDeque<Node>();
        int maxWitdth = 1; // 最大宽度
        queue.add(root); // 入队

        while (true) {
            int len = queue.size(); // 当前层的节点个数
            if (len == 0)
                break;
            while (len > 0) {// 如果当前层，还有节点
                Node t = queue.poll();
                len--;
                if (t.left != null)
                    queue.add(t.left); // 下一层节点入队
                if (t.right != null)
                    queue.add(t.right);// 下一层节点入队
            }
            maxWitdth = Math.max(maxWitdth, queue.size());
        }
        return maxWitdth;
    }
	
	/**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public Node levelOrderTraversal(Node root,int data){
        if(root==null){
            System.out.println("empty tree");
            return null;
        }
        Queue<Node> queue=new ArrayDeque<Node>();
        queue.add(root);
        while(queue.isEmpty()==false){
            Node node=queue.poll();
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            if(node.data==data){
            	return node;
            }
        }
        return null;
    }
    
    /**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversal(Node root){
        if(root==null){
            System.out.println("empty tree");
            return;
        }       
        Stack<Node> stack=new Stack<Node>();
        stack.push(root);       
        while(stack.isEmpty()==false){
            Node node=stack.pop();
            System.out.print(node.data+"    ");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }           
        }
        System.out.print("\n");
    }
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(a);
		//System.out.println(root.left.left.right.data);
		System.out.println("先序：");
		tree.preOrder(root);
		System.out.println("\n中序：");
		tree.midOrder(root);
		System.out.println("\n后续：");
		tree.posOrder(root);
		System.out.println("\n树的深度：" + tree.getTreeDeep(root));
		System.out.println("\n树的宽度：" + tree.getTreeWidth(root));
		System.out.println("\n节点：" + tree.levelOrderTraversal(root,2).data);

		tree.depthOrderTraversal(root);
	}

}
