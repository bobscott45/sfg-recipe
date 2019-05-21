package dev.bobscott.sfgrecipe.dto;

import java.util.Objects;

public class NoteDto {
    private Long id;
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteDto noteDto = (NoteDto) o;
        return Objects.equals(getText(), noteDto.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getText());
    }
}
