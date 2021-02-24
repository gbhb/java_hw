package ce1002.a2.s107502558;

public abstract class Exp {
    public abstract boolean eval();
    public class Lit extends Exp {
        private boolean val;
        public Lit(boolean val) {
            this.val = val;
        }
        
        public boolean eval() {
            return this.val;
        }
    }
    
    public class Or extends Exp {
    	private Exp e1, e2;
    	public Or(Exp a1, Exp a2) {
    	e1 = a1; e2 = a2;
    	}
    	public boolean eval() {
    	return e1.eval() | e2.eval();
    	}
    }
    public class And extends Exp {
    	private Exp e1, e2;
    	public And(Exp a1, Exp a2) {
    	e1 = a1; e2 = a2;
    	}
    	public boolean eval() {
    	return e1.eval() & e2.eval();
    	}
    }
}
