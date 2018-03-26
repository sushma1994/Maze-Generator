package com.projectmaze.com;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class MazeGeneration {

	public static void main(String[] args) {
		
		int r,c;
		Scanner s = new Scanner(System.in);
		//taking input from user for rows and column
		System.out.println("Enter the number of rows you would like in the maze");
		r = s.nextInt();
		System.out.println("Enter the number of columns you would like in the maze");
		c = s.nextInt();
		Converge[][] node = new Converge[r][c];int k=0;
		for(int i = 0;i<r;i++) {
			for(int j=0;j<c;j++) {
		node[i][j] = new Converge(k++,true,true);
			}
		}
		int count=0;
		int NumElements = r*c;
		DisjSets ds = new DisjSets( NumElements );
		node[0][0].setlWall(false);
		node[r-1][c-1].setbWall(false);
		Random rand = new Random(); 
		List<Wall> li = new ArrayList<Wall>();
		//making ist of walls which has cells below or next so that later breaking them becomes easier
		for(int j=0;j<r;j++) {
			for(int m=0;m<c;m++) {
				if(m<=c-2) {
					li.add(new Wall(node[j][m].data,node[j][m+1].data));
				}
				if(j<=r-2) {
					li.add(new Wall(node[j][m].data,node[j+1][m].data));
				}
			}
		}
		int size = li.size();
		while(!check(ds, NumElements)) {
			//using random generation here
			int wallsPair = rand.nextInt(li.size());				
			int iIndex = (li.get(wallsPair).getLeftcell())/c;			//row Index 
			int jIndex = li.get(wallsPair).getLeftcell()-iIndex*c;		//column Index 
			int inextIndex = li.get(wallsPair).getRightcell()/c;			//row Index of next cell or bottom cell
			int jnextIndex = li.get(wallsPair).getRightcell()- inextIndex*c;	//column Index of nxt or bottom cell
			int x = ds.find(li.get(wallsPair).getLeftcell());		//root for merge
			int y = ds.find(li.get(wallsPair).getRightcell());		//root for merge
			if(x!=y) {
				//using disjoint set union here
				ds.union(x, y);
				count++;
				li.remove(wallsPair);
				if(inextIndex==iIndex+1 && jnextIndex == jIndex) {
					node[iIndex][jIndex].setbWall(false);
				}
				if(inextIndex == iIndex && jnextIndex == jIndex+1) {
					node[inextIndex][jnextIndex].setlWall(false);
				}
			}
		}
		//drawing the maze
		for(int x=0;x<c;x++) {
			System.out.print(" _");
		}
		System.out.println();
		for(int j=0;j<r;j++) {
			for(int m=0;m<c;m++) {
				if(node[j][m].leftWall) {
					System.out.print("|");
				}else {
					System.out.print(" ");
				}
				if(node[j][m].bottomWall) {
					System.out.print("_");
				}else {
					System.out.print(" ");
				}
			}
			System.out.print("|");
			System.out.println();
		}
	}
	//used to keep a track of where to end
	private static boolean check(DisjSets ds,int numElements) {
		for(int i=1; i<numElements; i++){
			if(ds.find(0) != ds.find(i)){
				return false;
			}
		}
		return true;
	}
	}


