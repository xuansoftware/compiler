package interpreter.explist;

import interpreter.exp.Exp;
/**
 * �������ʽ����
 * @author Administrator
 *
 */
public class LastExpList extends ExpList {
	public Exp headExp;
	public LastExpList(Exp head){
		this.headExp = head;
	}
}
