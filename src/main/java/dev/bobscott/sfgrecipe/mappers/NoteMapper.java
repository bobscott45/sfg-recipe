package dev.bobscott.sfgrecipe.mappers;

import dev.bobscott.sfgrecipe.domain.Note;
import dev.bobscott.sfgrecipe.dto.NoteDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NoteMapper {
    NoteMapper INSTANCE = Mappers.getMapper(NoteMapper.class);

    NoteDto noteToDto(Note note);
    Note dtoToNote(NoteDto dto);
}
