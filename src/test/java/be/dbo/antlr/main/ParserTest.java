package be.dbo.antlr.main;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by diederikbosmans on 14/11/17.
 */
public class ParserTest {


    @Test
    public void parseValidFlow() {

        FlowVisitorParser parser = new FlowVisitorParser();
        Flow result = parser.parse("dep ebbr arr kkll");
        assertEquals("ebbr" , result.getDeparture());
        assertEquals("kkll" , result.getArrival());

    }

    @Test
    public void handleParseError() {

        FlowVisitorParser parser = new FlowVisitorParser();
        try {
            parser.parse("dep ebbr fail arr ");
            fail("expected ParseCancellationException");
        } catch (Exception e) {
            assertTrue(e instanceof ParseCancellationException);
        }
    }
}
