package interpreter.stm;

import interpreter.exp.Exp;

/**
 * ��ֵ���
 * @author Administrator
 *
 */
public class AssignStm extends Stm {
	public String id;
	public Exp exp;
	public AssignStm(String id, Exp exp){
		this.id = id;
		this.exp = exp;
	}
}
