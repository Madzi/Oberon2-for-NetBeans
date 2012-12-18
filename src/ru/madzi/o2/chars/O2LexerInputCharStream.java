package ru.madzi.o2.chars;

import org.netbeans.spi.lexer.LexerInput;

/**
 * @author Dmitry Eliseev
 */
public class O2LexerInputCharStream extends O2AbstractCharStream {

    private LexerInput input;

    public O2LexerInputCharStream(LexerInput input) {
        super();
        this.input = input;
    }

    @Override
    protected char read() {
        int ch = input.read();
        return (ch != LexerInput.EOF) ? (char) ch : EOF;
    }

    @Override
    protected void backup(int count) {
        input.backup(count);
    }

}
