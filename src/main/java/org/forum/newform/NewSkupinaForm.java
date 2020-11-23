package org.forum.newform;

import javax.validation.constraints.Size;

public class NewSkupinaForm {

    @Size(min = 1, max = 50, message = "{Size.Section.type.validation}")
    private String nazov;

    @Size(max = 300)
    private String popis;

    public NewSkupinaForm() {
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }
}
