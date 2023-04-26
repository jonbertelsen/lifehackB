package dat.backend.persistence;

import dat.backend.control.SodaCalculatorServlet;
import dat.backend.model.entities.Soda;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class SodaCalculatorServletTest {

    private SodaCalculatorServlet servlet;
    @Mock
    private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    @Mock private RequestDispatcher requestDispatcher;
    @Mock private ServletContext servletContext;
    @Mock private HttpSession session;

    @Before
    public void setUp() throws ServletException {
        servlet = new SodaCalculatorServlet();
        MockitoAnnotations.openMocks(this);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);


    }

    @Test
    public void testDoPostNegativeSoda() throws ServletException, IOException {
        // Arrange
        when(request.getParameter("soda")).thenReturn("-2.5");
        when(request.getParameter("price")).thenReturn("2.0");
        when(request.getParameter("sugarFree")).thenReturn("false");
        // Act
        servlet.doPost(request, response);
        // Assert
        verify(request).getRequestDispatcher("error.jsp");
        verify(request).setAttribute(eq("errormessage"), eq("Negative tal er ikke tilladt."));
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoPostNegativePrice() throws ServletException, IOException {
        // Arrange
        when(request.getParameter("soda")).thenReturn("2.5");
        when(request.getParameter("price")).thenReturn("-2.0");
        when(request.getParameter("sugarFree")).thenReturn("false");
        // Act
        servlet.doPost(request, response);
        // Assert
        verify(request).getRequestDispatcher("error.jsp");
        verify(request).setAttribute(eq("errormessage"), eq("Negative tal er ikke tilladt."));
        verify(requestDispatcher).forward(request, response);
    }

    // Test for when the user inputs a negative number for both soda and price
    @Test
    public void testDoPostNegativeSodaAndPrice() throws ServletException, IOException {
        // Arrange
        when(request.getParameter("soda")).thenReturn("-2.5");
        when(request.getParameter("price")).thenReturn("-2.0");
        when(request.getParameter("sugarFree")).thenReturn("false");
        // Act
        servlet.doPost(request, response);
        // Assert
        verify(request).getRequestDispatcher("error.jsp");
        verify(request).setAttribute(eq("errormessage"), eq("Negative tal er ikke tilladt."));
        verify(requestDispatcher).forward(request, response);
    }

    // Test for when the user inputs a positive number for both soda and price
    @Test
    public void testDoPostPositiveSodaAndPrice() {
        ArrayList<double[]> expectedPercentages = new ArrayList<double[]>();
        expectedPercentages.add(new double[]{10.0, 4.5, 0.5, 4.0, 120.0, 1440.0, 19.0});
        expectedPercentages.add(new double[]{20.0, 4.0, 1.0, 8.0, 240.0, 2880.0, 38});
        expectedPercentages.add(new double[]{50.0, 2.5, 2.5, 20.0, 600.0, 7200.0, 95.0});
        expectedPercentages.add(new double[]{100.0, 0.0, 5.0, 40.0, 1200.0, 14400.0, 190.0});

        Soda s = new Soda(5, 8);

        ArrayList<double[]> actualPercentages = s.getPercentages();
        assertEquals(expectedPercentages.size(), actualPercentages.size());

        for (int i = 0; i < expectedPercentages.size(); i++) {
            assertArrayEquals(expectedPercentages.get(i), actualPercentages.get(i), 0.001);
        }


    }




}
