package ru.madzi.o2.lexer;

import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerInput;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 * @author deliseev
 */
class O2Lexer implements Lexer<O2TokenId> {

    public static final char EOF = (char) -1;

    private LexerRestartInfo<O2TokenId> info;

    private long intVal;

    private double realVal;

    private String strVal;

    public O2Lexer(LexerRestartInfo<O2TokenId> info) {
        this.info = info;
    }

    @Override
    public Token<O2TokenId> nextToken() {
        O2Token token = getToken();
        if (token != O2Token.EOF) {
            O2TokenId tokenId = O2LanguageHierarchy.getToken(token.getId());
            return info.tokenFactory().createToken(tokenId);
        }
        return null;
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
    }

    private char getChar() {
        int sym = info.input().read();
        return sym == LexerInput.EOF ? EOF : (char) sym;
    }

    private void undoChar() {
        info.input().backup(1);
    }

    private O2Token getToken() {
        char ch = getChar();
        if (ch == EOF) {
            return O2Token.EOF;
        } else if (Character.isWhitespace(ch)) {
            return O2Token.WHITESPACE;
        } else if (Character.isDigit(ch)) {
            undoChar();
            return number();
        } else if (Character.isJavaIdentifierStart(ch)) {
            undoChar();
            return identifier();
        } else {
            switch (ch) {
                case '\'':
                case '"':
                    return string(ch);

                case '#':
                    return O2Token.NEQ;

                case '&':
                    return O2Token.AND;

                case '(':
                    ch = getChar();
                    if (ch == '*') {
                        return comment();
                    }
                    undoChar();
                    return O2Token.LPAREN;

                case ')':
                    return O2Token.RPAREN;

                case '*':
                    return O2Token.TIMES;

                case '+':
                    return O2Token.PLUS;

                case ',':
                    return O2Token.COMMA;

                case '-':
                    return O2Token.MINUS;

                case '.':
                    ch = getChar();
                    if (ch == '.') {
                        return O2Token.UPTO;
                    }
                    undoChar();
                    return O2Token.LPAREN;

                case '/':
                    return O2Token.SLASH;

                case ':':
                    ch = getChar();
                    if (ch == '=') {
                        return O2Token.BECOMES;
                    }
                    undoChar();
                    return O2Token.COLON;

                case ';':
                    return O2Token.SEMICOLON;

                case '<':
                    ch = getChar();
                    if (ch == '=') {
                        return O2Token.LEQ;
                    }
                    undoChar();
                    return O2Token.LSS;

                case '=':
                    return O2Token.EQL;

                case '>':
                    ch = getChar();
                    if (ch == '=') {
                        return O2Token.GEQ;
                    }
                    undoChar();
                    return O2Token.GTR;

                case '[':
                    return O2Token.LBRAK;

                case ']':
                    return O2Token.RBRAK;

                case '^':
                    return O2Token.ARROW;

                case '{':
                    return O2Token.LBRACE;

                case '|':
                    return O2Token.BAR;

                case '}':
                    return O2Token.RBRACE;

                case '~':
                    return O2Token.NOT;

                default: return O2Token.ERROR;
            }
        }
    }

    private static double ten(int e) {
        double x = 1;
        double p = 10;
        while (e > 0) {
            if (e % 2 == 1) { // ODD(e)
                x *= p;
            }
            e = e / 2;
            if (e > 0) {
                p *= p;
            }
        }
        return x;
    }

    /**
     * Convert char into number.
     * 
     * @param ch the char
     * @param hex flag, if <b>true</b>that used hex digits
     * @return the number
     */
    private int ord(char ch, boolean hex) {
        switch (ch) {
            case '0':
                return 0;

            case '1':
                return 1;

            case '2':
                return 2;

            case '3':
                return 3;

            case '4':
                return 4;

            case '5':
                return 5;

            case '6':
                return 6;

            case '7':
                return 7;

            case '8':
                return 8;

            case '9':
                return 9;

            case 'A':
                return hex ? 10 : -1;

            case 'B':
                return hex ? 11 : -1;

            case 'C':
                return hex ? 12 : -1;

            case 'D':
                return hex ? 13 : -1;

            case 'E':
                return hex ? 14 : -1;

            case 'F':
                return hex ? 15 : -1;
        }
        return -1;
    }

    private int parseInt(String str, char end) {
        return 0;
        //TODO: Write parse int;
    }

    private O2Token number() {
        boolean wasdot = false;
        boolean real = false;
        char prev = EOF;
        char ch = getChar();
        StringBuilder sb = new StringBuilder();
        while (ch != EOF && isNumberChar(ch)) {
            if (ch == 'H') {
                intVal = parseInt(sb.toString(), ch);
                return real ? O2Token.ERROR : O2Token.NUMBER;
            } else if (ch == 'X') {
                intVal = parseInt(sb.toString(), ch);
                return real ? O2Token.ERROR : O2Token.NUMBER;
            } else if (ch == '.') {
                if (ch == prev) { // 123..321
                    undoChar();
                    undoChar();
                    intVal = parseInt(sb.toString(), 'D');
                    return real ? O2Token.ERROR : O2Token.NUMBER;
                } else if (wasdot) {
                    return O2Token.ERROR;
                } else {
                    wasdot = true;
                }
            } else if (ch == '-') {
                if (prev != EOF && prev != 'E') {
                    undoChar();
                    return O2Token.NUMBER;
                }
            } else if (ch == '+') {
                if (prev != EOF && prev != 'E') {
                    undoChar();
                    return O2Token.NUMBER;
                }
            }
            prev = ch;
            sb.append(ch);
            ch = getChar();
        }
        undoChar();
        return O2Token.NUMBER;
    }

    private O2Token identifier() {
        char ch = getChar();
        StringBuilder testWord = new StringBuilder();
        while (ch != EOF && Character.isJavaIdentifierPart(ch)) {
            testWord.append(ch);
            ch = getChar();
        }
        undoChar();
        String test = testWord.toString();
        for (O2Token token : O2Token.values()) {
            if (test.equals(token.getName())) {
                return token;
            }
        }
        return O2Token.IDENTIFIER;
    }

    private O2Token string(char end) {
        char ch = getChar();
        StringBuilder str = new StringBuilder();
        while (ch != EOF && ch != end) {
            str.append(ch);
            ch = getChar();
        }
        strVal = str.toString();
        if (ch == EOF) {
            undoChar();
            return O2Token.ERROR;
        }
        return O2Token.STRING;
    }

    private O2Token comment() {
        int level = 1;
        CommentState state = CommentState.STAR;
        char ch = getChar();
        while (ch != EOF && level > 0) {
            if (ch == '(') {
                state = CommentState.LPAREN;
            } else if (ch == '*') {
                if (state == CommentState.LPAREN) {
                    level++;
                }
                state = CommentState.STAR;
            } else if (ch == ')') {
                if (state == CommentState.STAR) {
                    level--;
                }
                state = CommentState.RPAREN;
            } else {
                state = CommentState.TEXT;
            }
            ch = getChar();
        }
        if (ch == EOF) {
            undoChar();
            return O2Token.ERROR;
        }
        return O2Token.COMMENT;
    }

    private static boolean isNumberChar(char ch) {
        switch (ch) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'H':
            case 'X':
            case '.':
            case '-':
            case '+':
                return true;
        }
        return false;
    }

    private enum CommentState {
        TEXT,
        LPAREN,
        STAR,
        RPAREN
    }

}
