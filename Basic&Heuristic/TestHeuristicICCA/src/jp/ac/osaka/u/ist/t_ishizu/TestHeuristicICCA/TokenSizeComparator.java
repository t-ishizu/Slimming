package jp.ac.osaka.u.ist.t_ishizu.TestHeuristicICCA;

import java.util.Comparator;

public class TokenSizeComparator implements Comparator<CloneSet>{
	/*~‡‚É•À‚×‚é*/
	public int compare(CloneSet cs1,CloneSet cs2){
		int totalToken1 = cs1.getReduc();
		int totalToken2 = cs2.getReduc();
		
		if(totalToken1>totalToken2){
			return -1;
		}else if(totalToken1==totalToken2){
			return 0;
		}else{
			return 1;
		}
	}
}
