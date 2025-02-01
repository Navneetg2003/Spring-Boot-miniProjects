package com.myapp.p9junit;

import com.myapp.p9junit.model.User;
import com.myapp.p9junit.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Mock
    private UserService userService;  // Mock the UserService

    @InjectMocks
    private User userMock;  // Automatically inject mocks into the User instance

    @BeforeEach
    public void setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUser() {
        // Arrange
        User user = new User("John Doe");

        // Act
        userService.addUser(user);

        // Assert
        verify(userService, times(1)).addUser(user);  // Verify that addUser was called exactly once
    }

    @Test
    public void testGetUsers() {
        // Arrange
        User user = new User("John Doe");
        when(userService.getUsers()).thenReturn(java.util.Collections.singletonList(user));  // Stubbing getUsers to return a mock list

        // Act
        var users = userService.getUsers();

        // Assert
        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals("John Doe", users.get(0).getName());
    }
}






//package com.myapp.p9junit;
//
//import com.myapp.p9junit.model.User;
//import com.myapp.p9junit.service.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//public class UserServiceTest {
//
//    private UserService userService;
//
//    @BeforeEach
//    public void setUp() {
//        userService = new UserService();
//    }
//
//    @Test
//    public void testAddUser() {
//        User user = new User("John Doe");
//        userService.addUser(user);
//
//        assertEquals(1, userService.getUsers().size());
//        assertEquals("John Doe", userService.getUsers().get(0).getName());
//    }
//
//    @Test
//    public void testGetUsers() {
//        User user1 = new User("John Doe");
//        User user2 = new User("Jane Smith");
//        userService.addUser(user1);
//        userService.addUser(user2);
//
//        assertEquals(2, userService.getUsers().size());
//        assertEquals("John Doe", userService.getUsers().get(0).getName());
//        assertEquals("Jane Smith", userService.getUsers().get(1).getName());
//    }
//}