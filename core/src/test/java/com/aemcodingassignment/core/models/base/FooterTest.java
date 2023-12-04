package com.aemcodingassignment.core.models.base;

import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class FooterTest {

    @Mock
    private Resource primaryMock;

    @Mock
    private Resource secondaryMock;

    @Mock
    private Resource socialMock;

    @InjectMocks
    private Footer footer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPrimary() {
        // Set up the mock resources
        when(primaryMock.getName()).thenReturn("PrimaryLinks");

        // Set the mock resources into the Footer object
        footer.primary = primaryMock;

        // Test whether the getPrimary method returns the mock resource
        Resource primaryResource = footer.getPrimary();
        assertNotNull(primaryResource);
        // You can add further assertions based on your specific use case
    }

    @Test
    void testGetSecondary() {
        // Set up the mock resources
        when(secondaryMock.getName()).thenReturn("SecondaryLinks");

        // Set the mock resources into the Footer object
        footer.secondary = secondaryMock;

        // Test whether the getSecondary method returns the mock resource
        Resource secondaryResource = footer.getSecondary();
        assertNotNull(secondaryResource);
        // You can add further assertions based on your specific use case
    }

    @Test
    void testGetSocial() {
        // Set up the mock resources
        when(socialMock.getName()).thenReturn("SocialMediaLinks");

        // Set the mock resources into the Footer object
        footer.social = socialMock;

        // Test whether the getSocial method returns the mock resource
        Resource socialResource = footer.getSocial();
        assertNotNull(socialResource);
        // You can add further assertions based on your specific use case
    }
}
