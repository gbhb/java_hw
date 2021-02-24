package pld;

import pld.Visitor.Interpreter;
import pld.Visitor.Printer;

public class hw2_2 {
	public static void main(String[] args) {
		Interpreter intp = new Interpreter();
		Printer prt = new Printer();
		System.out.println((Boolean) (new And(new Lit(true), new Lit(false))).accept(intp));
		System.out.println((Boolean) (new And(new Lit(true), new Lit(true))).accept(intp));
		System.out.println((Boolean) (new Or(new Lit(true), new Lit(false))).accept(intp));
		System.out.println((Boolean) (new Or(new Lit(false), new Lit(false))).accept(intp));
		System.out.println((Boolean) (new Lit(true)).accept(intp));
		System.out.println((new Lit(true)).accept(prt));
		System.out.println((new Lit(false)).accept(prt));
		System.out.println((new And(new Lit(true), new Lit(false))).accept(prt));
		System.out.println((new Or(new Lit(true), new Lit(false))).accept(prt));
		System.out.println((new Or(new Lit(true), new And(new Lit(true), new Lit(false)))).accept(prt));


	}
}

abstract class Exp {
	public abstract Object accept(Visitor v);
}

class Lit extends Exp {
	public boolean val;

	public Lit(boolean val) {
		this.val = val;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
}
class And extends Exp {
	public Exp e1, e2;
	public And(Exp a1, Exp a2) {
		e1 = a1;
		e2 = a2;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	

}
class Or extends Exp {
	public Exp e1, e2;
	public Or(Exp a1, Exp a2) {
		e1 = a1;
		e2 = a2;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
}
class Not extends Exp {
	public Exp e1;
	public Not(Exp a1) {
		e1 = a1;
	}
	public Object accept(Visitor v) {
		return v.visit(this);
	}
	
}
interface Visitor {
	public Object visit(Lit e);
	public Object visit(And n);
	public Object visit(Or n);
	public Object visit(Not n);
	class Interpreter implements Visitor {
		public Object visit(Lit n) {
		    return n.val;
		}
		public Object visit(And n) {
			return (Boolean)n.e1.accept(this) & (Boolean)n.e2.accept(this);
		}
		public Object visit(Or n) {
		  return (Boolean)n.e1.accept(this) | (Boolean)n.e2.accept(this);
		}
		public Object visit(Not n) {
			  return !(Boolean)n.e1.accept(this);
		}
	}
	class Printer implements Visitor {
		public Object visit(Lit n) {
			if(n.val== true)
				return "T";
			if(n.val== false)
				return "F";
			return null;		
		}
		public Object visit(And n) {
			return "[and "+n.e1.accept(this)+" "+n.e2.accept(this)+"]";
		}
		public Object visit(Or n) {
			return "[or "+n.e1.accept(this)+" "+n.e2.accept(this)+"]";
		}
		public Object visit(Not n) {
			  return "[not "+n.e1.accept(this)+"]";
		}
	}
}