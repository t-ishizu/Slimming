package jp.ac.osaka.u.ist.t_ishizu.TestHeuristicICCA;

import java.util.ArrayList;

public class SourceCodeClone extends CodeClone{
	private ArrayList<Tokens> tokenList=new ArrayList<Tokens>();
	private int numberOfLine;
	public SourceCodeClone(){
		super();
	}
	
	public SourceCodeClone setTokensList(ArrayList<Tokens> tokenList){
		this.tokenList.addAll(tokenList);
		this.numberOfLine = calcLine();
		setToken(getFirstToken().tokenId, getLastToken().tokenId);
		return this;
	}
	
	public ArrayList<Tokens> getTokensList(){
		return tokenList;
	}
	public Tokens getFirstToken(){
		return tokenList.get(0);
	}
	
	public Tokens getLastToken(){
		return tokenList.get(tokenList.size()-1);
	}
	
	private int calcLine(){
		int currentLine = -1;
		int numberOfLine = 0;
		for(int i=0;i<tokenList.size();i++){
			if(currentLine!=tokenList.get(i).line){
				currentLine = tokenList.get(i).line;
				numberOfLine++;
			}
		}
		return numberOfLine;
	}
	
	public int getNumberOfLines(){
		return numberOfLine;
	}
}
