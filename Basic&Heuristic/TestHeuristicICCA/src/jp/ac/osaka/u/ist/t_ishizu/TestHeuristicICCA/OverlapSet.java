package jp.ac.osaka.u.ist.t_ishizu.TestHeuristicICCA;

import java.util.ArrayList;
import java.util.Collections;

public class OverlapSet {
	public int overlapSetID;
	public ArrayList<CloneSet> setList;
	
	public int[][] bestMatrix;
	public int[] bestVector;
	public int bestEval;
	public int osIndex = 0;
	public OverlapSet(int ID){
		overlapSetID = ID;
		setList = new ArrayList<CloneSet>();
	}
	
	public void getCloneSet(CloneSet cs){
		setList.add(cs);
		cs.overlapSetID=overlapSetID;
		cs.osIndex = osIndex;
		osIndex++;
	}
	
	public void indexReset(){
		Collections.sort(setList,new TokenSizeComparator());
		for(int i=0;i<setList.size();i++){
			setList.get(i).osIndex=i;
		}
	}
}
