package interpreter.stm;

import interpreter.explist.ExpList;

/**
 * ¥Ú”°”Ôæ‰
 * @author Administrator
 *
 */
public class PrintStm extends Stm {
	public ExpList exps;
	public PrintStm(ExpList exps) {
		this.exps = exps;
	}
}
