package jp.ac.osaka.u.ist.t_ishizu.TestHeuristicICCA;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import org.moeaframework.core.Problem;
import org.moeaframework.core.Solution;
import org.moeaframework.core.variable.EncodingUtils;
import org.moeaframework.util.Vector;

public class GeneticAlgorithm implements Problem{
	private int iterateIndex;
	private int nsacks = 1;
	private int nitems;
	private int[][] profit;
	//private int[][] weight;
	
	
	public GeneticAlgorithm(File file)throws IOException{
		this(new FileReader(file));
	}
	
	public GeneticAlgorithm(InputStream inputStream)throws IOException{
		this(new InputStreamReader(inputStream));
	}
	
	public GeneticAlgorithm(Reader reader) throws IOException{
		super();
		
		load(reader);
	}
	
	private void load(Reader reader) throws IOException{
		//System.out.println("index " +CloneRefactoring.iterateIndex);
		this.iterateIndex = TestHeuristicICCA.iterateIndex;
		nitems = TestHeuristicICCA.overlapSetMap.get(iterateIndex).setList.size();
		TestHeuristicICCA.overlapSetMap.get(iterateIndex).indexReset();
	}
	
	@Override
	public void evaluate(Solution solution) {
		boolean[] d = EncodingUtils.getBinary(solution.getVariable(0));
		double[] f = new double[nsacks];
		//int[] check = new int[nitems];
		OverlapSet CloneSetList = TestHeuristicICCA.overlapSetMap.get(iterateIndex);
		for(int i=0;i<nitems;i++){
			if(d[i]){
				CloneSet cs = CloneSetList.setList.get(i);
				for(int j=0;j<i;j++){
					if(d[j]){
						int cs2_index = CloneSetList.setList.get(j).getCloneSetId();
						if(cs.contains(CloneSetList.setList.get(j))){
							d[i]=false;
							break;
						}
					}
				}
				if(d[i])
					f[0]+=cs.getReduc();
			}
		}
		
		for(int i=0;i<nitems;i++){
			if(!d[i]){
				boolean find = false;
				for(int j=0;j<CloneSetList.setList.get(i).getNeighborCloneSet().size();j++){
					if(d[CloneSetList.setList.get(i).getNeighborCloneSet().get(j).osIndex]){
						find = true;
						break;
					}
				}
				if(!find){
					d[i] = true;
					f[0]+=CloneSetList.setList.get(i).getReduc();
				}	
			}
		}
		
		if(f[0]>CloneSetList.bestEval){
			CloneSetList.bestEval=(int) f[0];
			for(int i=0;i<nitems;i++){
				if(d[i]){
					CloneSetList.setList.get(i).allPacked();
				}else{
					CloneSetList.setList.get(i).open();
				}
			}
		}
			
	}
	
	@Override
	public String getName() {
		return "GeneticAlgorithm";
	}

	@Override
	public int getNumberOfVariables() {
		return 1;
	}

	@Override
	public int getNumberOfObjectives() {
		return nsacks;
	}

	@Override
	public int getNumberOfConstraints() {
		return 0;
	}

	

	@Override
	public Solution newSolution() {
		Solution solution = new Solution(1,nsacks,0);
		solution.setVariable(0,EncodingUtils.newBinary(nitems));
		return solution;
	}

	@Override
	public void close() {
		// do nothing
		
	}

}
