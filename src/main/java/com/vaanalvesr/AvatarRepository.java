package com.vaanalvesr;

import java.util.List;

public interface AvatarRepository {
    List<NationReply> getNations();

    List<ElementReply> getElements();

    List<AvatarReply> getAvatars();
}
