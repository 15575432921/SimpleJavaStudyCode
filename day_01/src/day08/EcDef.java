package day08;

public class EcDef extends Exception {
    static final long serialVersionUID=123L;
    public EcDef(){}
    public EcDef(String msg){
        super(msg);
    }
}
