package com.examples.testing.shared;

import com.examples.testing.chat.domain.ChatId;
import com.examples.testing.grupo.domain.GrupoId;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ChatId.class, name = "chatId"),
        @JsonSubTypes.Type(value = GrupoId.class, name = "grupoId")
})
public abstract class Identifier implements Serializable {
    final protected String value;

    public Identifier(String value) {
        ensureValidUuid(value);

        this.value = value;
    }

    protected Identifier() {
        this.value = null;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void ensureValidUuid(String value) throws IllegalArgumentException {
        UUID.fromString(value);
    }
}
