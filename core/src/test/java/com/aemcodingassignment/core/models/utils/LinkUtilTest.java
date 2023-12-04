package com.aemcodingassignment.core.models.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import uk.org.lidalia.slf4jtest.LoggingEvent;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;
import org.apache.commons.lang3.StringUtils;

class LinkUtilTest{

    LinkUtil linkUtil = new LinkUtil();

    private TestLogger logger = TestLoggerFactory.getTestLogger(linkUtil.getClass());

    @BeforeEach
    void setup() {
        TestLoggerFactory.clear();
    }

    @Test
    void testLinkUtilMethod() {
        String link = "/content/aemcodingassignment/en";

        assertNotNull(linkUtil.buildLinkPath(link));
        assertTrue(StringUtils.isNotBlank(link));
        assertTrue(!linkUtil.buildLinkPath(link).isEmpty());
        assertTrue(linkUtil.buildLinkPath(link).startsWith("/content/aemcodingassignment/"));
    }

}
