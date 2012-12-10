package ru.madzi.o2.lexer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author deliseev
 */
public enum O2Token {

    EOF("EOF", O2Category.WHITESPACE, 0),
    ERROR("ERROR", O2Category.ERROR, 1),
    WHITESPACE("WHITESPACE", O2Category.WHITESPACE, 2),
    STRING("STRING", O2Category.STRING, 3),
    IDENTIFIER("IDENTIFIER", O2Category.IDENTIFIER, 4),
    NUMBER("NUMBER", O2Category.NUMBER, 5),
    COMMENT("COMMENT", O2Category.COMMENT, 6),
    ARRAY("ARRAY", O2Category.KEYWORD, 7);

    private int id;
    private String name;
    private O2Category category;

    O2Token(String name, O2Category category, int id) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public O2Category getCategory() {
        return category;
    }

    public static List<O2Token> getTokens(O2Category category) {
        List<O2Token> tokens = new ArrayList<O2Token>();
        for (O2Token token : O2Token.values()) {
            if (token.category == category) {
                tokens.add(token);
            }
        }
        return tokens;
    }

}
