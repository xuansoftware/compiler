package interpreter.table;
/**
 * ���ڽ������ı���
 * @author Administrator
 *
 */
public class Table {
	public String id;
	public int value;
	public Table tail;

	public Table(String id, int value){
		this.id = id;
		this.value = value;
	}
	
	public Table(String id, int value, Table tail){
		this.id = id;
		this.value = value;
		this.tail = tail;
	}
}
