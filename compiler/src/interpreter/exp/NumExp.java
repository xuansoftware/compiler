package interpreter.exp;

/**
 * 常量表达式
 * @author Administrator
 *
 */
public class NumExp extends Exp {
	public int num;
	public NumExp(int num){
		this.num = num;
	}
}
