package models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import play.data.validation.Required;
import play.db.jpa.GenericModel;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Set;

@Entity
@Root(strict = false, name = "person")
public class Person extends GenericModel {

    @Id
    @Required
    @Element(name="id")
    private Integer id;


    @Element(name="first-name")
    private String firstName;

    @Element(name="last-name")
    private String lastName;

    @Element(name="title", required = false)
    private String title;

    @Element(name="background", required = false)
    private String background;

    @Element(name="linkedin-url", required = false)
    private String linkedinUrl;

    @Element(name="avatar_url")
    private String avatarUrl;

    @Element(name="company-id", required = false)
    private Integer companyId;

    @Element(name="company-name", required = false)
    private String companyName;

    @Element(name="created-at")
    private String createdAt;

    @Element(name="updated-at")
    private String updatedAt;

    @Element(name="visible-to")
    private String visibleTo;

    @Element(name="author-id")
    private Integer authorId;

    @Element(name="group-id", required = false)
    private Integer groupId;

    @Element(name="owner-id", required = false)
    private Integer ownerId;

    @ElementList(required = false)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "persontag", joinColumns = {
        @JoinColumn(name = "personId", nullable = false, updatable = false) },
        inverseJoinColumns = { @JoinColumn(name = "tagId",
            nullable = false, updatable = false) })
    private List<Tag> tags;


    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getVisibleTo() {
        return visibleTo;
    }

    public void setVisibleTo(String visibleTo) {
        this.visibleTo = visibleTo;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Person{" +
            "authorId=" + authorId +
            ", id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", title='" + title + '\'' +
            ", background='" + background + '\'' +
            ", linkedinUrl='" + linkedinUrl + '\'' +
            ", avatarUrl='" + avatarUrl + '\'' +
            ", companyId=" + companyId +
            ", companyName='" + companyName + '\'' +
            ", createdAt='" + createdAt + '\'' +
            ", updatedAt='" + updatedAt + '\'' +
            ", visibleTo='" + visibleTo + '\'' +
            ", groupId=" + groupId +
            ", ownerId=" + ownerId +
            ", tags=" + tags +
            '}';
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Object _key() {
        return getId();
    }

    public static void saveData(Set<Person> persons){
        for(Person p: persons){
            Person person = Person.findById(p.getId());
            if(null == person){
                for(Tag t: p.getTags()){
                    Tag tag = Tag.findById(t.getId());
                    if(null == tag) t.save();
                }
            }
            p.save();
        }
    }

    public static List<Person> findData(String tagName){
        return  Person.find("SELECT p FROM Person p JOIN p.tags tag where tag.name = ?", tagName).fetch();
    }
}
