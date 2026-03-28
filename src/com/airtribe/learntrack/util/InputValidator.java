package com.airtribe.learntrack.util;

import com.airtribe.learntrack.exception.InvalidInputException;

public final class InputValidator {
    private InputValidator() {
    }

    public static String requireNonBlank(String value, String fieldName) throws InvalidInputException {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidInputException(fieldName + " cannot be empty.");
        }
        return value.trim();
    }

    public static String requireEmail(String email) throws InvalidInputException {
        String normalizedEmail = requireNonBlank(email, "Email");
        if (!normalizedEmail.contains("@") || normalizedEmail.startsWith("@") || normalizedEmail.endsWith("@")) {
            throw new InvalidInputException("Please enter a valid email address.");
        }
        return normalizedEmail;
    }

    public static int requirePositiveInt(String value, String fieldName) throws InvalidInputException {
        try {
            int parsedValue = Integer.parseInt(value.trim());
            if (parsedValue <= 0) {
                throw new InvalidInputException(fieldName + " must be greater than zero.");
            }
            return parsedValue;
        } catch (NumberFormatException exception) {
            throw new InvalidInputException(fieldName + " must be a valid whole number.");
        }
    }
}
