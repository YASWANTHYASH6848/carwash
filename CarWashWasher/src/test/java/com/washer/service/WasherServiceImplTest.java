package com.washer.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.washer.models.RatingReview;
import com.washer.models.Washer;

class WasherServiceImplTest {

    WasherServiceImpl washerServiceImplMock = mock(WasherServiceImpl.class);

//
//    @Test
//    @DisplayName("Get Logged In Washer Name")
//    void washerName() {
//        when(washerServiceImplMock.washerName()).thenReturn("name of the washer logged In");
//    }
//    
    
    @Test
    @DisplayName("Check Customer Wash-Requests")
    void washRequestFromCustomer() {
        when(washerServiceImplMock.washRequestFromCustomer()).thenReturn("book-wash");
    }

    
    @Test
    @DisplayName("Get washer by name")
    void findByName() {
        when(washerServiceImplMock.findByName("washer"))
                .thenReturn(new Washer(
                        1,"washer","pass","address","email","role"));
    }
}
