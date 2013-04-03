package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 4/2/13
 * Time: 7:55 PM
 */
public class PostfixNotationTest {
    @Test
    public void testGetPostfixNotation() throws Exception {
        List<String> inputList = new ArrayList<String>();
        inputList.add("5");
        inputList.add("1");
        inputList.add("2");
        inputList.add("+");
        inputList.add("4");
        inputList.add("*");
        inputList.add("+");
        inputList.add("3");
        inputList.add("-");
        PostfixNotation postfixNotation = new PostfixNotation();
        double result = postfixNotation.getPostfixNotation(inputList);
        assertEquals(14.0, result);
    }

    @Test
    public void testGetPostfixNotation_oneNumberInput() throws Exception {
        List<String> inputList = new ArrayList<String>();
        inputList.add("3");
        PostfixNotation postfixNotation = new PostfixNotation();
        double result = postfixNotation.getPostfixNotation(inputList);
        assertEquals(3.0, result);
    }

    @Test(expected = RuntimeException.class)
    public void testGetPostfixNotation_emptyInput() throws Exception {
        List<String> inputList = new ArrayList<String>();
        PostfixNotation postfixNotation = new PostfixNotation();
        postfixNotation.getPostfixNotation(inputList);
    }

    @Test(expected = RuntimeException.class)
    public void testGetPostfixNotation_invalidInput() throws Exception {
        List<String> inputList = new ArrayList<String>();
        inputList.add("3");
        inputList.add("3");
        PostfixNotation postfixNotation = new PostfixNotation();
        postfixNotation.getPostfixNotation(inputList);
    }

    @Test(expected = RuntimeException.class)
    public void testGetPostfixNotation_oneOperatorInput() throws Exception {
        List<String> inputList = new ArrayList<String>();
        inputList.add("+");
        PostfixNotation postfixNotation = new PostfixNotation();
        postfixNotation.getPostfixNotation(inputList);
    }

    @Test(expected = RuntimeException.class)
    public void testGetPostfixNotation_oneNumberOneOperatorInput() throws Exception {
        List<String> inputList = new ArrayList<String>();
        inputList.add("3");
        inputList.add("+");
        PostfixNotation postfixNotation = new PostfixNotation();
        postfixNotation.getPostfixNotation(inputList);
    }

    @Test(expected = RuntimeException.class)
    public void testGetPostfixNotation_ZeroDivision() throws Exception {
        List<String> inputList = new ArrayList<String>();
        inputList.add("3");
        inputList.add("0");
        inputList.add("/");
        PostfixNotation postfixNotation = new PostfixNotation();
        postfixNotation.getPostfixNotation(inputList);
    }

    @Test(expected = RuntimeException.class)
    public void testGetPostfixNotation_InvalidOperator() throws Exception {
        List<String> inputList = new ArrayList<String>();
        inputList.add("3");
        inputList.add("0");
        inputList.add("a");
        PostfixNotation postfixNotation = new PostfixNotation();
        postfixNotation.getPostfixNotation(inputList);
    }
}
