/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.lexer;

import java.io.*;
import java.util.*;
import minipython.node.*;

public class Lexer
{
    protected Token token;
    protected State state = State.INITIAL;

    private PushbackReader in;
    private int line;
    private int pos;
    private boolean cr;
    private boolean eof;
    private final StringBuffer text = new StringBuffer();

    protected void filter() throws LexerException, IOException
    {
    }

    public Lexer(PushbackReader in)
    {
        this.in = in;

        if(gotoTable == null)
        {
            try
            {
                DataInputStream s = new DataInputStream(
                    new BufferedInputStream(
                    Lexer.class.getResourceAsStream("lexer.dat")));

                // read gotoTable
                int length = s.readInt();
                gotoTable = new int[length][][][];
                for(int i = 0; i < gotoTable.length; i++)
                {
                    length = s.readInt();
                    gotoTable[i] = new int[length][][];
                    for(int j = 0; j < gotoTable[i].length; j++)
                    {
                        length = s.readInt();
                        gotoTable[i][j] = new int[length][3];
                        for(int k = 0; k < gotoTable[i][j].length; k++)
                        {
                            for(int l = 0; l < 3; l++)
                            {
                                gotoTable[i][j][k][l] = s.readInt();
                            }
                        }
                    }
                }

                // read accept
                length = s.readInt();
                accept = new int[length][];
                for(int i = 0; i < accept.length; i++)
                {
                    length = s.readInt();
                    accept[i] = new int[length];
                    for(int j = 0; j < accept[i].length; j++)
                    {
                        accept[i][j] = s.readInt();
                    }
                }

                s.close();
            }
            catch(Exception e)
            {
                throw new RuntimeException("The file \"lexer.dat\" is either missing or corrupted.");
            }
        }
    }

    public Token peek() throws LexerException, IOException
    {
        while(token == null)
        {
            token = getToken();
            filter();
        }

        return token;
    }

    public Token next() throws LexerException, IOException
    {
        while(token == null)
        {
            token = getToken();
            filter();
        }

        Token result = token;
        token = null;
        return result;
    }

