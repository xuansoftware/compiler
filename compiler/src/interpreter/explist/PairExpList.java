package interpreter.explist;

import interpreter.exp.Exp;
/**
 * 分离表达式链表
 * @author Administrator
 *
 */
public class PairExpList extends ExpList {
	public Exp headExp;
	public ExpList tailExpList;
	
	public PairExpList(Exp head, ExpList tail){
		headExp = head;
		tailExpList = tail;
	}
}
