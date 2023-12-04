package com.aemcodingassignment.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import uk.org.lidalia.slf4jtest.LoggingEvent;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

class InformationModelTest{

    InformationModel informationModel = new InformationModel();

    private TestLogger logger = TestLoggerFactory.getTestLogger(informationModel.getClass());

    @BeforeEach
    void setup() {
        TestLoggerFactory.clear();
    }

    @Test
    void testInformationModelMethod() {
        informationModel.setLink("link");
        assertEquals("link", informationModel.getLink());
    }

}
