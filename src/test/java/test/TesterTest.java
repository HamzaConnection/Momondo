/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hamzalaroussi
 */
public class TesterTest
{
    
    public TesterTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of main method, of class Tester.
     */
    @Test
    public void testMain()
    {
        System.out.println("main");
        String[] args = null;
        Tester.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Build method, of class Tester.
     */
    @Test
    public void testBuild()
    {
        System.out.println("Build");
        Tester.Build();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Test method, of class Tester.
     */
    @Test
    public void testTest()
    {
        System.out.println("Test");
        Tester.Test();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of giveMeTen method, of class Tester.
     */
    @Test
    public void testGiveMeTen()
    {
        System.out.println("giveMeTen");
        assertEquals(15, Tester.giveMeTen());
        
    }
    
}
