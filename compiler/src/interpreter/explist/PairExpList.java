package interpreter.explist;

import interpreter.exp.Exp;

public class PairExpList extends ExpList {
	public Exp headExp;
	public ExpList tailExpList;
	
	public PairExpList(Exp head, ExpList tail){
		headExp = head;
		tailExpList = tail;
	}
}
