package org.forum.newform;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class NewVlaknoForm {

    @Size(min = 3, max = 50, message = "{Size.Topic.title.validation}")
    private String predmet;

    @Size(min = 5, message = "{Size.Topic.content.validation}")
    private String kontent;

    @Min(value = 1, message = "{Min.Topic.sectionId.validation}")
    private int skupinaId;

    public NewVlaknoForm() {}

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public String getKontent() {
        return kontent;
    }

    public void setKontent(String kontent) {
        this.kontent = kontent;
    }

    public int getSkupinaId() {
        return skupinaId;
    }

    public void setSkupinaId(int skupinaId) {
        this.skupinaId = skupinaId;
    }
}
