package interpreter.exp;
/**
 * 变量表达式
 * @author Administrator
 *
 */
public class IdExp extends Exp{
	public String id;
	public IdExp(String id){
		this.id = id;
	}
}
