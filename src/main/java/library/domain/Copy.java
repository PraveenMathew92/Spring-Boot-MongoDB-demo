package library.domain;

import org.springframework.data.annotation.Id;

public class Copy {

    @Id
    private String id;

    private String typeId;
    private boolean available;
    private boolean availability;

    public Copy(String typeId) {
        this.typeId = typeId;
        this.available = true;
    }

    public String getTypeId() {
        return typeId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getId() {
        return id;
    }
}
