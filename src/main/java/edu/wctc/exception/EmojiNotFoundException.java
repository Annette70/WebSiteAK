package edu.wctc.exception;

public class EmojiNotFoundException extends RuntimeException{
    public EmojiNotFoundException(String message) {
        super(message);
    }
}
