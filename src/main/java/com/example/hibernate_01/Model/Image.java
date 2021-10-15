package com.example.hibernate_01.Model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false , nullable = false)
    private String id;

    @Column(name = "cover", nullable = true)
    private Boolean cover;

    @Column(name = "name", nullable = true)
    private String name;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name="pic", columnDefinition="BLOB", nullable = true)
    private byte[] pic;

    @Column(name = "CREATED_AT", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private Timestamp updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getCover() {
        return cover;
    }

    public void setCover(Boolean cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id='" + id + '\'' +
                ", cover=" + cover +
                ", name='" + name + '\'' +
                ", pic=" + Arrays.toString(pic) +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image)) return false;
        Image image = (Image) o;
        return getId().equals(image.getId()) && getCover().equals(image.getCover()) && getName().equals(image.getName()) && Arrays.equals(getPic(), image.getPic()) && Objects.equals(getCreatedAt(), image.getCreatedAt()) && Objects.equals(getUpdatedAt(), image.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getCover(), getName(), getCreatedAt(), getUpdatedAt());
        result = 31 * result + Arrays.hashCode(getPic());
        return result;
    }
}
