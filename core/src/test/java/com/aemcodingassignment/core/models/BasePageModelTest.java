package com.aemcodingassignment.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.scripting.SlingBindings;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BasePageModelTest {

    @Mock
    private Resource resource;

    @Mock
    private SlingBindings slingBindings;

    @InjectMocks
    private BasePageModel basePageModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Mocking behavior for the injected values
        when(slingBindings.getResource()).thenReturn(resource);
        when(slingBindings.get("generator")).thenReturn("Mocked Generator");
        when(slingBindings.get("keywords")).thenReturn("Mocked Keywords");
        when(slingBindings.get("canonicalURL")).thenReturn("Mocked Canonical URL");
        when(slingBindings.get("scriptHeader")).thenReturn("Mocked Script Header");
        when(slingBindings.get("contentHeader")).thenReturn("Mocked Content Header");
        when(slingBindings.get("scriptBody")).thenReturn("Mocked Script Body");
        when(slingBindings.get("contentBody")).thenReturn("Mocked Content Body");
        when(slingBindings.get("scriptFooter")).thenReturn("Mocked Script Footer");
        when(slingBindings.get("contentFooter")).thenReturn("Mocked Content Footer");

        basePageModel = new BasePageModel();
        basePageModel.init(slingBindings);
    }

    @Test
    public void testGetGenerator() {
        assertEquals("Mocked Generator", basePageModel.getGenerator());
    }

    @Test
    public void testGetKeywords() {
        assertEquals("Mocked Keywords", basePageModel.getKeywords());
    }

    @Test
    public void testGetCanonicalURL() {
        assertEquals("Mocked Canonical URL", basePageModel.getCanonicalURL());
    }

    // Add similar tests for other getters
}
