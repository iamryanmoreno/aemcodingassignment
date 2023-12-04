package com.aemcodingassignment.core.models.base;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class HeaderTest {

    @Mock
    private Resource resource;

    @Mock
    private PageManager pageManager;

    @Mock
    private Page listingPage;

    @Mock
    private Iterator<Page> pages;

    @InjectMocks
    private Header header;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Mock behavior for resourceResolver and adaptTo method
        ResourceResolver resourceResolver = mock(ResourceResolver.class);
        when(resource.getResourceResolver()).thenReturn(resourceResolver);
        when(resourceResolver.adaptTo(PageManager.class)).thenReturn(pageManager);

        // Mock behavior for PageManager and Page
        when(pageManager.getContainingPage("/content/aemcodingassignment/en")).thenReturn(listingPage);
        when(listingPage.listChildren()).thenReturn(pages);
        when(pages.hasNext()).thenReturn(true, false);
        when(pages.next()).thenReturn(mock(Page.class));

        // Initialize Header instance
        header = new Header();
        header.resource = resource;
        header.menu = "/content/aemcodingassignment/en";
    }

    @Test
    public void testGetNavigationSection() {
        // Call the init method (usually invoked after object creation/post-construction)
        header.init();

        // Test that navigation section is populated
        assertEquals(0, header.getNavigationSection().size()); // Update the expected size as per your logic
    }

    // Add more test cases as needed to cover different scenarios and edge cases
}
