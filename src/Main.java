

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.*;
public class Main {
    public static void main(String [] args)
    {
        try
        {
            String Source  = "test.txt";
            CharStream cs = fromFileName(Source);
            gLexer lexer = new gLexer(cs);
            CommonTokenStream token = new CommonTokenStream(lexer);
            System.out.println(token.getNumberOfOnChannelTokens());
            gParser parser = new gParser(token);
            ParseTree tree = parser.block();
            MyVisitor visitor = new MyVisitor();
            visitor.visit(tree);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
