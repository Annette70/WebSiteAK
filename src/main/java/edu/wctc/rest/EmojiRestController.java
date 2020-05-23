package edu.wctc.rest;

import edu.wctc.entity.Emoji;
import edu.wctc.exception.EmojiNotFoundException;
import edu.wctc.exception.RestErrorResponse;
import edu.wctc.service.EmojiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class EmojiRestController {
    @Autowired
    private EmojiService emojiService;

    @GetMapping("/emojis")
    public List<Emoji> getEmojis(){return emojiService.getEmojis();}

    @GetMapping("/emojis/{emojiId}")
    public Emoji getEmoji(@PathVariable int emojiId){
        Emoji theEmoji = emojiService.getEmoji(emojiId);
        return theEmoji;
    }

    @PostMapping("/emojis")
    public Emoji addEmoji(@RequestBody Emoji theEmoji){
        theEmoji.setId(0);

        emojiService.saveEmoji(theEmoji, -1);

        return theEmoji;
    }

    @DeleteMapping("/emojis/{emojiId}")
    public String deleteEmoji(@PathVariable int emojiId) {
        Emoji tempEmoji = emojiService.getEmoji(emojiId);

        //Throw exception if null (not found)
        if (tempEmoji == null) {
            throw new EmojiNotFoundException("Emoji ID not found: " + emojiId);
        }

        emojiService.deleteEmoji(emojiId);

        return "Deleted emoji ID: " + emojiId;
    }

    @ExceptionHandler
    public ResponseEntity<RestErrorResponse> handleException(EmojiNotFoundException exception) {
        RestErrorResponse error = new RestErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<RestErrorResponse> handleException(Exception exception) {
        RestErrorResponse error = new RestErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
