package models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import play.data.validation.Required;
import java.util.List;

@Root(strict = false, name = "person")
public class Person {

    @Required
    @Element(name="id")
    private Integer id;

    @Attribute(name = "type", required = false)
    private String type;

    @Required
    @Element(name="first-name")
    private String firstName;

    @Required
    @Element(name="last-name")
    private String lastName;

    @Element(name="title", required = false)
    private String title;

    @Element(name="background", required = false)
    private String background;

    @Required
    @Element(name="linkedin-url", required = false)
    private String linkedinUrl;

    @Required
    @Element(name="avatar_url")
    private String avatarUrl;

    @Required
    @Element(name="company-id", required = false)
    private Integer companyId;

    @Required
    @Element(name="company-name", required = false)
    private String companyName;

    @Required
    @Element(name="created-at")
    private String createdAt;

    @Required
    @Element(name="updated-at")
    private String updatedAt;

    @Required
    @Element(name="visible-to")
    private String visibleTo;

    @Required
    @Element(name="author-id")
    private Integer authorId;

    @Required
    @Element(name="group-id", required = false)
    private Integer groupId;

    @Required
    @Element(name="owner-id", required = false)
    private Integer ownerId;

    @ElementList(required = false)
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
