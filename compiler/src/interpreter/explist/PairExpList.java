package interpreter.explist;

import interpreter.exp.Exp;
/**
 * ������ʽ����
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
