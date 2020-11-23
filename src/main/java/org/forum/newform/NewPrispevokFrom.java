package org.forum.newform;

import javax.validation.constraints.Size;

public class NewPrispevokFrom {

    @Size(min = 3, message = "{Size.Post.content.validation}")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
