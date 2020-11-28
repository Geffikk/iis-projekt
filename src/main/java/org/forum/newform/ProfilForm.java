package org.forum.newform;

import javax.validation.constraints.Size;

public class ProfilForm {

    @Size(max=30, message = "{Size.Topic.content.validation}")
    private String isPublic;

    public ProfilForm() {}

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }
}
