package ru.madzi.o2.lexer;

import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenId;

/**
 * @author deliseev
 */
public class O2TokenId implements TokenId {

    private static final Language<O2TokenId> LANGUAGE = new O2LanguageHierarchy().language();

    private O2Token token;

    public static Language<O2TokenId> getLanguage() {
        return LANGUAGE;
    }

    public O2TokenId(O2Token token) {
        assert(token != null);
        this.token = token;
    }

    @Override
    public String name() {
        return token.getName();
    }

    @Override
    public int ordinal() {
        return token.getId();
    }

    @Override
    public String primaryCategory() {
        return token.getCategory().getName();
    }

}
