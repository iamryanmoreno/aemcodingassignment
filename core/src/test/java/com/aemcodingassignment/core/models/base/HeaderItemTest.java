package com.aemcodingassignment.core.models.base;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HeaderItemTest {

    private HeaderItem headerItem;

    @Before
    public void setUp() {
        List<NavLink> navLinks = new ArrayList<>();
        navLinks.add(new NavLink("Link 1", "/path/to/link1"));
        navLinks.add(new NavLink("Link 2", "/path/to/link2"));

        headerItem = new HeaderItem("Custom Header", navLinks);
    }

    @Test
    public void testNavigationHeader() {
        assertNotNull(headerItem);
        assertEquals("Custom Header", headerItem.getNavigationHeader());
    }

    @Test
    public void testNavigationLinks() {
        assertNotNull(headerItem);
        assertNotNull(headerItem.getNavigationLinks());
        assertEquals(2, headerItem.getNavigationLinks().size());
        assertEquals("Link 1", headerItem.getNavigationLinks().get(0).getNavigationLabel());
        assertEquals("/path/to/link2", headerItem.getNavigationLinks().get(1).getNavigationLink());
    }
}
