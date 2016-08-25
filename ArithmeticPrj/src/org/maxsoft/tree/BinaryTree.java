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
	 * ͨ�����������齨��������
	 * @param a
	 * @return
	 */
	public Node buildTree(int[] a){
		LinkedList<Node> list = new LinkedList<Node>();
		for (int i = 0; i < a.length; i++) {
			list.add(new Node(a[i]));
		}
		int len = list.size();
		int parent = (len/2)-1;//����������е�˫�׽ڵ���
		for (int i = 0; i < parent; i++) {
			list.get(i).left = list.get(i*2+1);
			list.get(i).right = list.get(i*2+2);
		}
		
		//���Ľڵ����⴦��
		list.get(parent).left = list.get(parent*2+1);
		if(len%2==1){ //�ж��������ڵ��Ƿ�����Һ���
			list.get(parent).right = list.get(parent*2+2);
		}
		
		return list.get(0);
	}
	
	/**
	 * �������
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
	 * �������
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
	 * ��������
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
	 * ��ȡ�������
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
	 * ��ȡ���������
	 * @param root
	 * @return
	 */
    public int getTreeWidth(Node root) {
        if (root == null)
            return 0;

        Queue<Node> queue = new ArrayDeque<Node>();
        int maxWitdth = 1; // �����
        queue.add(root); // ���

        while (true) {
            int len = queue.size(); // ��ǰ��Ľڵ����
            if (len == 0)
                break;
            while (len > 0) {// �����ǰ�㣬���нڵ�
                Node t = queue.poll();
                len--;
                if (t.left != null)
                    queue.add(t.left); // ��һ��ڵ����
                if (t.right != null)
                    queue.add(t.right);// ��һ��ڵ����
            }
            maxWitdth = Math.max(maxWitdth, queue.size());
        }
        return maxWitdth;
    }
	
	/**
     * ������ȱ���
     * ���÷ǵݹ�ʵ��
     * ��Ҫ�������ݽṹ������
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
     * ������ȱ������൱���ȸ�����
     * ���÷ǵݹ�ʵ��
     * ��Ҫ�������ݽṹ��ջ
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
		System.out.println("����");
		tree.preOrder(root);
		System.out.println("\n����");
		tree.midOrder(root);
		System.out.println("\n������");
		tree.posOrder(root);
		System.out.println("\n������ȣ�" + tree.getTreeDeep(root));
		System.out.println("\n���Ŀ�ȣ�" + tree.getTreeWidth(root));
		System.out.println("\n�ڵ㣺" + tree.levelOrderTraversal(root,2).data);

		tree.depthOrderTraversal(root);
	}

}
