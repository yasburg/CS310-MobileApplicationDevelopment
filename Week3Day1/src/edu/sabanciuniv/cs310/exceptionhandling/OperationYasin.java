package edu.sabanciuniv.cs310.exceptionhandling;

public class OperationYasin {
    public static void testOperation(String str) throws YasinException {
        if (str == "yasin") {
            throw new YasinException();
        }
    }
}
