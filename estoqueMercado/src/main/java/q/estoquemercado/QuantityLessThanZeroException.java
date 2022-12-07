
package q.estoquemercado;

public class QuantityLessThanZeroException extends Exception{
    
    public QuantityLessThanZeroException(){}
    
    public QuantityLessThanZeroException(String mensagem){
        super(mensagem);
    }
    
    public QuantityLessThanZeroException(Throwable causa){
        super(causa);
    }
}
