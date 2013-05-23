package interpreter;

public class OpExp extends Exp {
	public Exp leftExp;
	public Exp rightExp;
	public int oper;
	
	public OpExp(Exp leftExp, int oper, Exp rightExp) {
		this.leftExp = leftExp;
		this.oper = oper;
		this.rightExp = rightExp;
	}
}
