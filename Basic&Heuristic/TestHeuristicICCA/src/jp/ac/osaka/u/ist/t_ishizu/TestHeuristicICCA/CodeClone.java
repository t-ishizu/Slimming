package jp.ac.osaka.u.ist.t_ishizu.TestHeuristicICCA;

import java.util.ArrayList;

public class CodeClone {
	private int fileId;
	private int LS; //L Line S Start
	private int LE; //       E End
	private int CS; //C Column
	private int CE;
	private int TS; //T Token
	private int TE;
	private CloneSet parent;
	private int cloneSetId=-1;
	private ArrayList<CodeClone> neighbors = new ArrayList<CodeClone>();
	private boolean painted = false;
	private boolean packed = false;
	private int LNR;
	public CodeClone(){
		
	}
	public CodeClone setFileId(int id){
		fileId = id;
		return this;
	}
	
	public int getFileId(){
		return fileId;
	}
	
	public CodeClone setLine(int ls,int le){
		LS = ls;
		LE = le;
		return this;
	}
	public int getLS(){
		return LS;
	}
	public int getLE(){
		return LE;
	}
	public CodeClone setColumn(int cs,int ce){
		CS = cs;
		CE = ce;
		return this;
	}
	public int getCS(){
		return CS;
	}
	public int getCE(){
		return CE;
	}
	public CodeClone setToken(int ts,int te){
		TS = ts;
		TE = te;
		return this;
	}
	public int getTS(){
		return TS;
	}
	public int getTE(){
		return TE;
	}
	public CodeClone setParent(CloneSet cs){
		parent = cs;
		return this;
	}
	public CloneSet getParent(){
		return parent;
	}
	
	public CodeClone setCloneSetId(int id){
		cloneSetId = id;
		return this;
	}
	
	public int getCloneSetId(){
		return cloneSetId;
	}
	public CodeClone setNeighbors(CodeClone c){
		boolean find = false;
		for(CodeClone nc:neighbors){
			if(nc.getFileId()==c.getFileId() && nc.getTS()==c.getTS() && nc.getTE()==c.getTE()){
				find = true;
			}
		}
		if(!find){
			neighbors.add(c);
		}
		return this;
	}
	public ArrayList<CodeClone> getNeighbors(){
		return neighbors;
	}
	
	public void getPainted(){
		painted = true;
	}
	
	public void getPacked(){
		packed = true;
	}
	
	public boolean isPainted(){
		return painted;
	}
	
	public boolean isPacked(){
		return packed;
	}
	
	public CodeClone setLNR(int lnr){
		this.LNR = lnr;
		return this;
	}
	
	public int getLNR(){
		return LNR;
	}
}
