package com.lafin.knowledge.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 그래프 클래스
 * 그래프는 2차원 배열, 링크드리스트로 구현이 가능하며 해당 클래스는 링크드 리스트로 구현 
 * @author lafin
 */
public class Graph {

    // 그래프의 노드(정점) 클래스 구현
    class Node{
        int data;                   // 노드에 들어갈 데이터
        LinkedList<Node> adjacent;  // 인접 리스트
        boolean marked;             // 방문했는지 여부

        Node(int data){
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }

    // 그래프를 구성할 노드의 배열
    Node[] nodes;

    // 그래프 생성자에서 노드 생성
    public Graph(int size){
        nodes = new Node[size];

        // 사이즈만큼 노드를 생성한다 노드값은 편의상 인덱스와 동일하게 만듬
        for(int i=0; i<size; i++){
            nodes[i] = new Node(i);
        }        
    }

    // 간선 연결하는 메소드
    public void addEdge(int i1, int i2){

        Node n1 = nodes[i1];
        Node n2 = nodes[i2];


        if(n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }

        if(n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }

    public void dfs(){
        dfs(0);
    }

    public void dfs(int index){
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()){
            Node r = stack.pop();
            for(Node n : r.adjacent){
                if(n.marked == false){
                    n.marked = true;
                    stack.push(n);
                }
            }

            visit(r);
        }
    }

    public void bfs(){
        bfs(0);
    }    

    public void bfs(int index){
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<>();
    }

    public void visit(Node n){
        System.out.print(n.data + " ");
    }
}
