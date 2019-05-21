package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.Note;
import dev.bobscott.sfgrecipe.dto.NoteDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NoteMapperTest {

    private Long id;
    private String text;



    @Before
    public void SetUp() {
        id = 42L;
        text = "Some text";
    }


    @Test
    public void shouldMapNoteToDto() {
        Note note = new Note();
        note.setText(text);
        note.setId(id);

        NoteDto NoteDto = NoteMapper.INSTANCE.noteToDto(note);

        assertEquals(id, NoteDto.getId());
        assertEquals(text, NoteDto.getText());
    }

    @Test
    public void shouldMapDtoToNote() {
        NoteDto dto = new NoteDto();
        dto.setId(id);
        dto.setText(text);

        Note Note = NoteMapper.INSTANCE.dtoToNote(dto);

        assertEquals(id, Note.getId());
        assertEquals(text, Note.getText());
    }

}
