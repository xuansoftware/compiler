package interpreter;

import interpreter.exp.EseqExp;
import interpreter.exp.IdExp;
import interpreter.exp.NumExp;
import interpreter.exp.OpExp;
import interpreter.explist.LastExpList;
import interpreter.explist.PairExpList;
import interpreter.stm.AssignStm;
import interpreter.stm.CompoundStm;
import interpreter.stm.PrintStm;
import interpreter.stm.Stm;

/**
 * 测试类，用于测试直线解释器
 * @author Administrator
 *
 */
public class TestInterpreter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AssignStm stm1 = new AssignStm("a", new OpExp(new NumExp(5),
				OpExp.PLUS, new NumExp(3)));
		CompoundStm stm2 = new CompoundStm(new AssignStm("b",
				new EseqExp(new PrintStm(new PairExpList(new IdExp("a"),
						new LastExpList(new OpExp(new IdExp("a"), OpExp.MINUS,
								new NumExp(1))))), new OpExp(new NumExp(10),
						OpExp.TIMES, new IdExp("a")))), new PrintStm(
				new LastExpList(new IdExp("b"))));
		Stm prog = new CompoundStm(stm1, stm2);
		
		Interpreter interpreter = new Interpreter();
		interpreter.interpStm(prog,null);
	}
}
