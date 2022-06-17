
public class MyException extends Exception{
    public MyException(String s)
    {
        super(s);
    }
    public MyException()
    {
        super("Cette page n'existe pas\n");
    }
}
