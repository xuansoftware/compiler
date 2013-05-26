package interpreter.exp;

public class OpExp extends Exp {
	public Exp leftExp;
	public Exp rightExp;
	public int oper;
	public static final int PLUS = 0;
	public static final int MINUS = 1;
	public static final int TIMES = 2;
	public static final int DIV = 3;
	
	public OpExp(Exp leftExp, int oper, Exp rightExp) {
		this.leftExp = leftExp;
		this.oper = oper;
		this.rightExp = rightExp;
	}
}
