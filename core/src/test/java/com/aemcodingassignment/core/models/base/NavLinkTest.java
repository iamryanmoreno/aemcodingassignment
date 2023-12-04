package com.aemcodingassignment.core.models.base;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NavLinkTest {

    @Test
    public void testDefaultConstructor() {
        NavLink navLink = new NavLink();

        // Test default values from the default constructor
        assertEquals(null, navLink.getNavigationLabel());
        assertEquals(null, navLink.getNavigationLink());
        assertEquals("_self", navLink.getNavigationOpenInNewWin());
    }

    @Test
    public void testParameterizedConstructor() {
        NavLink navLink = new NavLink("Example Label", "/example/link");

        // Test values from the parameterized constructor
        assertEquals("Example Label", navLink.getNavigationLabel());
        assertEquals("/example/link", navLink.getNavigationLink());
        assertEquals("_self", navLink.getNavigationOpenInNewWin());
    }

    @Test
    public void testSettersAndGetters() {
        NavLink navLink = new NavLink();

        assertEquals("New Label", navLink.getNavigationLabel());
        assertEquals("/new/link", navLink.getNavigationLink());
        assertEquals("_blank", navLink.getNavigationOpenInNewWin());
    }
}
