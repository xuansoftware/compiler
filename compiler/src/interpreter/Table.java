package interpreter;
/**
 * ���ڽ������ı���
 * @author Administrator
 *
 */
public class Table {
	String id;
	int value;
	Table tail;
	public Table(String id, int value, Table tail){
		this.id = id;
		this.value = value;
		this.tail = tail;
	}
}
