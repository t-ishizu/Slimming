package jp.ac.osaka.u.ist.t_ishizu.TestHeuristicICCA;

import java.util.ArrayList;

public class CloneSet {
	private ArrayList<CodeClone> cloneList = new ArrayList<CodeClone>();
	private ArrayList<SourceCodeClone> sCloneList = new ArrayList<SourceCodeClone>();
	private boolean packed=false;
	private boolean painted = false;
	private int cloneSetId=-1;
	private ArrayList<CloneSet> neighborCloneSet = new ArrayList<CloneSet>();
	private int Reduc=0;
	private int RNR=-1;
	public int osIndex = -1;
	public int overlapSetID = -1;
	public ArrayList<CodeClone> getCloneList(){
		return cloneList;
	}
	public void setClone(CodeClone c){
		cloneList.add(c);
	}
	
	public void allPainted(){
		for(CodeClone c:cloneList){
			c.getPainted();
		}
	}
	
	public void allPacked(){
		for(CodeClone c:cloneList){
			c.getPacked();
		}
		packed = true;
	}
	
	public void open(){
		packed = false;
	}
	
	public void setPainted(){
		this.painted=true;
	}
	public boolean isPainted(){
		return painted;
	}
	public boolean isPacked(){
		return packed;
	}
	
	public CloneSet setCloneSetId(int id){
		cloneSetId = id;
		return this;
	}
	
	public int getCloneSetId(){
		return cloneSetId;
	}
	
	public ArrayList<SourceCodeClone> getSCloneList(){
		return sCloneList;
	}
	
	public SourceCodeClone setSourceCodeClone(SourceCodeClone scc){
		sCloneList.add(scc);
		return scc;
	}
	
	public ArrayList<CloneSet> getNeighborCloneSet(){
		return this.neighborCloneSet;
	}
	
	public boolean contains(CloneSet cs1){
		for(CloneSet cs2:neighborCloneSet){
			if(cs1.getCloneSetId()==cs2.getCloneSetId()){
				return true;
			}
		}
		return false;
	}
	
	public void calcReduc(){
		Reduc = 0;
		int sum = 0;
		for(SourceCodeClone scs:sCloneList){
			sum+=scs.getNumberOfLines();
		}
		int num = sCloneList.size();
		if(num>1){
			Reduc+=(num-1)*(sum/num)-num;
			
		}
	}
	
	public int getReduc(){
		return Reduc;
	}
	
	public int calcRNR(){
		int totalLNR=0;
		int tokenLength=0;
		for(CodeClone c:cloneList){
			totalLNR+=c.getLNR();
			tokenLength +=c.getTE()-c.getTS()+1;
		}
		//System.out.println("totalLNR:"+totalLNR);
		//System.out.println("tokenLength:"+tokenLength);
		//System.out.println(100*totalLNR/tokenLength);
		return 100*totalLNR/tokenLength;
	}
	
	public void setRNR(){
		this.RNR = calcRNR();
	}
	
	public int getRNR(){
		return RNR;
	}
}

