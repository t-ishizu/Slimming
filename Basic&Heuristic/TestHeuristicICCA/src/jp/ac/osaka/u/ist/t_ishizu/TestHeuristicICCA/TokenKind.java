package jp.ac.osaka.u.ist.t_ishizu.TestHeuristicICCA;

public class TokenKind {
	public static final int RESERVED = 0;
	public static final int NON_RESERVED = 1;
	public static final int COMMA = 2;
	public static final int SEMICOLON = 3;
	public static final int L_PALEN = 4;
	public static final int R_PALEN = 5;
	public static final int L_BRACE = 6;
	public static final int R_BRACE = 7;
	public static final int COMMENT = 8;
	public static final int L_STAR_COMMENT =  9;
	public static final int R_STAR_COMMENT = 10;
	
	public static final String[] reservedWords = new String[]{
		"void","char","short","int","long","float","double","auto","static",
		"const","signed","unsigned","extern","volatile","register","return",
		"goto","if","else","switch","case","default","break","for","while",
		"do","continue","typeof","struct","enum","union","sizeof",
	};
	
	private TokenKind(){}
}
