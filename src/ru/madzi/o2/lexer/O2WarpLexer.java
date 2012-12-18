package ru.madzi.o2.lexer;

import ru.madzi.o2.chars.O2LexerInputCharStream;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 * @author Dmitry Eliseev
 */
public class O2WarpLexer implements Lexer<O2TokenId> {

    private LexerRestartInfo<O2TokenId> info;

    private O2Lexer lexer;

    public O2WarpLexer(LexerRestartInfo<O2TokenId> info) {
        this.info = info;
        lexer = new O2Lexer(new O2LexerInputCharStream(info.input()));
    }

    public Token<O2TokenId> nextToken() {
        O2Token token = lexer.getToken();
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

}
