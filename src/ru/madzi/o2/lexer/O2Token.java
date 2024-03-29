package ru.madzi.o2.lexer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author deliseev
 */
public enum O2Token {

    WHITESPACE("WHITESPACE", O2Category.WHITESPACE, 0),
    TIMES("*", O2Category.OPERATOR, 1),
    SLASH("/", O2Category.OPERATOR, 2),
    DIV("DIV", O2Category.OPERATOR, 3),
    MOD("MOD", O2Category.OPERATOR, 4),
    AND("&", O2Category.OPERATOR, 5),
    PLUS("+", O2Category.OPERATOR, 6),
    MINUS("-", O2Category.OPERATOR, 7),
    OR("OR", O2Category.OPERATOR, 8),
    EQL("=", O2Category.OPERATOR, 9),
    NEQ("#", O2Category.OPERATOR, 10),
    LSS("<", O2Category.OPERATOR, 11),
    LEQ("<=", O2Category.OPERATOR, 12),
    GTR(">", O2Category.OPERATOR, 13),
    GEQ(">=", O2Category.OPERATOR, 14),
    IN("IN", O2Category.OPERATOR, 15),
    IS("IS", O2Category.KEYWORD, 16),
    ARROW("^", O2Category.OPERATOR, 17),
    PERIOD(".", O2Category.SEPARATOR, 18),
    COMMA(",", O2Category.SEPARATOR, 19),
    COLON(":", O2Category.SEPARATOR, 20),
    UPTO("..", O2Category.OPERATOR, 21),
    RPAREN(")", O2Category.SEPARATOR, 22),
    RBRAK("]", O2Category.SEPARATOR, 23),
    RBRACE("}", O2Category.SEPARATOR, 24),
    OF("OF", O2Category.KEYWORD, 25),
    THEN("THEN", O2Category.KEYWORD, 26),
    DO("DO", O2Category.KEYWORD, 27),
    TO("TO", O2Category.KEYWORD, 28),
    BY("BY", O2Category.KEYWORD, 29),
    LPAREN("(", O2Category.SEPARATOR, 30),
    LBRAK("[", O2Category.SEPARATOR, 31),
    LBRACE("{", O2Category.SEPARATOR, 32),
    NOT("~", O2Category.OPERATOR, 33),
    BECOMES(":=", O2Category.OPERATOR, 34),
    NUMBER("NUMBER", O2Category.NUMBER, 35),
    NIL("NIL", O2Category.POINTER, 36),
    TRUE("TRUE", O2Category.TYPE, 37),
    FALSE("FALSE", O2Category.TYPE, 38),
    STRING("STRING", O2Category.STRING, 39),
    IDENTIFIER("IDENTIFIER", O2Category.IDENTIFIER, 40),
    SEMICOLON(";", O2Category.SEPARATOR, 41),
    BAR("|", O2Category.SEPARATOR, 42),
    END("END", O2Category.KEYWORD, 43),
    ELSE("ELSE", O2Category.KEYWORD, 44),
    ELSIF("ELSIF", O2Category.KEYWORD, 45),
    UNTIL("UNTIL", O2Category.KEYWORD, 46),
    IF("IF", O2Category.KEYWORD, 47),
    CASE("CASE", O2Category.KEYWORD, 48),
    WHILE("WHILE", O2Category.KEYWORD, 49),
    REPEAT("REPEAT", O2Category.KEYWORD, 50),
    FOR("FOR", O2Category.KEYWORD, 51),
    LOOP("LOOP", O2Category.KEYWORD, 52),
    WITH("WITH", O2Category.KEYWORD, 53),
    EXIT("EXIT", O2Category.KEYWORD, 54),
    RETURN("RETURN", O2Category.KEYWORD, 55),
    ARRAY("ARRAY", O2Category.KEYWORD, 56),
    OBJECT("OBJECT", O2Category.KEYWORD, 57),
    RECORD("RECORD", O2Category.KEYWORD, 58),
    POINTER("POINTER", O2Category.KEYWORD, 59),
    BEGIN("BEGIN", O2Category.KEYWORD, 60),
    CONST("CONST", O2Category.KEYWORD, 61),
    TYPE("TYPE", O2Category.KEYWORD, 62),
    VAR("VAR", O2Category.KEYWORD, 63),
    PROCEDURE("PROCEDURE", O2Category.KEYWORD, 64),
    IMPORT("IMPORT", O2Category.KEYWORD, 65),
    MODULE("MODULE", O2Category.KEYWORD, 66),
    CODE("CODE", O2Category.KEYWORD, 67),
    COMMENT("COMMENT", O2Category.COMMENT, 68),
    WARNING("WARNING", O2Category.WARNING, 69),
    ERROR("ERROR", O2Category.ERROR, 70),
    BOOLEAN("BOOLEAN", O2Category.TYPE, 71),
    CHAR("CHAR", O2Category.TYPE, 72),
    SHORTINT("SHORTINT", O2Category.TYPE, 73),
    INTEGER("INTEGER", O2Category.TYPE, 74),
    LONGINT("LONGINT", O2Category.TYPE, 75),
    SET("SET", O2Category.TYPE, 76),
    SYSTEM("SYSTEM", O2Category.SYSTEM, 80),
    EOF("EOF", O2Category.WHITESPACE, 100);

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
