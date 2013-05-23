package interpreter;

public class OpExp extends Exp {
	public Exp leftExp;
	public Exp rightExp;
	public int oper;
	public static final int Plus = 0;
	public static final int Minus = 1;
	public static final int Times = 2;
	
	public OpExp(Exp leftExp, int oper, Exp rightExp) {
		this.leftExp = leftExp;
		this.oper = oper;
		this.rightExp = rightExp;
	}
}
