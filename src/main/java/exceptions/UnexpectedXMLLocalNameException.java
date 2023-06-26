package exceptions;

public class UnexpectedXMLLocalNameException extends Exception {
    public UnexpectedXMLLocalNameException() {
        super("Unexpected XML local name. Local name is name of java class into info package.");
    }
}