    protected Token getToken() throws IOException, LexerException
    {
        int dfa_state = 0;

        int start_pos = pos;
        int start_line = line;

        int accept_state = -1;
        int accept_token = -1;
        int accept_length = -1;
        int accept_pos = -1;
        int accept_line = -1;

        int[][][] gotoTable = this.gotoTable[state.id()];
        int[] accept = this.accept[state.id()];
        text.setLength(0);

        while(true)
        {
            int c = getChar();

            if(c != -1)
            {
                switch(c)
                {
                case 10:
                    if(cr)
                    {
                        cr = false;
                    }
                    else
                    {
                        line++;
                        pos = 0;
                    }
                    break;
                case 13:
                    line++;
                    pos = 0;
                    cr = true;
                    break;
                default:
                    pos++;
                    cr = false;
                    break;
                };

                text.append((char) c);

                do
                {
                    int oldState = (dfa_state < -1) ? (-2 -dfa_state) : dfa_state;

                    dfa_state = -1;

                    int[][] tmp1 =  gotoTable[oldState];
                    int low = 0;
                    int high = tmp1.length - 1;

                    while(low <= high)
                    {
                        int middle = (low + high) / 2;
                        int[] tmp2 = tmp1[middle];

                        if(c < tmp2[0])
                        {
                            high = middle - 1;
                        }
                        else if(c > tmp2[1])
                        {
                            low = middle + 1;
                        }
                        else
                        {
                            dfa_state = tmp2[2];
                            break;
                        }
                    }
                }while(dfa_state < -1);
            }
            else
            {
                dfa_state = -1;
            }

            if(dfa_state >= 0)
            {
                if(accept[dfa_state] != -1)
                {
                    accept_state = dfa_state;
                    accept_token = accept[dfa_state];
                    accept_length = text.length();
                    accept_pos = pos;
                    accept_line = line;
                }
            }
            else
            {
                if(accept_state != -1)
                {
                    switch(accept_token)
                    {
                    case 0:
                        {
                            Token token = new0(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 1:
                        {
                            Token token = new1(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 2:
                        {
                            Token token = new2(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 3:
                        {
                            Token token = new3(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 4:
                        {
                            Token token = new4(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 5:
                        {
                            Token token = new5(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 6:
                        {
                            Token token = new6(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 7:
                        {
                            Token token = new7(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 8:
                        {
                            Token token = new8(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 9:
                        {
                            Token token = new9(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 10:
                        {
                            Token token = new10(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 11:
                        {
                            Token token = new11(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 12:
                        {
                            Token token = new12(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 13:
                        {
                            Token token = new13(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 14:
                        {
                            Token token = new14(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 15:
                        {
                            Token token = new15(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 16:
                        {
                            Token token = new16(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 17:
                        {
                            Token token = new17(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 18:
                        {
                            Token token = new18(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 19:
                        {
                            Token token = new19(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 20:
                        {
                            Token token = new20(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 21:
                        {
                            Token token = new21(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 22:
                        {
                            Token token = new22(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 23:
                        {
                            Token token = new23(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 24:
                        {
                            Token token = new24(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 25:
                        {
                            Token token = new25(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 26:
                        {
                            Token token = new26(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 27:
                        {
                            Token token = new27(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 28:
                        {
                            Token token = new28(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 29:
                        {
                            Token token = new29(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 30:
                        {
                            Token token = new30(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 31:
                        {
                            Token token = new31(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 32:
                        {
                            Token token = new32(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 33:
                        {
                            Token token = new33(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 34:
                        {
                            Token token = new34(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 35:
                        {
                            Token token = new35(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 36:
                        {
                            Token token = new36(
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 37:
                        {
                            Token token = new37(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 38:
                        {
                            Token token = new38(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 39:
                        {
                            Token token = new39(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 40:
                        {
                            Token token = new40(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 41:
                        {
                            Token token = new41(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    case 42:
                        {
                            Token token = new42(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            pos = accept_pos;
                            line = accept_line;
                            return token;
                        }
                    }
                }
                else
                {
                    if(text.length() > 0)
                    {
                        throw new LexerException(
                            "[" + (start_line + 1) + "," + (start_pos + 1) + "]" +
                            " Unknown token: " + text);
                    }
                    else
                    {
                        EOF token = new EOF(
                            start_line + 1,
                            start_pos + 1);
                        return token;
                    }
                }
            }
        }
    }

    Token new0(int line, int pos) { return new TDef(line, pos); }
    Token new1(int line, int pos) { return new TLPar(line, pos); }
    Token new2(int line, int pos) { return new TRPar(line, pos); }
    Token new3(int line, int pos) { return new TEq(line, pos); }
    Token new4(int line, int pos) { return new TComma(line, pos); }
    Token new5(int line, int pos) { return new TSemi(line, pos); }
    Token new6(int line, int pos) { return new TWhile(line, pos); }
    Token new7(int line, int pos) { return new TFor(line, pos); }
    Token new8(int line, int pos) { return new TIn(line, pos); }
    Token new9(int line, int pos) { return new TPrint(line, pos); }
    Token new10(int line, int pos) { return new TReturn(line, pos); }
    Token new11(int line, int pos) { return new TMeq(line, pos); }
    Token new12(int line, int pos) { return new TSeq(line, pos); }
    Token new13(int line, int pos) { return new TLBr(line, pos); }
    Token new14(int line, int pos) { return new TRBr(line, pos); }
    Token new15(int line, int pos) { return new TAssert(line, pos); }
    Token new16(int line, int pos) { return new TPlus(line, pos); }
    Token new17(int line, int pos) { return new TMinus(line, pos); }
    Token new18(int line, int pos) { return new TMult(line, pos); }
    Token new19(int line, int pos) { return new TDiv(line, pos); }
    Token new20(int line, int pos) { return new TMod(line, pos); }
    Token new21(int line, int pos) { return new TDmult(line, pos); }
    Token new22(int line, int pos) { return new TOpen(line, pos); }
    Token new23(int line, int pos) { return new TType(line, pos); }
    Token new24(int line, int pos) { return new TMax(line, pos); }
    Token new25(int line, int pos) { return new TMin(line, pos); }
    Token new26(int line, int pos) { return new TAnd(line, pos); }
    Token new27(int line, int pos) { return new TOr(line, pos); }
    Token new28(int line, int pos) { return new TNot(line, pos); }
    Token new29(int line, int pos) { return new TLess(line, pos); }
    Token new30(int line, int pos) { return new TGreat(line, pos); }
    Token new31(int line, int pos) { return new TLesseq(line, pos); }
    Token new32(int line, int pos) { return new TGreateq(line, pos); }
    Token new33(int line, int pos) { return new TNoteq(line, pos); }
    Token new34(int line, int pos) { return new TTrue(line, pos); }
    Token new35(int line, int pos) { return new TFalse(line, pos); }
    Token new36(int line, int pos) { return new TDot(line, pos); }
    Token new37(String text, int line, int pos) { return new TTab(text, line, pos); }
    Token new38(String text, int line, int pos) { return new TBlank(text, line, pos); }
    Token new39(String text, int line, int pos) { return new TId(text, line, pos); }
    Token new40(String text, int line, int pos) { return new TLineComment(text, line, pos); }
    Token new41(String text, int line, int pos) { return new TString(text, line, pos); }
    Token new42(String text, int line, int pos) { return new TNumber(text, line, pos); }

    private int getChar() throws IOException
    {
        if(eof)
        {
            return -1;
        }

        int result = in.read();

        if(result == -1)
        {
            eof = true;
        }

        return result;
    }

    private void pushBack(int acceptLength) throws IOException
    {
        int length = text.length();
        for(int i = length - 1; i >= acceptLength; i--)
        {
            eof = false;

            in.unread(text.charAt(i));
        }
    }

    protected void unread(Token token) throws IOException
    {
        String text = token.getText();
        int length = text.length();

        for(int i = length - 1; i >= 0; i--)
        {
            eof = false;

            in.unread(text.charAt(i));
        }

        pos = token.getPos() - 1;
        line = token.getLine() - 1;
    }

    private String getText(int acceptLength)
    {
        StringBuffer s = new StringBuffer(acceptLength);
        for(int i = 0; i < acceptLength; i++)
        {
            s.append(text.charAt(i));
        }

        return s.toString();
    }

    private static int[][][][] gotoTable;
/*  {
        { // INITIAL
            {{9, 9, 1}, {10, 10, 2}, {13, 13, 3}, {32, 32, 4}, {33, 33, 5}, {34, 34, 6}, {35, 35, 7}, {37, 37, 8}, {40, 40, 9}, {41, 41, 10}, {42, 42, 11}, {43, 43, 12}, {44, 44, 13}, {45, 45, 14}, {46, 46, 15}, {47, 47, 16}, {48, 57, 17}, {58, 58, 18}, {60, 60, 19}, {61, 61, 20}, {62, 62, 21}, {65, 90, 22}, {91, 91, 23}, {93, 93, 24}, {97, 97, 25}, {98, 99, 26}, {100, 100, 27}, {101, 101, 26}, {102, 102, 28}, {103, 104, 26}, {105, 105, 29}, {106, 108, 26}, {109, 109, 30}, {110, 110, 31}, {111, 111, 32}, {112, 112, 33}, {113, 113, 26}, {114, 114, 34}, {115, 115, 26}, {116, 116, 35}, {117, 118, 26}, {119, 119, 36}, {120, 122, 26}, },
            {},
            {},
            {},
            {},
            {{61, 61, 37}, },
            {{0, 9, 38}, {11, 12, 38}, {14, 33, 38}, {34, 34, 39}, {35, 127, 38}, },
            {{0, 9, 40}, {10, 10, 41}, {11, 12, 40}, {13, 13, 42}, {14, 127, 40}, },
            {},
            {},
            {},
            {{42, 42, 43}, },
            {},
            {},
            {{61, 61, 44}, },
            {},
            {{61, 61, 45}, },
            {{46, 46, 46}, {48, 57, 17}, },
            {},
            {{61, 61, 47}, },
            {},
            {{61, 61, 48}, },
            {{48, 57, 49}, {65, 90, 50}, {97, 122, 51}, },
            {},
            {},
            {{48, 90, -24}, {97, 109, 51}, {110, 110, 52}, {111, 114, 51}, {115, 115, 53}, {116, 122, 51}, },
            {{48, 122, -24}, },
            {{48, 90, -24}, {97, 100, 51}, {101, 101, 54}, {102, 122, 51}, },
            {{48, 90, -24}, {97, 97, 55}, {98, 110, 51}, {111, 111, 56}, {112, 122, 51}, },
            {{48, 109, -27}, {110, 110, 57}, {111, 122, 51}, },
            {{48, 90, -24}, {97, 97, 58}, {98, 104, 51}, {105, 105, 59}, {106, 122, 51}, },
            {{48, 90, -24}, {97, 110, 51}, {111, 111, 60}, {112, 122, 51}, },
            {{48, 90, -24}, {97, 111, 51}, {112, 112, 61}, {113, 113, 51}, {114, 114, 62}, {115, 122, 51}, },
            {{48, 90, -24}, {97, 113, 51}, {114, 114, 63}, {115, 122, 51}, },
            {{48, 100, -29}, {101, 101, 64}, {102, 122, 51}, },
            {{48, 113, -35}, {114, 114, 65}, {115, 120, 51}, {121, 121, 66}, {122, 122, 51}, },
            {{48, 90, -24}, {97, 103, 51}, {104, 104, 67}, {105, 122, 51}, },
            {},
            {{0, 127, -8}, },
            {{0, 127, -8}, },
            {{0, 127, -9}, },
            {},
            {{10, 10, 68}, },
            {},
            {},
            {},
            {{48, 57, 69}, },
            {},
            {},
            {{48, 122, -24}, },
            {{48, 122, -24}, },
            {{48, 122, -24}, },
            {{48, 90, -24}, {97, 99, 51}, {100, 100, 70}, {101, 122, 51}, },
            {{48, 90, -24}, {97, 114, 51}, {115, 115, 71}, {116, 122, 51}, },
            {{48, 90, -24}, {97, 101, 51}, {102, 102, 72}, {103, 122, 51}, },
            {{48, 90, -24}, {97, 107, 51}, {108, 108, 73}, {109, 122, 51}, },
            {{48, 113, -35}, {114, 114, 74}, {115, 122, 51}, },
            {{48, 122, -24}, },
            {{48, 90, -24}, {97, 119, 51}, {120, 120, 75}, {121, 122, 51}, },
            {{48, 109, -27}, {110, 110, 76}, {111, 122, 51}, },
            {{48, 90, -24}, {97, 115, 51}, {116, 116, 77}, {117, 122, 51}, },
            {{48, 100, -29}, {101, 101, 78}, {102, 122, 51}, },
            {{48, 122, -24}, },
            {{48, 90, -24}, {97, 104, 51}, {105, 105, 79}, {106, 122, 51}, },
            {{48, 115, -62}, {116, 116, 80}, {117, 122, 51}, },
            {{48, 90, -24}, {97, 116, 51}, {117, 117, 81}, {118, 122, 51}, },
            {{48, 111, -34}, {112, 112, 82}, {113, 122, 51}, },
            {{48, 104, -65}, {105, 105, 83}, {106, 122, 51}, },
            {},
            {{48, 57, 69}, },
            {{48, 122, -24}, },
            {{48, 100, -29}, {101, 101, 84}, {102, 122, 51}, },
            {{48, 122, -24}, },
            {{48, 114, -55}, {115, 115, 85}, {116, 122, 51}, },
            {{48, 122, -24}, },
            {{48, 122, -24}, },
            {{48, 122, -24}, },
            {{48, 122, -24}, },
            {{48, 109, -27}, {110, 110, 86}, {111, 122, 51}, },
            {{48, 109, -27}, {110, 110, 87}, {111, 122, 51}, },
            {{48, 116, -67}, {117, 117, 88}, {118, 122, 51}, },
            {{48, 100, -29}, {101, 101, 89}, {102, 122, 51}, },
            {{48, 100, -29}, {101, 101, 90}, {102, 122, 51}, },
            {{48, 107, -57}, {108, 108, 91}, {109, 122, 51}, },
            {{48, 113, -35}, {114, 114, 92}, {115, 122, 51}, },
            {{48, 100, -29}, {101, 101, 93}, {102, 122, 51}, },
            {{48, 122, -24}, },
            {{48, 115, -62}, {116, 116, 94}, {117, 122, 51}, },
            {{48, 113, -35}, {114, 114, 95}, {115, 122, 51}, },
            {{48, 122, -24}, },
            {{48, 122, -24}, },
            {{48, 100, -29}, {101, 101, 96}, {102, 122, 51}, },
            {{48, 115, -62}, {116, 116, 97}, {117, 122, 51}, },
            {{48, 122, -24}, },
            {{48, 122, -24}, },
            {{48, 109, -27}, {110, 110, 98}, {111, 122, 51}, },
            {{48, 122, -24}, },
            {{48, 122, -24}, },
            {{48, 122, -24}, },
        }
    };*/

    private static int[][] accept;
/*  {
        // INITIAL
        {-1, 37, 38, 38, 38, -1, -1, -1, 20, 1, 2, 18, 16, 4, 17, 36, 19, 42, 5, 29, 3, 30, 39, 13, 14, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 33, -1, 41, -1, 40, 40, 21, 11, 12, -1, 31, 32, 39, 39, 39, 39, 39, 39, 39, 39, 8, 39, 39, 39, 39, 27, 39, 39, 39, 39, 39, 40, 42, 26, 39, 0, 39, 7, 24, 25, 28, 39, 39, 39, 39, 39, 39, 39, 39, 22, 39, 39, 34, 23, 39, 39, 35, 9, 39, 6, 15, 10, },

    };*/

    public static class State
    {
        public final static State INITIAL = new State(0);

        private int id;

        private State(int id)
        {
            this.id = id;
        }

        public int id()
        {
            return id;
        }
    }
}
