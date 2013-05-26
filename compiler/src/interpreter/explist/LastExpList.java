package interpreter.explist;

import interpreter.exp.Exp;
/**
 * 后续表达式链表
 * @author Administrator
 *
 */
public class LastExpList extends ExpList {
	public Exp headExp;
	public LastExpList(Exp head){
		this.headExp = head;
	}
}
