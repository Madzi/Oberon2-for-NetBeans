package ru.madzi.o2.lexer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
 * @author deliseev
 */
public class O2LanguageHierarchy extends LanguageHierarchy<O2TokenId> {

    private static final Map<Integer, O2TokenId> idToToken = new HashMap<Integer, O2TokenId>();

    private static void init() {
        for (O2Token token : O2Token.values()) {
            idToToken.put(token.getId(), new O2TokenId(token));
        }
    }

    public static O2TokenId getToken(int id) {
        if (idToToken.isEmpty()) {
            init();
        }
        return idToToken.get(id);
    }

    @Override
    protected Collection<O2TokenId> createTokenIds() {
        if (idToToken.isEmpty()) {
            init();
        }
        return idToToken.values();
    }

    @Override
    protected Lexer<O2TokenId> createLexer(LexerRestartInfo<O2TokenId> info) {
        return new O2WarpLexer(info);
    }

    @Override
    protected String mimeType() {
        return "text/x-oberon-2";
    }

}
