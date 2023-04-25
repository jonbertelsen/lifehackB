package dat.backend.control;

import dat.backend.control.SmokeStopCalculatorServlet;
import dat.backend.model.exceptions.SmokeStopCalculatorException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;


// This is the test class for the SmokeStopCalculatorServlet
// It tests that the servlet sets the correct request attributes and forwards to the correct JSP page.
// The test uses the Mockito framework to mock the HttpServletRequest and HttpServletResponse objects.
// This is neccessary because the servlet uses the HttpServletRequest and HttpServletResponse objects to get the parameters from the user, and to set the attributes and forward the request to the JSP page.
// and when we test the servlet, we don't want to use the actual HttpServletRequest and HttpServletResponse objects, because we don't want to send the request to the JSP page, and we don't want to set the attributes.
// Instead, we want to use the mock objects, so that we can verify that the servlet sets the correct attributes and forwards to the correct JSP page.


class SmokeStopCalculatorServletTest {

    @Test
    void doPost() throws ServletException, IOException {
        // We use the mockito framework to mock the HttpServletRequest and HttpServletResponse objects.

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        // Create an instance of the servlet
        SmokeStopCalculatorServlet servlet = new SmokeStopCalculatorServlet();

        // Here we set the parameters that the user has entered in the form.
        // We use the Mockito framework to set the parameters.
        // So these numbers are only used for testing purposes.
        when(request.getParameter("pricePerCigarette")).thenReturn("1.25");
        when(request.getParameter("cigarettesPerDay")).thenReturn("20");

        // We then set the request dispatcher to return the mock request dispatcher.
        when(request.getRequestDispatcher("smokestopcalculator.jsp")).thenReturn(requestDispatcher);

        // And here we call the doPost method of the servlet.
        // This is the method that we want to test.
        servlet.doPost(request, response);

        // Here we verify that the servlet has set the correct attributes.
        verify(request).setAttribute(eq("totalSavedAWeek"), any(Double.class));
        verify(request).setAttribute(eq("totalSavedAMonth"), any(Double.class));
        verify(request).setAttribute(eq("totalSavedAYear"), any(Double.class));
        verify(request).setAttribute(eq("savings10"), any(Double.class));
        verify(request).setAttribute(eq("savings20"), any(Double.class));
        verify(request).setAttribute(eq("savings50"), any(Double.class));
        verify(request).setAttribute(eq("savings100"), any(Double.class));
        verify(request).setAttribute(eq("cigarettesAfter10PercentCut"), any(Double.class));
        verify(request).setAttribute(eq("cigarettesAfter20PercentCut"), any(Double.class));
        verify(request).setAttribute(eq("cigarettesAfter50PercentCut"), any(Double.class));
        verify(request).setAttribute(eq("cigarettesAfter100PercentCut"), any(Double.class));

        // And lastly we verify that the servlet has forwarded to the correct JSP page.
        verify(requestDispatcher).forward(request, response);
    }
}
