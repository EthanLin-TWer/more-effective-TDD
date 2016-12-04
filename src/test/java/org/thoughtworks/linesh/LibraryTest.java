package org.thoughtworks.linesh;

import support.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@Mockito
public class LibraryTest {
    @Mock private Library library;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertTrue(classUnderTest.someLibraryMethod());
    }

    @Test
    void testUsingMockito() {
        library.someLibraryMethod();

        verify(library).someLibraryMethod();
    }
}
