package com.leetcode.skiplist;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
public class SkipList implements Serializable {
	private static final long serialVersionUID = 1L;
	private final static int MAX_LEVEL_SIZE=32;
	private int levelSize=1;
	private Node head=new Node(MAX_LEVEL_SIZE);
	private final static double P=0.50;
	private Map<Integer,Integer> map=new HashMap<>();
	
	public void delete(int val){
		Node []prevs=new Node[levelSize];
		Node node=head;
		for(int i=levelSize-1;i>=0;i--){
			while(node.forwards[i]!=null&&node.forwards[i].value<val){
				node=node.forwards[i];
			}
			prevs[i]=node;
		}
		if(node.forwards[0]!=null&&node.forwards[0].value==val){
			for(int i=levelSize-1;i>=0;i--){
				if(prevs[i].forwards[i]!=null&&prevs[i].forwards[i].value==val)
					prevs[i].forwards[i]=prevs[i].forwards[i].forwards[i];
			}
			for(int i=levelSize-1;i>=0;i--){
				if(head.forwards[i]==null)
					levelSize--;
				else
					break;
			}
		}
	}
	public Node find(int val){
		Node node=head;
		int skip=0;
		for(int i=levelSize-1;i>=0;i--){
			while(node.forwards[i]!=null&&node.forwards[i].value<=val){
				node=node.forwards[i];
				skip++;
			}
		    if(node.value==val){
				node.skips=skip;
		    	return node;
		    }
		}
		return null;
	}
	private int randomlevelSize(){
		int level=1;
		while((Math.random()>P)&&level<MAX_LEVEL_SIZE)
			level++;
		return level;
	}
	public void prinfMap(){
		for(Integer key:map.keySet()){
			System.out.println(key+":"+map.get(key));
		}
		
	}
	
	public void insert(int val){
		int level=randomlevelSize();
		if(map.containsKey(level)){
			Integer inc = map.get(level);
			map.put(level,inc+1);
		}else{
			map.put(level, 1);
		}
		Node newNode=new Node(val,level);
		Node node=head;
		Node []nodes=new Node[level];
		for(int i=level-1;i>=0;i--){
			while(node.forwards[i]!=null&&node.forwards[i].value<val){
				node=node.forwards[i];
			}
			nodes[i]=node;
		}
		for(int i=level-1;i>=0;i--){
			newNode.forwards[i]=nodes[i].forwards[i];
			nodes[i].forwards[i]=newNode;
		}
		if(level>levelSize)
			levelSize=level;
	}
   public class Node implements Serializable{
	    private static final long serialVersionUID = 119747636190306481L;
		private int value=-1;
		private int maxLevel=1;
		private Node []forwards;
		private int skips=0;
		public Node(int val,int level) {
			this(level);
			this.value=val;
		}

		public int getSkips(){
			return  skips;
		}

		public Node(int level) {
			if(level<maxLevel)
				throw new IndexOutOfBoundsException("level:"+level);
			this.maxLevel=level;
			forwards=new Node[maxLevel];
		}

	   @Override
	   public String toString() {
		   return "Node{" +
				   "value=" + value +
				   ", maxLevel=" + maxLevel +
				   ", skips=" + skips +
				   '}';
	   }
   }
   public void printAll(){
	   for(int i=levelSize-1;i>=0;i--){
		   Node node=head;
		   while(node.forwards[i]!=null){
			   System.out.print(node.value+" ");
			   node=node.forwards[i];
		   }
		   System.out.println();
	   }
   }
}
