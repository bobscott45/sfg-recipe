package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.Note;
import dev.bobscott.sfgrecipe.dto.NoteDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class NoteToDtoTest {

    private Long id;
    private String text;



    @Before
    public void SetUp() {
        id = 42L;
        text = "Some text";
    }


    @Test
    public void mapNullToDto() {
        assertNull(NoteMapper.INSTANCE.noteToDto(null));
    }

    @Test
    public void mapEmptyNoteToDto() {
        assertNotNull(NoteMapper.INSTANCE.noteToDto(new Note()));
    }

    @Test
    public void mapNoteToDto() {
        Note note = new Note();
        note.setText(text);
        note.setId(id);

        NoteDto NoteDto = NoteMapper.INSTANCE.noteToDto(note);

        assertEquals(id, NoteDto.getId());
        assertEquals(text, NoteDto.getText());
    }

}
