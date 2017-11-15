package be.dbo.antlr.main;

import be.dbo.FlowBaseVisitor;
import be.dbo.FlowLexer;
import be.dbo.FlowParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Created by diederikbosmans on 14/11/17.
 */
public class FlowVisitorParser {


    public Flow parse(String flowExpression) {

        FlowLexer flowLexer = new FlowLexer(new ANTLRInputStream(flowExpression));
        flowLexer.removeErrorListeners();
        flowLexer.addErrorListener(new ParseErrorListener());
        FlowParser fp = new FlowParser(new CommonTokenStream(flowLexer));
        fp.removeErrorListeners();
        fp.addErrorListener(new ParseErrorListener());
        FlowVisitor visitor = new FlowVisitor();
        return visitor.visit(fp.flowExpr());

    }

    private class ParseErrorListener extends BaseErrorListener {

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
                throws ParseCancellationException {
            throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
        }
    }

    private static class FlowVisitor extends FlowBaseVisitor<Flow> {

        @Override
        public Flow visitFlowExpr(FlowParser.FlowExprContext ctx) {
            Flow flow = new Flow();
            DepartureVisitor departureVisitor = new DepartureVisitor();
            ArrivalVisitor arrivalVisitor = new ArrivalVisitor();
            TimeVisitor timeVisitor = new TimeVisitor();

            flow.setDeparture(departureVisitor.visitDeparture(ctx.departure()));
            flow.setArrival(arrivalVisitor.visitArrival(ctx.arrival()));
            flow.setTime(timeVisitor.visitTime(ctx.time()));
            return flow;

        }
    }

    private static class DepartureVisitor extends FlowBaseVisitor<String> {
        @Override
        public String visitDeparture(FlowParser.DepartureContext ctx) {
            return ctx.getText();
        }
    }

    private static class ArrivalVisitor extends FlowBaseVisitor<String> {
        @Override
        public String visitArrival(FlowParser.ArrivalContext ctx) {
            return ctx.getText();
        }
    }

    private static class TimeVisitor extends FlowBaseVisitor<String> {
        @Override
        public String visitTime(FlowParser.TimeContext ctx) {
            if (ctx == null) {
                return null;
            }
            return ctx.getText();
        }
    }

}
