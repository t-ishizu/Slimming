package jp.ac.osaka.u.ist.t_ishizu.TestHeuristicICCA;

import static jp.ac.osaka.u.ist.t_ishizu.TestHeuristicICCA.TokenKind.*;

import java.util.Arrays;
public class Tokens {
	public final String token;
	public final int tokenId;
	public final int line;
	public final int column;
	public final int kind;
	private Tokens nextToken; 
	private boolean clone=false;
	private int count=0;
	public Tokens(String token,int line,int column,int tokenId){
		this.token = token;
		this.line = line;
		this.column = column;
		this.kind = getTokenKind(token);
		this.tokenId = tokenId;
	}
	
	private int getTokenKind(String token){
		if(token.isEmpty()){
			return -1;
		}else if(Arrays.asList(reservedWords).contains(token)){
			return RESERVED;
		}else switch(token){
		case ";": return SEMICOLON;
		case ",": return COMMA;
		case "{": return L_BRACE;
		case "}": return R_BRACE;
		case "(": return L_PALEN;
		case ")": return R_PALEN;
		case "//":return COMMENT;
		case "/*":return L_STAR_COMMENT;
		case "*/":return R_STAR_COMMENT;
		default: return NON_RESERVED;
		}
	}
	
	public Tokens setNextToken(Tokens nt){
		this.nextToken = nt;
		return this;
	}
	
	public Tokens getNextToken(){
		return nextToken;
	}
	
	public Tokens setClone(){
		this.clone = true;
		count++;
		return this;
	}
	
	public boolean isClone(){
		return clone;
	}
	
	public boolean isComment(){
		if(this.kind==COMMENT){
			return true;
		}
		return false;
	}
	
	public boolean isLComment(){
		if(this.kind==L_STAR_COMMENT) return true;
		return false;
	}
	
	public boolean isRComment(){
		if(this.kind==R_STAR_COMMENT) return true;
		return false;
	}
	
	public int getCount(){
		return count;
	}
}
