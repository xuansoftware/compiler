package interpreter;

public class PrintStm extends Stm {
	public ExpList exps;
	public PrintStm(ExpList exps) {
		this.exps = exps;
	}
}
