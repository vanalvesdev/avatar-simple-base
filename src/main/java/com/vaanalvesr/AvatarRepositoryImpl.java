package com.vaanalvesr;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class AvatarRepositoryImpl implements AvatarRepository {

    @Override
    public List<NationReply> getNations() {
        return Arrays.asList(
                NationReply.newBuilder().setName("Nacao do Fogo").setSymbol("fire.png").build(),
                NationReply.newBuilder().setName("Reino da Terra").setSymbol("earth.png").build(),
                NationReply.newBuilder().setName("Tribo da Agua").setSymbol("water.png").build(),
                NationReply.newBuilder().setName("Nomades do Ar").setSymbol("water.png").build()
        );
    }

    @Override
    public List<ElementReply> getElements() {
        return Arrays.asList(
                ElementReply.newBuilder().setName("Fogo").build(),
                ElementReply.newBuilder().setName("Terra").build(),
                ElementReply.newBuilder().setName("Agua").build(),
                ElementReply.newBuilder().setName("Ar").build(),
                ElementReply.newBuilder().setName("Energia").build(),
                ElementReply.newBuilder().setName("Metal").build(),
                ElementReply.newBuilder().setName("Sangue").build(),
                ElementReply.newBuilder().setName("Trovao").build()
        );
    }

    private List<ElementReply> getElementsByName(String... names) {
        List<String> nameList = Arrays.asList(names.clone());
        return getElements().stream().filter(it -> nameList.contains(it.getName())).collect(Collectors.toList());
    }

    private NationReply getNationByName(String name) {
        return getNations().stream().filter(it -> it.getName().equals(name)).findFirst().get();
    }

    @Override
    public List<AvatarReply> getAvatars() {
        return Arrays.asList(
                AvatarReply.newBuilder().setName("Korra")
                        .addAllElements(getElementsByName("Agua", "Fogo", "Terra", "Ar", "Sangue"))
                        .setNation(getNationByName("Tribo da Agua"))
                        .build(),
                AvatarReply.newBuilder().setName("Aang")
                        .addAllElements(getElementsByName("Agua", "Fogo", "Terra", "Ar", "Energia", "Metal", "Trovao"))
                        .setNation(getNationByName("Nomades do Ar"))
                        .build(),
                AvatarReply.newBuilder().setName("Roku")
                        .addAllElements(getElementsByName("Agua", "Fogo", "Terra", "Ar"))
                        .setNation(getNationByName("Nacao do Fogo"))
                        .build(),
                AvatarReply.newBuilder().setName("Kyoshi")
                        .addAllElements(getElementsByName("Agua", "Fogo", "Terra", "Ar"))
                        .setNation(getNationByName("Reino da Terra"))
                        .build(),
                AvatarReply.newBuilder().setName("Kuruk")
                        .addAllElements(getElementsByName("Agua", "Fogo", "Terra", "Ar"))
                        .setNation(getNationByName("Tribo da Agua"))
                        .build(),
                AvatarReply.newBuilder().setName("Yangchen")
                        .addAllElements(getElementsByName("Agua", "Fogo", "Terra", "Ar"))
                        .setNation(getNationByName("Nomades do Ar"))
                        .build(),
                AvatarReply.newBuilder().setName("Szeto")
                        .addAllElements(getElementsByName("Agua", "Fogo", "Terra", "Ar"))
                        .setNation(getNationByName("Nacao do Fogo"))
                        .build(),
                AvatarReply.newBuilder().setName("Wan")
                        .addAllElements(getElementsByName("Agua", "Fogo", "Terra", "Ar"))
                        .setNation(getNationByName("Nacao do Fogo"))
                        .build()
                );
    }
}
