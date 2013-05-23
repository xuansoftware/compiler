package interpreter;

public class TestInterpreter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AssignStm stm1 = new AssignStm("a", new OpExp(new NumExp(5),
				OpExp.Plus, new NumExp(3)));
		CompoundStm stm2 = new CompoundStm(new AssignStm("b",
				new EseqExp(new PrintStm(new PairExpList(new IdExp("a"),
						new LastExpList(new OpExp(new IdExp("a"), OpExp.Minus,
								new NumExp(1))))), new OpExp(new NumExp(10),
						OpExp.Times, new IdExp("a")))), new PrintStm(
				new LastExpList(new IdExp("b"))));
		Stm prog = new CompoundStm(stm1, stm2);
	}
}
