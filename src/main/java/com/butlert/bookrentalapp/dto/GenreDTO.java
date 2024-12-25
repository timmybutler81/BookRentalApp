package com.butlert.bookrentalapp.dto;

public class GenreDTO {

    private Long id;

    private String genreName;

    private boolean activeFlag;

    public GenreDTO() {
    }

    public GenreDTO(Long id, String genreName, boolean activeFlag) {
        this.id = id;
        this.genreName = genreName;
        this.activeFlag = activeFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
