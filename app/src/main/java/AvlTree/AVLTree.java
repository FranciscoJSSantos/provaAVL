/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AvlTree;

/**
 *
 * @author Usuario
 */
public class AVLTree {
    
    public class Node {
    
        //Key = valor
        //left = filho esquerdo
        //right = filho direito
        //altura = altura do valor
        
        int key;
        Node left;
        Node right;
        int height;

        //
        public Node(int key){
            this.key = key;
            this.height = 1;
        }
    
    }
    
    private Node root;
    
    //inserir dados
    public void insert(int item){
        this.root = insert(this.root,item);
    }
    
    //inserir raiz relacionado com nó
    public Node insert(Node node, int key){
        if(node == null) {
            return new Node(key);
        }
        
        if(node.key > key){
            node.left = insert(node.left, key);
        }else if(node.key < key){
            node.right = insert(node.right, key);
        }else {
            throw new RuntimeException("chave duplicada");
        }
        return rebalance(node);
    }

    //pega o valor da altura
    public int height(Node node){
        return node == null ? 0 : node.height;
    }
    
    //faz um update com a altura atual
    public void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }
    
    //pega o valor do balanceamento
    public int getBalance(Node node){
        return(node == null) ? 0 : height(node.left) - height(node.right);
    }
    
    //rotacao simples a direita
    public Node rotateRight(Node node){
                
        Node pivo = node.left; 
        Node auxiliar = pivo.right;
        pivo.right = node;
        node.left = auxiliar;
        
        updateHeight(node);
        updateHeight(pivo);
        
        return pivo;
    }
    
    //rotacao a simples a esquerda
    public Node rotateLeft(Node node) {
        
        Node pivo = node.right;
        Node auxiliar = pivo.left;
        
        pivo.left = node;
        node.right = auxiliar;
        
        updateHeight(node);
        updateHeight(pivo);
        
        return pivo;  
    }
    
    //calcula o valor balanceamento
    public Node rebalance(Node node){
        updateHeight(node);
        
        int balance = getBalance(node);
        
        if(balance > 1) {
            if(height(node.left) >= 0 ){
                node = rotateRight(node);
            } else{ 
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }
        if(balance < -1){
            if(height(node.right) <= 0){
                node = rotateLeft(node);
            }else{
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        
        return node;
    }
    
    //printar a raiz com seus respectivos filhos
    private void show(Node node) {
        String valorKey = "";


        if (node == null) {
             return;
        }


        if (node.left != null) {
            valorKey += node.left.key;    
        } else {
            valorKey += " ";    
        }

        valorKey += " Left - " + node.key + " - Right ";

        if (node.right != null) {
            valorKey += node.right.key;  
        } else {
           valorKey += " ";
        }

        System.out.println(valorKey);

        show(node.left);
        show(node.right);
    }
    
    //printar o resultado
    public void show() {
	show(this.root);
    }   
}
