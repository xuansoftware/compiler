package interpreter.exp;

import interpreter.stm.Stm;

public class EseqExp extends Exp {
	public Stm stm;
	public Exp exp;
	
	public EseqExp(Stm stm, Exp exp){
		this.stm = stm;
		this.exp = exp;
	}
}
