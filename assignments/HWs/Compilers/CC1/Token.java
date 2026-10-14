public class Token {
    public TYPE type;
    public char value;

    public Token(TYPE type, char value) {
        this.type = type;
        this.value = value;
    }

    public void print() {
        System.out.println("Value: " + String.valueOf(this.value));
        switch(this.type) {
            case TYPE.IDENTIFIER:
                System.out.println("Type: Identifier");
                break;
            case TYPE.FLOAT:
                System.out.println("Type: Float");
                break;
            case TYPE.INT:
                System.out.println("Type: Int");
                break;
            case TYPE.PRINT:
                System.out.println("Type: Print");
                break;
            case TYPE.ASSIGN:
                System.out.println("Type: Plus");
                break;
            case TYPE.PLUS:
                System.out.println("Type: Plus");
                break;
            case TYPE.MINUS:
                System.out.println("Type: Minus");
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }

}

public static enum TYPE {
    IDENTIFIER,
    FLOAT,
    INT,
    PRINT,
    ASSIGN,
    PLUS,
    MINUS
}
