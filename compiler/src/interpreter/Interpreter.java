package interpreter;

import interpreter.exp.EseqExp;
import interpreter.exp.Exp;
import interpreter.exp.IdExp;
import interpreter.exp.NumExp;
import interpreter.exp.OpExp;
import interpreter.explist.ExpList;
import interpreter.explist.LastExpList;
import interpreter.explist.PairExpList;
import interpreter.stm.AssignStm;
import interpreter.stm.CompoundStm;
import interpreter.stm.PrintStm;
import interpreter.stm.Stm;
import interpreter.table.IntAndTable;
import interpreter.table.Table;

public class Interpreter {
	public Table interpStm(Stm stm, Table table) {
		Table tmpTable;
		IntAndTable intAndTable;

		if (stm instanceof CompoundStm) {
			tmpTable = interpStm(((CompoundStm) stm).stm1, table);
			return interpStm(((CompoundStm) stm).stm2, tmpTable);
		} else if (stm instanceof AssignStm) {
			intAndTable = interpExp(((AssignStm) stm).exp, table);
			return update(((AssignStm) stm).id, intAndTable.value,
					intAndTable.table);
		} else if (stm instanceof PrintStm) {
			if (((PrintStm) stm).exps instanceof LastExpList) {
				intAndTable = interpAndPrintExp(
						((LastExpList) ((PrintStm) stm).exps).headExp, table);
				return intAndTable.table;
			} else if (((PrintStm) stm).exps instanceof PairExpList) {
				ExpList list = ((PrintStm) stm).exps;
				while (list instanceof PairExpList) {
					intAndTable = interpAndPrintExp(
							((PairExpList) list).headExp, table);
					table = intAndTable.table;
					list = ((PairExpList) list).tailExpList;
				}
				intAndTable = interpAndPrintExp(((LastExpList) list).headExp,
						table);
				return intAndTable.table;
			} else {
				System.out.println("Invalid print exps!");
			}
		} else {
			System.out.println("Statement type error!");
		}
		return null;
	}

	public IntAndTable interpExp(Exp exp, Table table) {
		int value = 0;
		IntAndTable intAndTableFir;
		IntAndTable intAndTableSec;
		Table tmpTable;

		if (exp instanceof IdExp) {
			value = lookUp(((IdExp) exp).id, table);
			return new IntAndTable(value, table);
		} else if (exp instanceof NumExp) {
			return new IntAndTable(((NumExp) exp).num, table);
		} else if (exp instanceof EseqExp) {
			tmpTable = interpStm(((EseqExp) exp).stm, table);
			return interpExp(((EseqExp) exp).exp, tmpTable);
		} else if (exp instanceof OpExp) {
			intAndTableFir = interpExp(((OpExp) exp).leftExp, table);
			intAndTableSec = interpExp(((OpExp) exp).rightExp,
					intAndTableFir.table);
			switch (((OpExp) exp).oper) {
			case OpExp.PLUS:
				value = intAndTableFir.value + intAndTableSec.value;
				break;
			case OpExp.MINUS:
				value = intAndTableFir.value - intAndTableSec.value;
				break;
			case OpExp.TIMES:
				value = intAndTableFir.value * intAndTableSec.value;
				break;
			case OpExp.DIV:
				value = intAndTableFir.value / intAndTableSec.value;
				break;
			default:
				System.out.println("Invalid operator!");
				break;
			}
			return new IntAndTable(value, intAndTableSec.table);
		} else {
			System.out.println("Invalid operation type!");
		}

		return null;
	}

	/*
	 * 根据ID寻找变量值
	 */
	private int lookUp(String key, Table table) {
		while (table != null) {
			if (key.equals(table.id)) {
				return table.value;
			}
			table = table.tail;
		}
		return 0;
	}

	/*
	 * 更新数据
	 */
	private Table update(String id, int value, Table table) {
		Table tmpTable = new Table(id, value, table);

		return tmpTable;
	}

	private IntAndTable interpAndPrintExp(Exp exp, Table table) {
		IntAndTable intAndTable = interpExp(exp, table);
		System.out.println(intAndTable.value);
		return intAndTable;
	}

}
