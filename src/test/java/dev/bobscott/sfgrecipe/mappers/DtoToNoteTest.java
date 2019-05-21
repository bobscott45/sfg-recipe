package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.Note;
import dev.bobscott.sfgrecipe.dto.NoteDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DtoToNoteTest {

    private Long id;
    private String text;



    @Before
    public void SetUp() {
        id = 42L;
        text = "Some text";
    }

    @Test
    public void mapNullToNote() {
        assertNull(NoteMapper.INSTANCE.dtoToNote(null));
    }

    @Test
    public void mapEmptyDtoToNote() {
        assertNotNull(NoteMapper.INSTANCE.dtoToNote(new NoteDto()));
    }

    @Test
    public void mapDtoToNote() {
        NoteDto dto = new NoteDto();
        dto.setId(id);
        dto.setText(text);

        Note note = NoteMapper.INSTANCE.dtoToNote(dto);

        assertNotNull(note);
        assertEquals(id, note.getId());
        assertEquals(text, note.getText());
    }

}
