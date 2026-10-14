import Token;

public class Scanner {
    // pseudocode for Scanner function
    // function Scanner() returns Token {
    //     while(s.peek() = blank) {
    //         s.advance()
    //     }
    //     if s.EOF(){
    //         any.type <- $
    //     } else {
    //         if (s.peek() is an element of {0, 1, ..., 9}) {
    //             ans <- ScanDigits()
    //         } else {
    //             ch <- s.advance()
    //             switch(ch) {
    //                 case({a, b, ..., z} - {i, f, p}) {
    //                     ans.type <- id
    //                     ans.val <- ch
    //                 }
    //                 case(f) {
    //                     ans.type <- floatdcl
    //                 }
    //                 case(i) {
    //                     ans.type <- intdcl
    //                 }
    //                 case(p) {
    //                     ans.type <- print
    //                 }
    //                 case(=) {
    //                     ans.type <- assign
    //                 }
    //                 case(+) {
    //                     ans.type <- plus
    //                 }
    //                 case(-) {
    //                     ans.type <- minus
    //                 }
    //                 case(default) {
    //                     LexicalError()
    //                 }
    //             }
    //         }
    //     return(ans)
    //     }
    // end
    // }

    public static Token scanner(String stream) {
        stream
    }

    private static class InputStream {
        private final String input;
        private int position;

        InputStream(String input) {
            this.input = input;
        }

        int peek() {
            return pos < input.length() ? input.charAt(pos) : -1;
        }

        int advance() {
            int ch = peek();
            if (ch != -1) pos++;
            return ch;
        }
    }
}
