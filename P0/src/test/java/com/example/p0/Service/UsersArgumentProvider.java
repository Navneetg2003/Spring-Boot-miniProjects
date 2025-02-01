
package com.example.p0.Service;

import com.example.p0.Entity.StudentEntry;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class UsersArgumentProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        StudentEntry student1 = new StudentEntry();
        student1.setName("Nav");

        StudentEntry student2 = new StudentEntry();
        student2.setName("anc");

        StudentEntry student3 = new StudentEntry();
        student3.setName("aaa");

        return Stream.of(
                Arguments.of(student1),
                Arguments.of(student2),
                Arguments.of(student3)
        );
    }
}

